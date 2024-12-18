package ValiantPet;

import java.time.Duration;
import java.time.Instant;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class SearchbarPage {

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
            

            // Navigate to the login page
            WebElement searchbar = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='search-query']")));
            searchbar.click();
            Thread.sleep(2000);

        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + e.getMessage());
        } catch (TimeoutException e) {
            System.err.println("Timeout waiting for element: " + e.getMessage());
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
}
