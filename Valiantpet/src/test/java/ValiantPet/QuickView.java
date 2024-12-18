package ValiantPet;

import java.time.Duration;
import java.time.Instant;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class QuickView {

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
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 2200)");
            System.out.println("Scrolled to Discover Favorites.");

            // Locate Discover Favorites element and scroll to it
            WebElement discoverFavorites = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("body > main:nth-child(7) > div:nth-child(5) > div:nth-child(2) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > article:nth-child(1) > figure:nth-child(1) > figcaption:nth-child(4) > div:nth-child(1) > button:nth-child(1) > svg:nth-child(1) > use:nth-child(1)"))); // Replace with accurate class or data attribute
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", discoverFavorites);
            System.out.println("Scrolled to Discover Favorites.");

            // Hover and click on Discover Favorites
            Actions actions = new Actions(driver);
            actions.moveToElement(discoverFavorites).click().perform();
            System.out.println("Hovered over and clicked Discover Favorites.");

            // Close modal
            WebElement closeModalButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("body > div:nth-child(26) > button:nth-child(1) > span:nth-child(2)")));
            closeModalButton.click();
            System.out.println("Modal closed.");

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
