:: Run Maven tests
call mvn test

:: Serve Allure reports in the background
start allure serve

:: Terminate Java processes (if needed)
taskkill /F /IM java.exe
