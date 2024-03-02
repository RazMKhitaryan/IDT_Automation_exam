# Java Selenium Project

This Java Selenium project is designed for automated testing and includes configurations for Allure reporting, test parameters in the `config.properties` file, and logging using Log4j.

## Project Structure

- `allure-results`: Allure reports are generated and stored in this directory after running tests.
- `config.properties`: Set test parameters such as `BrowserType` (chrome, firefox, remote chrome, remote firefox), `BaseUrl`, and `HubUrl` for remote runs.
- `logs`: Includes two files - `app.log.txt` captures all test logs, and `userData.txt` stores recently created user data during tests. Screenshots of failing or skipping tests are saved in the `target/screenshots` folder.

## Running Tests

1. Configure `config.properties`:
    - Set `BrowserType` to choose between chrome, firefox, remote chrome, or remote firefox.
    - Specify `BaseUrl` for the test URL.
    - If running tests remotely, provide the `HubUrl` in the format `http://localhost:4445/wd/hub`.

2. For remote runs:
    - Execute `run_server.bat` before running tests.
    - Set `BrowserType` to "remote chrome" or "remote firefox" in `config.properties`.
    - Run tests either from an XML file, terminal, or using `test.bat`.

3. View Allure Reports:
    - After running tests, navigate to the `allure-results` folder.
    - Use the Allure CLI or open the HTML report directly for detailed test results.

## Logging

- `app.log.txt` in the `logs` folder captures all logs during test execution.
- `userData.txt` stores user data generated during tests.
- Screenshots of failing or skipping tests are saved in the `target/screenshots` folder.

Feel free to contribute or report issues. See the license for more details.

**Note:** Ensure dependencies are installed and configured before running tests.