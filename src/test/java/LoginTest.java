import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to Chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        // Create an instance of WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        try {
            // Step 1: Navigate to the website
            driver.get("https://www.saucedemo.com");
            Thread.sleep(5000);
            // Step 2: Enter username and password
            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));
            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");
            Thread.sleep(5000);
            // Step 3: Click the login button
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
            Thread.sleep(5000);
            // Step 4: Verify that the URL is correct
            String expectedUrl = "https://www.saucedemo.com/inventory.html";
            String currentUrl = driver.getCurrentUrl();

            // Assert that the current URL matches the expected URL
            if (expectedUrl.equals(currentUrl)) {
                writeToFile("Test passed: Login was successful. Current URL: " + currentUrl);
            } else {
                writeToFile("Test failed: Login failed. Current URL: " + currentUrl);
            }
            Assert.assertEquals(currentUrl, expectedUrl, "Login failed. Current URL: " + currentUrl);

        } catch (Exception e) {
            writeToFile("Test encountered an exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    @Test
    public void testLockedOutUserLogin() {
        try {
            // Step 1: Navigate to the website
            driver.get("https://www.saucedemo.com");
            Thread.sleep(5000);
            // Step 2: Enter username and password for locked_out_user
            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));
            usernameField.sendKeys("locked_out_user");
            passwordField.sendKeys("secret_sauce");
            Thread.sleep(5000);
            // Step 3: Click the login button
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
            Thread.sleep(5000);
            // Step 4: Verify that the error message is displayed
            WebElement errorMessage = driver.findElement(By.cssSelector("[data-test='error']"));
            String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";

            if (errorMessage.getText().equals(expectedErrorMessage)) {
                writeToFile("Test passed: Correct error message displayed for locked_out_user.");
            } else {
                writeToFile("Test failed: Incorrect error message displayed for locked_out_user.");
            }

            Assert.assertEquals(errorMessage.getText(), expectedErrorMessage, "Error message mismatch.");

        } catch (Exception e) {
            writeToFile("Test encountered an exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private void writeToFile(String message) {
        try (FileWriter writer = new FileWriter("test-results.log", true)) {
            // Get current date and time
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            // Write message with date and time
            writer.write("[" + formattedDateTime + "] " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
