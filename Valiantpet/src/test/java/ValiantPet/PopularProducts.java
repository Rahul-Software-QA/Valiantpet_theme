package ValiantPet;

import java.time.Duration;
import java.time.Instant;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class PopularProducts {

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

        Instant startTime = Instant.now();
        driver.get(baseUrl);
        Instant endTime = Instant.now();
        System.out.println("Page Load Time: " + Duration.between(startTime, endTime).toMillis() + " milliseconds");
    }

    @Test
    public void SigninTest() {
        try {
            // Handle popup
            try {
                WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("icon-newsletter-close")));
                closeButton.click();
                System.out.println("Popup closed.");
            } catch (TimeoutException e) {
                System.out.println("No popup appeared.");
            }

            // Scroll to Discover Favorites section
            scrollTo(0, 3000);

            // Click on the first product and wait for the update
            clickAndWaitForProductChange(
                "//div[@data-sec='first-sec']//span[@class='plus plus-one']//div[@class='plus-background']//*[name()='svg']",
                "Nutramax COSEQUIN for CATS Joint Health MAXIMUM STRENGTH"
            );

            // Click on the second product and wait for the update
            clickAndWaitForProductChange(
                "//span[@class='plus plus-two is-shown']//div[@class='plus-background']//*[name()='svg']",
                "Second Product Name Here" // Update with the expected name of the second product
            );

            // Click on the third product and wait for the update
            clickAndWaitForProductChange(
                "//span[@class='plus plus-four is-shown']//div[@class='plus-background']//*[name()='svg']",
                "Third Product Name Here" // Update with the expected name of the third product
            );

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private void scrollTo(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    @AfterTest
    public void teardown() {
        System.out.println("Closing the browser.");
        if (driver != null) {
            driver.quit();
        }
    }

    private void clickAndWaitForProductChange(String productXPath, String expectedProductName) {
        try {
            // Click the "+" icon
            WebElement productButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productXPath)));
            productButton.click();
            System.out.println("Clicked on product: " + expectedProductName);

            // Wait for the product details to update
            wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.cssSelector(".product-title"), // Update with the CSS selector for the product title
                expectedProductName
            ));
            System.out.println("Product details updated for: " + expectedProductName);

        } catch (TimeoutException e) {
            System.err.println("Timeout waiting for product change: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.err.println("Product element not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error during product selection: " + e.getMessage());
        }
    }
}
