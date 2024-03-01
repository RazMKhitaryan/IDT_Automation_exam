@echo off
cd %USERPROFILE%\Desktop\IDT_Automation_exam

:: Run Maven tests
call mvn test -DsuiteXmlFile=testng.xml

:: Serve Allure reports
allure serve

:: Terminate Java processes (if needed)
taskkill /F /IM java.exe