#!/bin/sh
# Runs port/DevScene (max 15 min): a new world, every entity, the creative tab, the Lurker book. Prints the checks and
# the errors; screenshots in run/screenshots/scene_*.png.
cd "$(dirname "$0")/.."
rm -rf run/saves/ml_scene build-scene.log
find run/screenshots -name 'scene_*.png' -delete 2>/dev/null
perl -e 'alarm 900; exec @ARGV' ./gradlew runScene --console=plain "$@" > build-scene.log 2>&1
code=$?
pkill -f 'build/moddev/sceneRunProgramArgs' 2>/dev/null
echo "exit $code"
grep -E '\[scene\] (CHECK|DONE|spawned)' build-scene.log | sed -E 's/^.*\[scene\] //'
echo "--- errors"
grep -E '/(ERROR|FATAL)\]|Caused by|Exception' build-scene.log | sed -E 's/^\[[^]]*\] //' | cut -c1-250 | sort | uniq -c | sort -rn | head -25
