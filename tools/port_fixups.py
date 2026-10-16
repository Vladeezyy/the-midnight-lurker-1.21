"""Midnight Lurker specific Forge 1.20.1 -> NeoForge 1.21.1 rewrites the shared port_java.py rules don't cover
(idempotent). Run after port_java.py:

    python3 -I tools/port_fixups.py src/main/java
"""
import os
import re
import sys

ROOT = sys.argv[1] if len(sys.argv) > 1 else 'src/main/java'
PKG = os.path.join(ROOT, 'net', 'mcreator', 'midnightlurker')
changed = set()


def edit(path, fn):
    s = open(path).read()
    t = fn(s)
    if t != s:
        open(path, 'w').write(t)
        changed.add(os.path.relpath(path, ROOT))


def entities(s):
    # leftovers of Forge's networking: the spawn packet constructor and imports
    s = re.sub(r'\nimport net\.minecraftforge\.network\.[\w.]+;', '', s)
    s = re.sub(r'\n\tpublic \w+\(PlayMessages\.SpawnEntity packet, Level world\) \{\n.*?\n\t\}\n', '\n', s, flags=re.S)
    s = re.sub(r'\n\t@Override\n\tpublic Packet<ClientGamePacketListener> getAddEntityPacket\(\) \{\n.*?\n\t\}\n', '\n', s, flags=re.S)
    # 1.20.5 removed MobType; every Lurker entity used UNDEFINED (no tag needed)
    s = re.sub(r'\n\t@Override\n\tpublic MobType getMobType\(\) \{\n\t\treturn MobType\.UNDEFINED;\n\t\}\n', '\n', s)
    s = s.replace('\nimport net.minecraft.world.entity.MobType;', '')
    # LivingEntity.getDimensions is final in 1.21: the size hook is getDefaultDimensions
    s = re.sub(r'public EntityDimensions getDimensions\(Pose (\w+)\)', r'protected EntityDimensions getDefaultDimensions(Pose \1)', s)
    s = re.sub(r'super\.getDimensions\((\w+)\)', r'super.getDefaultDimensions(\1)', s)
    return s


for dp, _, fs in os.walk(os.path.join(PKG, 'entity')):
    for f in fs:
        if f.endswith('.java'):
            edit(os.path.join(dp, f), entities)


def registry(s):
    # MCreator NeoForge: spawn placements are registered from RegisterSpawnPlacementsEvent, not common setup
    m = re.search(r'\t@SubscribeEvent\n\tpublic static void init\(FMLCommonSetupEvent event\) \{\n\t\tevent\.enqueueWork\(\(\) -> \{\n(.*?)\n\t\t\}\);\n\t\}', s, re.S)
    if not m:
        return s
    calls = re.findall(r'(\w+)\.init\(\);', m.group(1))
    body = ''.join('\t\t%s.init(event);\n' % c for c in calls)
    s = s.replace(m.group(0), '\t@SubscribeEvent\n\tpublic static void init(RegisterSpawnPlacementsEvent event) {\n%s\t}' % body)
    s = s.replace('import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;',
                  'import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;')
    return s


edit(os.path.join(PKG, 'init', 'MidnightlurkerModEntities.java'), registry)


def procedures(s):
    # block entity data copied across setBlock (MCreator): 1.21 needs the registries for item components
    s = s.replace('.saveWithFullMetadata();', '.saveWithFullMetadata(world.registryAccess());')
    s = re.sub(r'(\w+)\.load\((_bnbt\w*)\);', r'\1.loadWithComponents(\2, world.registryAccess());', s)
    return s


for f in os.listdir(os.path.join(PKG, 'procedures')):
    edit(os.path.join(PKG, 'procedures', f), procedures)


def block_entity(s):
    # MCreator NeoForge container block entity: registries in load / save, the item handler is a capability
    s = s.replace('private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());',
                  'private final SidedInvWrapper handler = new SidedInvWrapper(this, null);')
    s = s.replace('\tpublic void load(CompoundTag compound) {\n\t\tsuper.load(compound);',
                  '\tpublic void loadAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {\n\t\tsuper.loadAdditional(compound, lookupProvider);')
    s = s.replace('ContainerHelper.loadAllItems(compound, this.stacks);', 'ContainerHelper.loadAllItems(compound, this.stacks, lookupProvider);')
    s = s.replace('\tpublic void saveAdditional(CompoundTag compound) {\n\t\tsuper.saveAdditional(compound);',
                  '\tpublic void saveAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {\n\t\tsuper.saveAdditional(compound, lookupProvider);')
    s = s.replace('ContainerHelper.saveAllItems(compound, this.stacks);', 'ContainerHelper.saveAllItems(compound, this.stacks, lookupProvider);')
    s = s.replace('\tpublic CompoundTag getUpdateTag() {\n\t\treturn this.saveWithFullMetadata();',
                  '\tpublic CompoundTag getUpdateTag(HolderLookup.Provider lookupProvider) {\n\t\treturn this.saveWithFullMetadata(lookupProvider);')
    s = re.sub(r'\n\t@Override\n\tpublic <T> LazyOptional<T> getCapability\(.*?\n\t\}\n', '\n', s, flags=re.S)
    s = re.sub(r'\n\t@Override\n\tpublic void setRemoved\(\) \{\n\t\tsuper\.setRemoved\(\);\n\t\tfor \(LazyOptional.*?\n\t\}\n',
               '\n\tpublic SidedInvWrapper getItemHandler() {\n\t\treturn handler;\n\t}\n', s, flags=re.S)
    s = re.sub(r'\nimport net\.neoforged\.neoforge\.common\.(capabilities|util)\.\w+;', '', s)
    s = re.sub(r'\nimport net\.neoforged\.neoforge\.items\.IItemHandler;', '', s)
    if 'import net.minecraft.core.HolderLookup;' not in s:
        s = s.replace('import net.minecraft.core.NonNullList;', 'import net.minecraft.core.NonNullList;\nimport net.minecraft.core.HolderLookup;')
    return s


for f in os.listdir(os.path.join(PKG, 'block', 'entity')):
    edit(os.path.join(PKG, 'block', 'entity', f), block_entity)


def be_registry(s):
    if 'RegisterCapabilitiesEvent' in s:
        return s
    names = re.findall(r'public static final DeferredHolder<BlockEntityType<\?>, BlockEntityType<\?>> (\w+) = register\("\w+", \w+\.\w+, (\w+)::new\);', s)
    reg = ''.join('\t\tevent.registerBlockEntity(Capabilities.ItemHandler.BLOCK, %s.get(), (blockEntity, side) -> ((%s) blockEntity).getItemHandler());\n' % (n, c) for n, c in names)
    s = s.replace('public class MidnightlurkerModBlockEntities {',
                  '@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)\npublic class MidnightlurkerModBlockEntities {')
    s = s.rstrip()[:-1] + '\n\t@SubscribeEvent\n\tpublic static void registerCapabilities(RegisterCapabilitiesEvent event) {\n' + reg + '\t}\n}\n'
    s = s.replace('import net.minecraft.core.registries.Registries;\n', 'import net.minecraft.core.registries.Registries;\n\nimport net.neoforged.fml.common.EventBusSubscriber;\nimport net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;\nimport net.neoforged.neoforge.capabilities.Capabilities;\nimport net.neoforged.bus.api.SubscribeEvent;\n', 1)
    return s


edit(os.path.join(PKG, 'init', 'MidnightlurkerModBlockEntities.java'), be_registry)


def enchantments(s):
    # 1.21 enchantments are registry holders: "remove enchantment X from the stack" (MCreator 1.20.1 map round trip)
    pat = re.compile(r'Map<Enchantment, Integer> _enchantments = EnchantmentHelper\.getEnchantments\((?P<stack>.+?)\);\n'
                     r'(?P<ind>\s*)if \(_enchantments\.containsKey\((?P<ench>Enchantments\.\w+)\)\) \{\n'
                     r'\s*_enchantments\.remove\((?P=ench)\);\n'
                     r'\s*EnchantmentHelper\.setEnchantments\(_enchantments, (?P=stack)\);\n'
                     r'\s*\}')
    s = pat.sub(lambda m: 'EnchantmentHelper.updateEnchantments(%s, _ench -> _ench.removeIf(_e -> _e.is(%s)));' % (m.group('stack'), m.group('ench')), s)
    return s


def pickup(s):
    # NeoForge 1.21: EntityItemPickupEvent -> ItemEntityPickupEvent.Pre (fired before the pickup, like the old one)
    s = s.replace('import net.neoforged.neoforge.event.entity.player.EntityItemPickupEvent;', 'import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;')
    s = s.replace('public static void onPickup(EntityItemPickupEvent event) {\n\t\texecute(event, event.getEntity(), event.getItem().getItem());',
                  'public static void onPickup(ItemEntityPickupEvent.Pre event) {\n\t\texecute(event, event.getPlayer(), event.getItemEntity().getItem());')
    return s


for f in os.listdir(os.path.join(PKG, 'procedures')):
    edit(os.path.join(PKG, 'procedures', f), enchantments)
    edit(os.path.join(PKG, 'procedures', f), pickup)

# public classes whose file names differ in case only (built on Windows): javac wants the exact name
for dp, _, fs in os.walk(PKG):
    for f in fs:
        if not f.endswith('.java'):
            continue
        p = os.path.join(dp, f)
        m = re.search(r'^public (?:final |abstract )?(?:class|interface|record|enum) (\w+)', open(p).read(), re.M)
        if m and m.group(1) + '.java' != f and m.group(1).lower() + '.java' == f.lower():
            tmp = p + '.tmp'
            os.system('git mv "%s" "%s" && git mv "%s" "%s"' % (p, tmp, tmp, os.path.join(dp, m.group(1) + '.java')))
            changed.add('renamed ' + f + ' -> ' + m.group(1) + '.java')

print('changed', len(changed))
for c in sorted(changed):
    if c.startswith('renamed'):
        print(' ', c)
