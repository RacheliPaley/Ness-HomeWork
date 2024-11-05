Selenium WebDriver Java Test Project
Overview
This project is an automated test suite using Selenium WebDriver and Java for testing the login functionality of the Sauce Demo website. The tests are organized and run using TestNG. Test results and steps are logged to a file for tracking the success or failure of each test.

Project Structure
LoginTest.java: The main test class that includes:
testLogin: Verifies that a standard user can log in successfully.
testLockedOutUserLogin: Checks that a locked-out user receives an appropriate error message.
test-results.log: A log file capturing test steps, results, and exceptions.
Prerequisites
Java JDK 1.8 or higher
Selenium WebDriver
TestNG testing framework
Google Chrome and ChromeDriver
Setup and Installation
Clone the repository:

bash
Copy code
git clone https://github.com/RacheliPaley/Ness-HomeWork.git
cd Ness-HomeWork
Ensure that ChromeDriver is installed and the path is set correctly in the code:

java
Copy code
System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
Add TestNG to your project:

If you're using IntelliJ IDEA, right-click on the project, go to Add Library, and select TestNG.
Running the Tests
Run the tests using TestNG from your IDE or execute the following command if using a build tool:

bash
Copy code
mvn test
Test Details
testLogin

Purpose: Ensures that a standard user can log in and access the inventory page.
Verification: Checks if the URL changes to /inventory.html after login.
testLockedOutUserLogin

Purpose: Validates that a locked-out user is shown the correct error message.
Verification: Checks for the error message "Epic sadface: Sorry, this user has been locked out."
Log Output
All test steps and results are logged in test-results.log. The log includes:

Timestamps for each log entry.
Details about the test steps and results.
Any exceptions encountered during the test run.
Example Log Entry:

yaml
Copy code
[2024-11-05 15:30:00] Test started: testLogin
[2024-11-05 15:30:05] Step: Navigated to https://www.saucedemo.com
[2024-11-05 15:30:10] Step: Entered credentials for standard_user
[2024-11-05 15:30:15] Step: Clicked login button
[2024-11-05 15:30:20] Test passed: Login was successful. Current URL: https://www.saucedemo.com/inventory.html
Author
Rachel Paley
