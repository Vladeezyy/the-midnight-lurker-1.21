#!/usr/bin/env python3
"""Upload releases of the port to CurseForge (project 1751025). Dry run by default; --go uploads.
    python tools/cf_upload.py [--go] [mc versions...]
Per Minecraft version: the NeoForge jar of the GitHub release v<VER>+<mc> (downloaded with gh into a temp folder),
changelog = the GitHub release text, GeckoLib as a required dependency. The API token is read from
~/.gradle/gradle.properties (curseforgeToken=...) or the CF_TOKEN variable and is never printed."""
import json
import os
import subprocess
import sys
import tempfile
import urllib.request
import uuid

PROJECT = 1751025
VER = '3.3.7'
MC = {'1.21.1': 11779, '1.21.11': 14406, '26.1.2': 16082, '26.2': 16498, '26.3': 17045}
NEOFORGE = 10150
JAVA = {21: 11135, 25: 14454}
ENV = [9638, 9639]  # Client, Server


def token():
    t = os.environ.get('CF_TOKEN')
    if not t:
        p = os.path.expanduser('~/.gradle/gradle.properties')
        if os.path.exists(p):
            for line in open(p, encoding='utf-8'):
                if line.startswith('curseforgeToken='):
                    t = line.split('=', 1)[1].strip()
    if not t:
        sys.exit('no CurseForge token: put curseforgeToken=... into ~/.gradle/gradle.properties')
    return t


def upload(tok, meta, path):
    b = uuid.uuid4().hex
    body = (f'--{b}\r\nContent-Disposition: form-data; name="metadata"\r\n\r\n{json.dumps(meta)}\r\n'
            f'--{b}\r\nContent-Disposition: form-data; name="file"; filename="{os.path.basename(path)}"\r\n'
            f'Content-Type: application/octet-stream\r\n\r\n').encode() + open(path, 'rb').read() + f'\r\n--{b}--\r\n'.encode()
    req = urllib.request.Request(f'https://minecraft.curseforge.com/api/projects/{PROJECT}/upload-file', data=body,
                                 headers={'X-Api-Token': tok, 'Content-Type': f'multipart/form-data; boundary={b}'})
    with urllib.request.urlopen(req, timeout=300) as r:
        return json.load(r)['id']


def main():
    go = '--go' in sys.argv
    only = [a for a in sys.argv[1:] if not a.startswith('--')]
    tok = token() if go else None
    stage = tempfile.mkdtemp(prefix='ml-cf-')
    for mc, mcid in MC.items():
        if only and mc not in only:
            continue
        tag = f'v{VER}+{mc}'
        jar_name = f'the-midnight-lurker-neoforge-{VER}+{mc}.jar'
        subprocess.run(['gh', 'release', 'download', tag, '-p', jar_name, '-D', stage, '--clobber'], check=True)
        changelog = subprocess.run(['gh', 'release', 'view', tag, '--json', 'body', '-q', '.body'], check=True,
                                   capture_output=True, text=True, encoding='utf-8').stdout
        jar = os.path.join(stage, jar_name)
        java = 25 if mc.startswith('26.') else 21
        meta = {'changelog': changelog, 'changelogType': 'markdown', 'releaseType': 'release',
                'displayName': f'The Midnight Lurker {VER} (NeoForge {mc})',
                'gameVersions': [mcid, NEOFORGE, JAVA[java]] + ENV,
                'relations': {'projects': [{'slug': 'geckolib', 'type': 'requiredDependency'}]}}
        print(f'{mc:8} {jar_name} ({os.path.getsize(jar)} B) | versions {meta["gameVersions"]} | changelog {len(changelog)} chars')
        if go:
            print(f'         uploaded file {upload(tok, meta, jar)}')
    if not go:
        print('\ndry run; --go uploads')


if __name__ == '__main__':
    main()
