"""Forge 1.20.1 MCreator armor items (anonymous ArmorMaterial) -> 1.21.1 registered ArmorMaterial (NeoForge MCreator style).

Usage: python3 -I tools/port_armor.py <file.java> ...
"""
import re, sys
sys.path.insert(0, __file__.rsplit('/', 1)[0])
from port_java import match_paren, add_imports, IMPORTS

SLOT_INDEX = {'BOOTS': 0, 'LEGGINGS': 1, 'CHESTPLATE': 2, 'HELMET': 3}  # EquipmentSlot#getIndex for armor slots

IMPORTS.update({
    'EnumMap': 'java.util.EnumMap', 'Util': 'net.minecraft.Util', 'RegisterEvent': 'net.neoforged.neoforge.registries.RegisterEvent',
    'SubscribeEvent': 'net.neoforged.bus.api.SubscribeEvent', 'List': 'java.util.List',
    'ArmorMaterial': 'net.minecraft.world.item.ArmorMaterial', 'Holder': 'net.minecraft.core.Holder',
})


def ret(body, name):
    m = re.search(r'public \w+ %s\([^)]*\) \{\s*return ([^;]+);' % name, body)
    return m.group(1).strip()


def convert(s):
    m = re.search(r'super\(new ArmorMaterial\(\) \{', s)
    if not m: return s
    ob = m.end() - 1; cb = match_paren(s, ob)
    body = s[ob:cb + 1]
    dur = re.search(r'return new int\[\]\{([^}]*)\}\[type\.getSlot\(\)\.getIndex\(\)\] \* (\d+);', body)
    dur_arr = [int(x) for x in dur.group(1).split(',')]; dur_mul = int(dur.group(2))
    dfn = re.search(r'return new int\[\]\{([^}]*)\}\[type\.getSlot\(\)\.getIndex\(\)\];', body)
    def_arr = [int(x) for x in dfn.group(1).split(',')]
    ench = ret(body, 'getEnchantmentValue')
    sound = re.search(r'getEquipSound\(\) \{\s*return BuiltInRegistries\.SOUND_EVENT\.get\(ResourceLocation\.parse\("([^"]*)"\)\);', body)
    sound_id = sound.group(1) if sound else ''
    repair = ret(body, 'getRepairIngredient')
    name = ret(body, 'getName').strip('"')
    tough = ret(body, 'getToughness'); kb = ret(body, 'getKnockbackResistance')

    # armor textures per piece -> one layer + overrides for pieces that differ
    textures = {}
    for cm in re.finditer(r'public static class (\w+) extends \w+ \{', s):
        ce = match_paren(s, cm.end() - 1); cls = s[cm.start():ce]
        t = re.search(r'ArmorItem\.Type\.(\w+)', cls)
        tex = re.search(r'getArmorTexture\([^)]*\) \{\s*return "([^"]+)";', cls)
        if t and tex: textures[t.group(1)] = tex.group(1)
    layer = None
    for v in textures.values():
        mm = re.match(r'([\w.-]+):textures/models/armor/(.+)_layer_[12]\.png$', v)
        if mm: layer = layer or '%s:%s' % (mm.group(1), mm.group(2))
    if layer is None: layer = 'midnightlurker:' + name

    def expected(typ):
        ns, path = layer.split(':')
        return '%s:textures/models/armor/%s_layer_%d.png' % (ns, path, 2 if typ == 'LEGGINGS' else 1)

    defense = {t: def_arr[i] for t, i in SLOT_INDEX.items()}
    lines = ['\t\t\t\tmap.put(ArmorItem.Type.%s, %d);' % (t, defense[t]) for t in ('BOOTS', 'LEGGINGS', 'CHESTPLATE', 'HELMET')]
    lines.append('\t\t\t\tmap.put(ArmorItem.Type.BODY, %d);' % defense['CHESTPLATE'])
    sound_expr = 'DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("%s"))' % sound_id if sound_id else 'SoundEvents.ARMOR_EQUIP_GENERIC'
    reg = ('\tpublic static Holder<ArmorMaterial> ARMOR_MATERIAL = null;\n\n'
           '\t@SubscribeEvent\n'
           '\tpublic static void registerArmorMaterial(RegisterEvent event) {\n'
           '\t\tevent.register(Registries.ARMOR_MATERIAL, registerHelper -> {\n'
           '\t\t\tArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {\n'
           + '\n'.join(lines) + '\n'
           '\t\t\t}), %s, %s, () -> %s,\n'
           '\t\t\t\t\tList.of(new ArmorMaterial.Layer(ResourceLocation.parse("%s"))), %s, %s);\n'
           '\t\t\tregisterHelper.register(ResourceLocation.parse("midnightlurker:%s"), armorMaterial);\n'
           '\t\t\tARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);\n'
           '\t\t});\n'
           '\t}\n\n') % (ench, sound_expr, repair, layer, tough, kb, name)
    s = s[:m.start()] + 'super(ARMOR_MATERIAL' + s[cb + 1:]
    # class annotation + registry block
    cm = re.search(r'\npublic abstract class (\w+) extends ArmorItem( implements [\w, ]+)? \{\n', s)
    s = s[:cm.start()] + '\n@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)' + s[cm.start():cm.end()] + reg + s[cm.end():]
    # durability on each piece, armor texture overrides
    def piece(mm):
        typ = mm.group(1)
        d = dur_arr[SLOT_INDEX[typ]] * dur_mul
        return 'super(ArmorItem.Type.%s, new Item.Properties().durability(%d)' % (typ, d)
    s = re.sub(r'super\(ArmorItem\.Type\.(\w+), new Item\.Properties\(\)', piece, s)

    def tex(mm):
        cls_start = s.rfind('public static class', 0, mm.start())
        t = re.search(r'ArmorItem\.Type\.(\w+)', s[cls_start:mm.start()]).group(1)
        if textures.get(t) == expected(t):
            return ''
        return ('\n\n\t\t@Override\n\t\tpublic ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {\n'
                '\t\t\treturn ResourceLocation.parse("%s");\n\t\t}' % textures[t])
    s = re.sub(r'\n\n\t\t@Override\n\t\tpublic String getArmorTexture\(ItemStack stack, Entity entity, EquipmentSlot slot, String type\) \{\s*return "[^"]+";\s*\}', tex, s)
    return add_imports(s)


if __name__ == '__main__':
    for p in sys.argv[1:]:
        s = open(p, encoding='utf-8').read(); t = convert(s)
        if t != s: open(p, 'w', encoding='utf-8').write(t); print('converted', p)
