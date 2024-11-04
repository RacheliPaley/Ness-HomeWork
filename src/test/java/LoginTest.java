import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to Chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe"); // Change to the correct path
        // Create an instance of WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        // Step 1: Navigate to the website
        driver.get("https://www.saucedemo.com");

        // Step 2: Enter username and password
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        // Step 3: Click the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Step 4: Verify that the URL is correct
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String currentUrl = driver.getCurrentUrl();

        // Assert that the current URL matches the expected URL
        Assert.assertEquals(currentUrl, expectedUrl, "Login failed. Current URL: " + currentUrl);
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
