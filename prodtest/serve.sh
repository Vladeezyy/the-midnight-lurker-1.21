#!/bin/sh
# Runs the NeoForge server in the current dir until "Done" or a crash (max 10 min), lets it run 60 s more (mob spawning,
# the mod's ticks), then stops it. Output: server.out
rm -f server.out
( i=0; until grep -qE 'Done \(|crash report has been saved|Crash report|Failed to start|Exception in server tick' server.out 2>/dev/null || [ $i -gt 300 ]; do sleep 2; i=$((i+1)); done; echo "time set midnight"; sleep 60; echo stop; sleep 30 ) | sh run.sh nogui > server.out 2>&1
grep -E 'Done \(|crash report has been saved|Crash report|Failed to start|Can.t keep up' server.out | head -5
grep -E 'Found mod file|Loading [0-9]+ mods' server.out | grep -iE "lurker|geckolib" | head -3 | cut -c1-160
echo "--- errors"
grep -E '/(ERROR|FATAL)\]' server.out | sed -E 's/^\[[^]]*\] //' | cut -c1-250 | sort | uniq -c | sort -rn | head -20
