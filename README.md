# Mimerme-s-Util-Console
Utility console written in Java to run and download console modules easliy

#Features
- runs on Windows (can be modified/plans for multiplatform)
- small support for *NIX systems
- manages modules for Java Applications, similar to NPM or RubyGems
- universal and can be configured to run any application written in any language using batch scripts
- update-all modules, good for easy dependency management
- core-update module
- test APIs by running them as Java programs
- download modules from anywhere, including GitHub, Dropbox, and Google Drive (independent repo management)

#Problems
- Windows only (due to it running only batch scripts, shell scripts incomming)
- some bugs and code performance issues
- repetative code
- JDK compile level is 1.8 (a bit too high for my liking)

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

#Installing the utility console
1) Download the release.jar and release.bat both from the release folder

2) Add the release.bat to the PATH so that it can be called via 'release' in the console

3) type release and check for the version as well as branch and release name confirm that they are correct

#Installing a module
1) type 'release dwn '

NOTE: the module url must have a backslash and if release.jar/.bat is appended to the end it should redirect to the raw/download of the file

2) To update all modules type 'release update'

#Setting a module for download
NOTE: It is recomended that you create the proper custom batch script to make proper modifications to the user's system
as well as include detailed install instructions

1) Set up a repository and push release.jar and release.bat to the repository

2) link the base URL to the raw files, this is your module URL
ex. the module URL for this repository is

https://raw.githubusercontent.com/Mimerme/Mimerme-s-Util-Console/master/release/

NOTE: Try to keep the module  url consistant, if not then the .REPO files will be unable to manage your module's updates

#Forking this utility console
I will be using a utility console in many of my APIs for now on because if its simplicity to test APIs via unit testing.
When forking it is recomended to change the branch name, the author name, as well as the version to specify different forks
from each other, each with different features.

#TO-DO
- Complete support for Linux
