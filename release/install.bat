@ECHO off
echo "Running jUtils batch installer"
echo "Setting PATH"
SET PATH=%PATH%;%~dp0
echo "Adding UTILS_PATH"
setx UTILS_PATH %~dp0
PAUSE