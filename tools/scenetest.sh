#!/bin/sh
# Runs port/DevScene (max 15 min): a new world, every entity, the creative tab, the Lurker book. Prints the checks and
# the errors; SCENE_LANG=ru_ru for another language; screenshots in run/screenshots/scene_*.png.
. "$(dirname "$0")/common.sh"
rm -rf run/saves/ml_scene build-scene.log
# SCENE_LANG=ru_ru tools/scenetest.sh: the game language for the run (run/options.txt)
if [ -n "$SCENE_LANG" ]; then
	mkdir -p run && touch run/options.txt
	grep -v '^lang:' run/options.txt > run/options.tmp; echo "lang:$SCENE_LANG" >> run/options.tmp; mv run/options.tmp run/options.txt
fi
# Sodium / Iris (-Pwith_compat) cast the GPU device to GlDevice: NeoForge's dev validation layer has to be off
case "$*" in *with_compat*) sed -i 's/enableB3DValidationLayer = true/enableB3DValidationLayer = false/' run/config/neoforge-client.toml ;; esac
find run/screenshots -name 'scene_*.png' -delete 2>/dev/null
with_timeout 900 ./gradlew runScene --console=plain "$@" > build-scene.log 2>&1
code=$?
kill_game sceneRunProgramArgs
sed -i 's/enableB3DValidationLayer = false/enableB3DValidationLayer = true/' run/config/neoforge-client.toml 2>/dev/null
echo "exit $code"
grep -E '\[scene\] (CHECK|DONE|spawned)' build-scene.log | sed -E 's/^.*\[scene\] //'
echo "--- errors"
grep -E '/(ERROR|FATAL)\]|Caused by|Exception' build-scene.log | sed -E 's/^\[[^]]*\] //' | cut -c1-250 | sort | uniq -c | sort -rn | head -25
