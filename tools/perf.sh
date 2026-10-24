#!/bin/sh
# Runs port/PerfScene (max 20 min): tools/perf.sh [-Pjfr]. Prints the [perf] lines and the errors.
. "$(dirname "$0")/common.sh"
rm -rf run/saves/ml_perf build-perf.log run/perf.jfr
with_timeout 1200 ./gradlew runPerf --console=plain "$@" > build-perf.log 2>&1
code=$?
kill_game perfRunProgramArgs
echo "exit $code"
grep -E '\[perf\] (PERF|DONE|[0-9]+ Lurker)' build-perf.log | sed -E 's/^.*\[perf\] //'
echo "--- errors"
grep -E '/(ERROR|FATAL)\]|Caused by|Exception' build-perf.log | sed -E 's/^\[[^]]*\] //' | cut -c1-250 | sort | uniq -c | sort -rn | head -15
