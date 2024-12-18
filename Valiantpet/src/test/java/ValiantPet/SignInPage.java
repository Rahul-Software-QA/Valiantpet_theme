package ValiantPet;

import java.time.Duration;
import java.time.Instant;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class SignInPage {

    private String baseUrl = "https://valiant-pet-demo.mybigcommerce.com/";
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setup() {
        System.out.println("Setting up WebDriver and navigating to the login page.");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Measure page load time
        Instant startTime = Instant.now();
        driver.get(baseUrl);
        Instant endTime = Instant.now();
        System.out.println("Page Load Time: " + Duration.between(startTime, endTime).toMillis() + " milliseconds");
    }

    @Test
    public void SigninTest() {
        try {

            // Close popup if present
            try {
                WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//i[@class='icon icon-newsletter-close']//*[name()='svg']")));
                closeButton.click();
                System.out.println("Popup closed.");
            } catch (Exception e) {
                System.out.println("No popup appeared.");
            }

            // Navigate to the login page
            WebElement yourAccount = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[normalize-space()='Your Account']")));
            yourAccount.click();
            Thread.sleep(2000);

            WebElement SignInButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[normalize-space()='Sign in']")));
            SignInButton.click();
            Thread.sleep(2000);

            // Enter username
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_email")));
            usernameField.sendKeys("valiant123@yopmail.com");
            Thread.sleep(2000);

            // Enter password
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_pass")));
            passwordField.sendKeys("Testing@123");
            Thread.sleep(2000);

            // Click login button
            WebElement SignIn1Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Sign in']")));
            SignIn1Button.click();
            Thread.sleep(2000);

            // Navigate to 'Your Account' section
            navigateToYourAccount("//a[@class='navUser-action needsclick']//span[contains(text(),'Your Account')]", "Your Account");
            Thread.sleep(2000);

            // Sign Out
            clickButton("//span[normalize-space()='Sign out']", "Sign Out");
            Thread.sleep(2000);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    @AfterTest
    public void teardown() {
        System.out.println("Closing the browser.");
        if (driver != null) {
            driver.quit();
        }
    }

    // Helper method to navigate to a specific section
    private void navigateToYourAccount(String xpath, String sectionName) {
        try {
            WebElement sectionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            sectionButton.click();
            System.out.println("Navigated to " + sectionName + " section.");
            smoothScrollBy(0, 200);
        } catch (Exception e) {
            System.err.println("Failed to navigate to " + sectionName + ": " + e.getMessage());
        }
    }

    // Helper method to click a button
    private void clickButton(String xpath, String buttonName) {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            button.click();
            System.out.println(buttonName + " clicked.");
            smoothScrollBy(0, 200);
        } catch (Exception e) {
            System.err.println("Failed to click " + buttonName + ": " + e.getMessage());
        }
    }

    // Helper method for smooth scrolling
    private void smoothScrollBy(int x, int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy({top: arguments[1], left: arguments[0], behavior: 'smooth'});", x, y);
        try {
            Thread.sleep(500); // Adjust delay as needed for better performance
        } catch (InterruptedException e) {
            System.err.println("Scrolling interrupted: " + e.getMessage());
        }
    }
}
