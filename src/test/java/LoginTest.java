import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoginTest {
    private WebDriver driver;

    // This method sets up the WebDriver before any test is run
    @BeforeClass
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        // Initialize the ChromeDriver instance
        driver = new ChromeDriver();
        logTestStep("Browser setup completed");
    }

    // Test to validate login functionality with valid credentials
    @Test
    public void testLogin() {
        logTestStep("Test started: testLogin");
        try {
            // Step 1: Navigate to the website
            driver.get("https://www.saucedemo.com");
            logTestStep("Navigated to https://www.saucedemo.com");
            Thread.sleep(2000);

            // Step 2: Enter username and password
            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));
            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");
            logTestStep("Entered credentials for standard_user");
            Thread.sleep(2000);

            // Step 3: Click the login button
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
            logTestStep("Clicked the login button");
            Thread.sleep(2000);

            // Step 4: Verify that the URL is correct after login
            String expectedUrl = "https://www.saucedemo.com/inventory.html";
            String currentUrl = driver.getCurrentUrl();
            logTestStep("Current URL checked: " + currentUrl);

            // Log the result and assert the URL
            if (expectedUrl.equals(currentUrl)) {
                writeToFile("Test passed: Login was successful. Current URL: " + currentUrl);
            } else {
                writeToFile("Test failed: Login failed. Current URL: " + currentUrl);
            }

            Assert.assertEquals(currentUrl, expectedUrl, "Login failed. Current URL: " + currentUrl);
        } catch (Exception e) {
            writeToFile("Test encountered an exception: " + e.getMessage());
            e.printStackTrace();
            // captureScreenshot("testLogin_failure"); // Commented out
        }
    }

    // Test to validate login with a locked-out user
    @Test
    public void testLockedOutUserLogin() {
        logTestStep("Test started: testLockedOutUserLogin");
        try {
            // Step 1: Navigate to the website
            driver.get("https://www.saucedemo.com");
            logTestStep("Navigated to https://www.saucedemo.com");
            Thread.sleep(2000);

            // Step 2: Enter username and password for a locked-out user
            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));
            usernameField.sendKeys("locked_out_user");
            passwordField.sendKeys("secret_sauce");
            logTestStep("Entered credentials for locked_out_user");
            Thread.sleep(2000);

            // Step 3: Click the login button
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
            logTestStep("Clicked the login button");
            Thread.sleep(2000);

            // Step 4: Verify that the correct error message is displayed
            WebElement errorMessage = driver.findElement(By.cssSelector("[data-test='error']"));
            String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
            logTestStep("Error message checked: " + errorMessage.getText());

            // Log the result and assert the error message
            if (errorMessage.getText().equals(expectedErrorMessage)) {
                writeToFile("Test passed: Correct error message displayed for locked_out_user.");
            } else {
                writeToFile("Test failed: Incorrect error message displayed for locked_out_user.");
            }

            Assert.assertEquals(errorMessage.getText(), expectedErrorMessage, "Error message mismatch.");
        } catch (Exception e) {
            writeToFile("Test encountered an exception: " + e.getMessage());
            e.printStackTrace();
            // captureScreenshot("testLockedOutUserLogin_failure"); // Commented out
        }
    }

    // Method to handle test failures (without capturing a screenshot)
    @AfterMethod
    public void handleTestFailure(ITestResult result) {
        if (!result.isSuccess()) {
            logTestStep("Test failed: " + result.getName());
            // captureScreenshot(result.getName() + "_failure"); // Commented out
        }
    }

    // Method to write log messages to a file
    private void writeToFile(String message) {
        try (FileWriter writer = new FileWriter("test-results.log", true)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);
            writer.write("[" + formattedDateTime + "] " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to log test steps to the log file
    private void logTestStep(String message) {
        writeToFile("Step: " + message);
    }

    // Method to close the WebDriver after all tests have run
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            logTestStep("Closing the browser");
            driver.quit();
        }
    }
}
