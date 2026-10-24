#!/bin/sh
# Runs the NeoForge server in the current dir until "Done" or a crash (max 10 min), lets it run 60 s more (mob spawning,
# the mod's ticks), then stops it. Output: server.out
rm -f server.out
# Git Bash on Windows: run.sh wants unix_args.txt, the Windows server reads win_args.txt
RUN="sh run.sh"
case "$(uname -s)" in MINGW* | MSYS* | CYGWIN*) RUN="${JAVA_HOME:+$JAVA_HOME/bin/}java @user_jvm_args.txt @$(ls libraries/net/neoforged/neoforge/*/win_args.txt | head -1)" ;; esac
( i=0; until grep -qE 'Done \(|crash report has been saved|Crash report|Failed to start|Exception in server tick' server.out 2>/dev/null || [ $i -gt 300 ]; do sleep 2; i=$((i+1)); done; echo "time set midnight"; sleep 60; echo stop; sleep 30 ) | $RUN nogui > server.out 2>&1
grep -E 'Done \(|crash report has been saved|Crash report|Failed to start|Can.t keep up' server.out | head -5
grep -E 'Found mod file|Loading [0-9]+ mods' server.out | grep -iE "lurker|geckolib" | head -3 | cut -c1-160
echo "--- errors"
grep -E '/(ERROR|FATAL)\]' server.out | sed -E 's/^\[[^]]*\] //' | cut -c1-250 | sort | uniq -c | sort -rn | head -20
