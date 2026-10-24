"""errlist.py [LOG] [OUT]: unique javac errors as 'file:line message symbol' (Windows or Unix paths), counts per
package. Gradle prints every error twice on Windows; duplicates are dropped."""
import collections
import re
import sys

log = sys.argv[1] if len(sys.argv) > 1 else 'build-compile.log'
lines = open(log, errors='replace').read().split('\n')
seen = set(); out = []; per = collections.Counter()
for i, l in enumerate(lines):
    m = re.match(r'.*[/\\]midnightlurker[/\\](.+?\.java):(\d+): error: (.*)', l)
    if not m:
        continue
    f = m.group(1).replace('\\', '/')
    key = (f, m.group(2), m.group(3))
    if key in seen:
        continue
    seen.add(key)
    per[f.split('/')[0]] += 1
    sym = next((lines[j].strip() for j in range(i + 1, min(i + 5, len(lines))) if 'symbol:' in lines[j]), '')
    out.append('%s:%s %s %s' % (f, m.group(2), m.group(3)[:150], sym))
print(len(out), 'unique errors', dict(per))
if len(sys.argv) > 2:
    open(sys.argv[2], 'w').write('\n'.join(out) + '\n')
else:
    print('\n'.join(out[:120]))
