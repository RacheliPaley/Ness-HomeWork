# Selenium WebDriver Java Test Project

## Overview
This project is an automated test suite built with **Selenium WebDriver** and **Java** for testing the login functionality on the [Sauce Demo](https://www.saucedemo.com) website. The tests use **TestNG** for organization and execution, with all test steps and results logged to a file to provide a detailed report of each test's success or failure.

## Project Structure

- **LoginTest.java**: The main test class containing:
  - `testLogin`: Verifies that a standard user can log in successfully.
  - `testLockedOutUserLogin`: Checks that a locked-out user receives an appropriate error message.
- **test-results.log**: Log file capturing all test steps, results, and any encountered exceptions.

## Prerequisites

- **Java JDK 1.8** or higher
- **Selenium WebDriver**
- **TestNG** testing framework
- **Google Chrome** browser and **ChromeDriver**

## Setup and Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/RacheliPaley/Ness-HomeWork.git
   cd Ness-HomeWork
   ```

2. **Set ChromeDriver path**: Update the code to set the path for ChromeDriver:
   ```java
   System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
   ```

3. **Add TestNG**:
   - If using IntelliJ IDEA, right-click on the project, go to `Add Library`, and select `TestNG`.

## Running the Tests

Run the tests using TestNG from your IDE, or execute the following command if using a build tool like Maven:
```bash
mvn test
```

## Test Details

1. **testLogin**
   - **Purpose**: Ensures that a standard user can log in and access the inventory page.
   - **Verification**: Checks if the URL changes to `/inventory.html` after login.

2. **testLockedOutUserLogin**
   - **Purpose**: Validates that a locked-out user is shown the correct error message.
   - **Verification**: Confirms the error message "Epic sadface: Sorry, this user has been locked out."

## Log Output

All test steps and results are logged in `test-results.log`. This log includes:

- Timestamps for each log entry
- Details about the test steps and results
- Any exceptions encountered during the test run

### Example Log Entry

```yaml
[2024-11-05 15:30:00] Test started: testLogin
[2024-11-05 15:30:05] Step: Navigated to https://www.saucedemo.com
[2024-11-05 15:30:10] Step: Entered credentials for standard_user
[2024-11-05 15:30:15] Step: Clicked login button
[2024-11-05 15:30:20] Test passed: Login was successful. Current URL: https://www.saucedemo.com/inventory.html
```

## Contribution

Contributions are welcome! Fork the repository, create a feature branch, and submit a pull request with your changes.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

## Author
Rachl Paley
