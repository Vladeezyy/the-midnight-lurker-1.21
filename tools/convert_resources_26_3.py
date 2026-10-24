#!/usr/bin/env python3
"""Data 26.2 -> 26.3 for this mod, in place; running it again changes nothing. Run from the repo root:
    python tools/convert_resources_26_3.py
The converters are those of the Rats port (Vladeezyy/rats-1.21@mc/26.3:tools/port/convert_263.py), the parts this mod's
data needs: NeoForge add_spawns biome modifiers (spawner counts are int providers, "count") and loot tables (typed
conditions and functions, one "condition", "modifier", whole set_count numbers)."""
import json
import pathlib

DATA = pathlib.Path('src/main/resources/data/midnightlurker')


def whole(value):
    if isinstance(value, float) and value.is_integer():
        return int(value)
    if isinstance(value, dict):
        return {k: whole(v) for k, v in value.items()}
    return value


def spawner(s):
    if "minCount" not in s:
        return s
    low, high = s["minCount"], s["maxCount"]
    return {"type": s["type"], "count": low if low == high else {"type": "minecraft:uniform", "max_inclusive": high, "min_inclusive": low},
            "weight": s["weight"]}


def biome_modifier(obj):
    if obj.get("type") != "neoforge:add_spawns":
        return obj
    spawners = obj["spawners"]
    return {**obj, "spawners": [spawner(s) for s in spawners] if isinstance(spawners, list) else spawner(spawners)}


SILK = {"predicates": {"minecraft:enchantments": [{"enchantments": "minecraft:silk_touch", "levels": {"min": 1}}]}}
TOOL_NAMES = {json.dumps({"items": "minecraft:shears"}, sort_keys=True): "minecraft:tool/can_shear",
              json.dumps(SILK, sort_keys=True): "minecraft:tool/can_silk_touch"}


def condition(c):
    if isinstance(c, str):
        return c
    c = dict(c)
    if "condition" not in c:
        return c
    kind = c.pop("condition")
    if kind == "minecraft:match_tool" and json.dumps(c.get("predicate"), sort_keys=True) in TOOL_NAMES:
        return TOOL_NAMES[json.dumps(c["predicate"], sort_keys=True)]
    if kind == "minecraft:block_state_property":
        out = {"type": "minecraft:match_block", "blocks": c["block"]}
        if c.get("properties"):
            out["state"] = c["properties"]
        return out
    if kind in ("minecraft:any_of", "minecraft:all_of"):
        c["terms"] = [condition(t) for t in c["terms"]]
    if kind == "minecraft:inverted":
        c["term"] = condition(c["term"])
    return {"type": kind, **c}


def conditions(node):
    if "conditions" in node:
        terms = [condition(c) for c in node.pop("conditions")]
        node["condition"] = terms[0] if len(terms) == 1 else {"type": "minecraft:all_of", "terms": terms}


def loot(node):
    if isinstance(node, list):
        return [loot(n) for n in node]
    if not isinstance(node, dict):
        return node
    node = {k: (v if k in ("predicate", "properties", "state") else loot(v)) for k, v in node.items()}
    conditions(node)
    if "function" in node:
        node = {"type": node.pop("function"), **node}
        if node["type"] in ("minecraft:set_count", "set_count"):
            node["count"] = whole(node["count"])
            # 1.20 shorthand {"min", "max"} (uniform without a type) is no longer read
            if isinstance(node["count"], dict) and "type" not in node["count"] and {"min", "max"} <= set(node["count"]):
                node["count"] = {"type": "minecraft:uniform", **node["count"]}
            if node.get("add") is False:
                node.pop("add")
    if "functions" in node:
        functions = node.pop("functions")
        node["modifier"] = functions[0] if len(functions) == 1 else functions
    if isinstance(node.get("rolls"), float) and node["rolls"].is_integer():
        node["rolls"] = int(node["rolls"])
    if node.get("bonus_rolls") in (0, 0.0):
        node.pop("bonus_rolls")
    return node


def convert(folder, fn):
    n = 0
    for path in (DATA / folder).rglob('*.json'):
        obj = json.loads(path.read_text(encoding='utf-8'))
        new = fn(obj)
        if new != obj:
            path.write_text(json.dumps(new, indent=2) + '\n', encoding='utf-8', newline='\n')
            n += 1
    print(folder, n)


if __name__ == '__main__':
    convert('neoforge/biome_modifier', biome_modifier)
    convert('loot_table', loot)
