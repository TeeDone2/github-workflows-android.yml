@ECHO OFF
SET DIR=%~dp0
bash -lc "%DIR%/gradlew --no-daemon %*"
