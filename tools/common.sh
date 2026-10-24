#!/bin/sh
# Shared by the test scripts (macOS / Linux / Git Bash on Windows): a JDK for Gradle and stopping this checkout's game.
cd "$(dirname "$0")/.."
ROOT=$(pwd)

# The JDK of the MC version (gradle.properties java_version, else 25 for 26.x and 21 before): JAVA_HOME as is if it
# matches, else one Gradle downloaded (~/.gradle/jdks)
JV=$(sed -n 's/^java_version=//p' gradle.properties | tr -d '\r[:space:]')
[ -z "$JV" ] && case "$(sed -n 's/^minecraft_version=//p' gradle.properties)" in 26*) JV=25 ;; *) JV=21 ;; esac
if [ -z "$JAVA_HOME" ] || ! "$JAVA_HOME/bin/java" -version 2>&1 | grep -q "version \"$JV"; then
	for d in "$HOME"/.gradle/jdks/*-"$JV"-* "$HOME"/.gradle/jdks/*"$JV"*; do
		[ -x "$d/bin/java" ] || [ -x "$d/bin/java.exe" ] || continue
		JAVA_HOME=$d
		break
	done
	case "$(uname -s)" in MINGW* | MSYS* | CYGWIN*) JAVA_HOME=$(cygpath -w "$JAVA_HOME") ;; esac
	export JAVA_HOME
fi

# Kills the java processes whose command line contains $1 and this checkout (pkill does not see Windows processes)
kill_game() {
	case "$(uname -s)" in
	MINGW* | MSYS* | CYGWIN*)
		powershell.exe -NoProfile -Command "Get-CimInstance Win32_Process -Filter \"Name='java.exe'\" | Where-Object { \$_.CommandLine -match [regex]::Escape('$1') -and \$_.CommandLine -match [regex]::Escape('$(basename "$ROOT")') } | ForEach-Object { Stop-Process -Id \$_.ProcessId -Force }" 2>/dev/null
		;;
	*) pkill -f "$1" 2>/dev/null; sleep 2; pkill -9 -f "$1" 2>/dev/null ;;
	esac
}

# timeout <seconds> <command>... (macOS has no timeout)
with_timeout() {
	t=$1
	shift
	if command -v timeout >/dev/null 2>&1; then timeout "$t" "$@"; else perl -e "alarm $t; exec @ARGV" "$@"; fi
}
