package ValiantPet;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegisterPage {

    public String baseUrl = "https://valiant-pet-demo.mybigcommerce.com/";
    public ChromeDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    @BeforeTest
    public void setup() {
        System.out.println("Before Test executed");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        js = (JavascriptExecutor) driver;

        Instant start = Instant.now();
        driver.get(baseUrl);

        Instant end = Instant.now();
        long loadTime = Duration.between(start, end).toMillis();
        System.out.println("Page Load Time: " + loadTime + " milliseconds");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void RegisterTest() {
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

            // Navigate to registration page
            WebElement yourAccount = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[normalize-space()='Your Account']")));
            yourAccount.click();
            Thread.sleep(2000);

            WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[normalize-space()='Register']")));
            registerButton.click();
            Thread.sleep(2000);

            // Generate random data
            String randomEmail = "valiant" + generateRandomString(8) + "@yopmail.com";
            String randomPassword = "Test" + generateRandomString(5) + "@123";
            String randomFirstName = "First" + generateRandomString(4);
            String randomLastName = "Last" + generateRandomString(4);
            String randomPhone = "89" + generateRandomString(8, true);
            String randomAddressLine1 = "Street " + generateRandomString(3);
            String randomCity = "City" + generateRandomString(3);
            String randomZip = generateRandomString(5, true);

            // Enter registration details
            fillFieldWithScroll(By.xpath("//input[@id='FormField_1_input']"), randomEmail, "Email");
            fillField(By.xpath("//input[@id='FormField_2_input']"), randomPassword, "Password");
            fillFieldWithScroll(By.xpath("//input[@id='FormField_3_input']"), randomPassword, "Confirm Password");
            fillField(By.xpath("//input[@id='FormField_4_input']"), randomFirstName, "First Name");
            fillFieldWithScroll(By.xpath("//input[@id='FormField_5_input']"), randomLastName, "Last Name");
            fillField(By.xpath("//input[@id='FormField_6_input']"), "XYZ", "Company Name");
            fillFieldWithScroll(By.xpath("//input[@id='FormField_7_input']"), randomPhone, "Phone Number");
            fillField(By.xpath("//input[@id='FormField_8_input']"), randomAddressLine1, "Address Line 1");
            fillFieldWithScroll(By.xpath("//input[@id='FormField_9_input']"), "Apt 2", "Address Line 2");
            fillField(By.xpath("//input[@id='FormField_10_input']"), randomCity, "City");

            // Select Country
            smoothScroll(50);
            WebElement countryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='FormField_11_select']")));
            new Select(countryDropdown).selectByVisibleText("United States");
            Thread.sleep(1000);

            // Select State/Province
            smoothScroll(50);
            WebElement stateDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='FormField_12_input']")));
            new Select(stateDropdown).selectByVisibleText("California");
            Thread.sleep(1000);

            fillFieldWithScroll(By.xpath("//input[@id='FormField_13_input']"), randomZip, "Zip Code");

            // Handle captcha
            handleRecaptcha();

            // Click Create Account
            smoothScroll(50);
            WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Create Account']")));
            createAccountButton.click();
            Thread.sleep(2000);

            // Wait for Dashboard link and click it
            waitForDashboardLink();

            // Log out
            smoothScroll(50);
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Log out')]")));
            logoutButton.click();
        } catch (Exception e) {
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    // Method to wait for the 'Dashboard' link to be clickable
    private void waitForDashboardLink() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Set wait time
            // Wait until the Dashboard link is clickable
            WebElement dashboardLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[normalize-space()='Dashboard']")
            ));
            dashboardLink.click(); // Click on the Dashboard link
            System.out.println("Successfully clicked on Dashboard link.");
        } catch (Exception e) {
            System.out.println("Dashboard link not found or not clickable.");
        }
    }

    private void handleRecaptcha() {
        try {
            // Locate the reCAPTCHA checkbox and click it
            WebElement recaptchaCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='recaptcha-checkbox-border']")));
            recaptchaCheckbox.click();
            smoothScroll(50);

            // Scroll to the reCAPTCHA checkbox and click it using JavaScript
            js.executeScript("arguments[0].click();", recaptchaCheckbox);
            System.out.println("Clicked on reCAPTCHA checkbox.");

            // Optionally, check if the checkbox is checked (wait for reCAPTCHA validation)
            WebElement recaptchaResponse = driver.findElement(By.id("g-recaptcha-response"));
            int retryCount = 0;
            while (recaptchaResponse.getAttribute("value").isEmpty() && retryCount < 10) {
                Thread.sleep(3000);
                retryCount++;
            }
            System.out.println("reCAPTCHA successfully handled.");

        } catch (Exception e) {
            System.out.println("Captcha not found or skipped.");
        }
    }

    private void fillFieldWithScroll(By locator, String value, String fieldName) {
        try {
            smoothScroll(50);
            fillField(locator, value, fieldName);
        } catch (Exception e) {
            Assert.fail("Validation failed for " + fieldName);
        }
    }

    private void fillField(By locator, String value, String fieldName) {
        try {
            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            field.clear();
            field.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("Validation failed for " + fieldName);
        }
    }

    private String generateRandomString(int length) {
        return generateRandomString(length, false);
    }

    private String generateRandomString(int length, boolean numericOnly) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        String characters = numericOnly ? "0123456789" : CHARACTERS;
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    public void smoothScroll(int pixels) {
        js.executeScript("window.scrollBy({ top: " + pixels + ", behavior: 'smooth' });");
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
