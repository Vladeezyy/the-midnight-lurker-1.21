#!/bin/sh
# Starts the dev server on a fresh world, waits until it is up or has failed (max 10 min), kills it, prints a summary.
. "$(dirname "$0")/common.sh"
kill_game serverRunProgramArgs
rm -rf run/world build-server.log
mkdir -p run && echo 'eula=true' > run/eula.txt
./gradlew runServer --console=plain > build-server.log 2>&1 &
i=0
until grep -qE 'Done \(|crash report has been saved|Minecraft Crash Report|Failed to start|Registry loading errors|BUILD FAILED|FAILED TO BIND' build-server.log 2>/dev/null || [ $i -gt 300 ]; do sleep 2; i=$((i+1)); done
sleep 3
kill_game serverRunProgramArgs
wait 2>/dev/null
[ $i -gt 300 ] && echo "TIMEOUT (no Done / crash in 10 min)"
grep -E 'Done \(|Minecraft Crash Report|Failed to start|Registry loading errors|FAILED TO BIND' build-server.log | head -3
echo "--- errors"
grep -E '/(ERROR|FATAL)\]|Caused by|Exception:' build-server.log | sed -E 's/^\[[^]]*\] //' | cut -c1-300 | sort | uniq -c | sort -rn | head -${1:-40}
