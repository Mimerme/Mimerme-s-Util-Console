# Mimerme-s-Util-Console
Utility console written in Java to run and download console modules easliy

#Features
- runs on Windows (can be modified/plans for multiplatform)
- manages modules for Java Applications, similar to NPM or RubyGems
- universal and can be configured to run any application written in any language using batch scripts
- all-update modules
- core-update module
- easy running of programs (release run [module]), no more Java -jar [module] -Xmx512M -Xms512M
- download modules from anywhere, including GitHub, Dropbox, and Google Drive (independent repo management)

#Problems
- Windows only (due to it running only batch scripts, shell scripts incomming)
- some bugs and code performance issues
- repetative code

#Module Structure
To create a module you must include
- [MODULE].jar (executed by batch script)
- [MODULE].bat (executed by UtilConsole)
- [MODULE].REPO - contains the link that can lead to release.jar and release.bat

Structure
=========
UtilConsole
|
--|release.jar
--|release.bat
--|release.REPO
--|[MODULE]
----|[MODULE].REPO
----|[MODULE].jar
----|[MODULE].bat

#Commands
NOTE: You must add the batch file to your PATH

release dwn [URL] [MODULE_LOCAL_SAVE_NAME] - downloads module and saves it

release run [MODULE] - runs the specified module

release update - updates all the modules

release update main - updates the module manager
