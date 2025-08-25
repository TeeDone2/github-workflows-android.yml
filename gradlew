#!/usr/bin/env sh
# Minimal gradlew launcher. Android Studio can regenerate a full wrapper if needed.
DIR="$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)"
exec bash -lc "$DIR/gradlew --no-daemon $@"
