#!/bin/bash
clear
echo "Running UtilConsole install script"
SCRIPT_PATH=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
echo "\nSetting UTILS_PATH @ $SCRIPT_PATH"
export UTILS_PATH=$SCRIPT_PATH
echo "Adding jutils to /bin"
sudo touch "/bin/jutils.sh"
echo -e -n "#!/bin/bash" | sudo tee "/bin/jutils.sh"
echo -e -n "\n" | sudo tee "/bin/jutils.sh"
echo -e -n "java -jar $UTILS_PATH/release.jar" | sudo tee "/bin/jutils.sh"
echo "Converting jutils.sh to executable"
sudo chmod +x "/bin/jutils.sh"
echo "Renaming jutils.sh to jutils"
sudo mv /bin/jutils.sh /bin/jutils
echo "You should now be able to run the UtilConsole through terminal with command 'jutils'"
echo "Testing jutils, the console should now output the version"
jutils
