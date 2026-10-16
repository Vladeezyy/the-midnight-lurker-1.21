"""lang_todo.py LANG [CHUNK] [SIZE]: prints the English entries LANG still lacks (missing, or identical to English),
CHUNK-th slice of SIZE entries, as JSON. Uses the merged result in src/main/resources plus tools/lang/LANG.json."""
import json, os, re, sys
L = sys.argv[1]; chunk = int(sys.argv[2]) if len(sys.argv) > 2 else 0; size = int(sys.argv[3]) if len(sys.argv) > 3 else 250
A = 'src/main/resources/assets/midnightlurker/lang/'
en = json.load(open(A + 'en_us.json', encoding='utf-8'))
en.update(json.load(open('tools/lang/en_us.json', encoding='utf-8')))
have = json.load(open(A + L + '.json', encoding='utf-8')) if os.path.exists(A + L + '.json') else {}
if os.path.exists('tools/lang/%s.json' % L): have.update(json.load(open('tools/lang/%s.json' % L, encoding='utf-8')))
keep = set(open('tools/lang/untranslatable.txt').read().split()) if os.path.exists('tools/lang/untranslatable.txt') else set()
cjk = L.split('_')[0] in ('zh', 'ja', 'ko')
def untranslated(k, v):
    if k not in have or not have[k].strip(): return bool(v.strip())
    if cjk: return bool(re.search(r'[A-Za-z]{3}', re.sub(r'\u00a7.', '', v))) and not re.search(r'[\u3000-\u9fff\uac00-\ud7af]', have[k])
    return have[k] == v and bool(re.search(r'[A-Za-z]{3}', v))
todo = {k: v for k, v in en.items() if k not in keep and not k.endswith('.author') and untranslated(k, v)}
items = list(todo.items())
print('# %d to do, chunk %d of %d' % (len(items), chunk, (len(items) + size - 1) // size), file=sys.stderr)
print(json.dumps(dict(items[chunk * size:(chunk + 1) * size]), ensure_ascii=False, indent=0))
