"""lang_add.py LANG FILE: merges the JSON object in FILE into tools/lang/LANG.json (sorted)."""
import json, os, sys
L, f = sys.argv[1], sys.argv[2]; p = 'tools/lang/%s.json' % L
cur = json.load(open(p, encoding='utf-8')) if os.path.exists(p) else {}
add = json.load(open(f, encoding='utf-8')); cur.update(add)
with open(p, 'w', encoding='utf-8') as fh:
    json.dump(dict(sorted(cur.items())), fh, indent=2, ensure_ascii=False); fh.write('\n')
print(L, '+%d' % len(add), 'total', len(cur))
