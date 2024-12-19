package ValiantPet;

import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CampareList {

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
            closePopupIfPresent();

            // Scroll to Discover Favorites section
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 2200)");
            System.out.println("Scrolled to Discover Favorites.");
            
            // Locate Discover Favorites element and scroll to it
            WebElement discoverFavorites = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("body > main:nth-child(7) > div:nth-child(5) > div:nth-child(2) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > article:nth-child(1) > figure:nth-child(1) > figcaption:nth-child(4) > div:nth-child(1) > label:nth-child(2) > svg:nth-child(1) > use:nth-child(1)"))); // Replace with accurate class or data attribute
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", discoverFavorites);
            System.out.println("Scrolled to Discover Favorites.");
            
            WebElement productButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[@for='compare-217']//*[name()='svg']")));
            productButton.click();
            Thread.sleep(2000);
            
            // Hover and click on Discover Favorites
            Actions actions = new Actions(driver);
            actions.moveToElement(discoverFavorites).click().perform();
            System.out.println("Hovered over and clicked Discover Favorites.");

           // Locate Discover Favorites element and scroll to it
            WebElement discoverFavorites1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("body > main:nth-child(7) > div:nth-child(5) > div:nth-child(2) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > article:nth-child(1) > figure:nth-child(1) > a:nth-child(3) > div:nth-child(1) > img:nth-child(2)"))); // Replace with accurate class or data attribute
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", discoverFavorites1);
            System.out.println("Scrolled to Discover Favorites.");
            
            WebElement productButton1 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[@for='compare-214']//*[name()='svg']")));
            productButton1.click();
            Thread.sleep(2000);

            Thread.sleep(2000);

            // Scroll to Discover Favorites section
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -2400)");
            System.out.println("Scrolled to Discover Favorites.");
            
            // Navigate to the login page
            WebElement yourAccount = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[normalize-space()='Your Account']")));
            yourAccount.click();
            Thread.sleep(2000);

            WebElement compareButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[@class='navUser-action navUser-item--compare needsclick']")));
            compareButton.click();
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

    // Helper method to close popup if present
    private void closePopupIfPresent() {
        try {
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//i[@class='icon icon-newsletter-close']//*[name()='svg']")));
            closeButton.click();
            System.out.println("Popup closed.");
        } catch (Exception e) {
            System.out.println("No popup appeared.");
        }
    }
}
