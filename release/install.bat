@ECHO off
echo "Running jUtils batch installer"
echo "Adding UTILS_PATH"
setx UTILS_PATH %~dp0
set PATH=%PATH%;%UTILS_PATH%
echo "Setting PATH"
setx PATH %UTILS_PATH%
PAUSE
