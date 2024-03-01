@echo off

:: Set the project path on the desktop
set "projectPath=%USERPROFILE%\Desktop"

:: Navigate to the project's Bat files directory
cd "%projectPath%\Bat files"

:: Run the selenium server
java -jar "%projectPath%\selenium-server-4.18.1.jar" standalone --port 4445