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
