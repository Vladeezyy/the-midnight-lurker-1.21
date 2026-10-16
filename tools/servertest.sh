#!/bin/sh
# Starts the dev server on a fresh world, waits until it is up or has failed (max 10 min), kills it, prints a summary.
cd "$(dirname "$0")/.."
pkill -f 'fml.modFolders=midnightlurker.*server' 2>/dev/null; pkill -f "devlaunch.*server" 2>/dev/null; while lsof -tnP -iTCP:25599 -sTCP:LISTEN >/dev/null 2>&1; do sleep 1; done
rm -rf run/world build-server.log
./gradlew runServer --console=plain > build-server.log 2>&1 &
i=0
until grep -qE 'Done \(|crash report has been saved|Minecraft Crash Report|Failed to start|Registry loading errors|BUILD FAILED|FAILED TO BIND' build-server.log 2>/dev/null || [ $i -gt 300 ]; do sleep 2; i=$((i+1)); done
sleep 3
pkill -f 'fml.modFolders=midnightlurker' 2>/dev/null; sleep 2; pkill -9 -f 'fml.modFolders=midnightlurker' 2>/dev/null
wait 2>/dev/null
[ $i -gt 300 ] && echo "TIMEOUT (no Done / crash in 10 min)"
grep -E 'Done \(|Minecraft Crash Report|Failed to start|Registry loading errors|FAILED TO BIND' build-server.log | head -3
echo "--- errors"
grep -E '/(ERROR|FATAL)\]|Caused by|Exception:' build-server.log | sed -E 's/^\[[^]]*\] //' | cut -c1-300 | sort | uniq -c | sort -rn | head -${1:-40}
