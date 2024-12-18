package ValiantPet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CMSPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    @BeforeClass
    public void setUp() {
        // Initialize the ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Initialize explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialize JavascriptExecutor
        js = (JavascriptExecutor) driver;

        System.out.println("Browser setup complete.");
    }

    @Test(priority = 1)
    public void navigateToWebsite() {
        // Navigate to the website
        driver.get("https://valiant-pet-demo.mybigcommerce.com/");
        System.out.println("Navigated to the Valiant Pet website.");
    }

    @Test(priority = 2)
    public void handlePopup() {
        try {
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//i[@class='icon icon-newsletter-close']//*[name()='svg']")));
            closeButton.click();
            System.out.println("Popup closed.");
            pause(2000); // Pause after closing the popup
        } catch (Exception e) {
            System.out.println("No popup to handle.");
        }
    }

    private void pause(int milliseconds) {
        // Pauses the execution for a specified time (in milliseconds)
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Error during sleep: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void ShippingReturnsPage() throws InterruptedException {
    	// Hover over the "Shop" menu item
    	navigateToshippingreturns("//li[@class='navPages-item navPages-dropdown-child']//a[@class='navPages-action'][normalize-space()='Shipping & Returns']", "Shipping & Returns");
    	Thread.sleep(2000); // Pause between navigations
    }
    

    @Test(priority = 4)
    public void AboutPage() throws InterruptedException {
    	navigateToAbout("//li[@class='navPages-item navPages-dropdown-child']//a[@class='navPages-action'][normalize-space()='About']", "About");
    	Thread.sleep(2000); // Pause between navigations
    }

    @Test(priority = 5)
    public void BirdcagesandaccessoriesPage() throws InterruptedException {
    	navigateToBlog("//li[@class='navPages-item navPages-dropdown-child']//a[@class='navPages-action'][normalize-space()='Blog']", "Blog");
    	Thread.sleep(2000); // Pause between navigations
    }

    @Test(priority = 6)
    public void ContactPage() throws InterruptedException {
    	navigateToContact("//a[@class='navPages-action navPages-action-depth-max has-subMenu is-root'][normalize-space()='Contact']", "Contact");
    	Thread.sleep(2000); // Pause between navigations
    }
    
    @Test(priority = 7)
    public void TermsConditionPage() throws InterruptedException {
    	navigateToContact("//a[@class='navPages-action navPages-action-depth-max has-subMenu is-root'][normalize-space()='Contact']//i[@class='icon navPages-action-moreIcon']//*[name()='svg']", "Terms&Condition");
    	Thread.sleep(2000); // Pause between navigations
    }
    
    @Test(priority = 8)
    public void FaqsPage() throws InterruptedException {
    	navigateToContact("//a[@class='navPages-action navPages-action-depth-max has-subMenu is-root'][normalize-space()='Contact']//i[@class='icon navPages-action-moreIcon']//*[name()='svg']", "Faqs");
    	Thread.sleep(2000); // Pause between navigations
    }

    

    // Helper method to navigate to a service category and scroll the page
    private void navigateToshippingreturns(String categoryXPath, String categoryName) {
        try {
            // Hover over the "News" menu item (adjust XPath if needed)
            WebElement shippingreturnsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='navPages-item navPages-dropdown-child']//a[@class='navPages-action'][normalize-space()='Shipping & Returns']")));
            Actions actions = new Actions(driver);
            actions.moveToElement(shippingreturnsMenu).perform();
            System.out.println("Hovered over the shipping-returns.");

            // Click on the specified category
            WebElement categoryButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(categoryXPath)));
            categoryButton.click();
            System.out.println("Clicked on " + categoryName + " category.");

            // Perform continuous scrolling
            continuousScroll(categoryName);
        } catch (Exception e) {
            System.err.println("An error occurred while navigating to " + categoryName + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    

    // Helper method to navigate to a service category and scroll the page
    private void navigateToAbout(String categoryXPath, String categoryName) {
        try {
            // Hover over the "News" menu item (adjust XPath if needed)
            WebElement AboutMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='navPages-item navPages-dropdown-child']//a[@class='navPages-action'][normalize-space()='About']")));
            Actions actions = new Actions(driver);
            actions.moveToElement(AboutMenu).perform();
            System.out.println("Hovered over the About.");

            // Click on the specified category
            WebElement categoryButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(categoryXPath)));
            categoryButton.click();
            System.out.println("Clicked on " + categoryName + " category.");

            // Perform continuous scrolling
            continuousScroll(categoryName);
        } catch (Exception e) {
            System.err.println("An error occurred while navigating to " + categoryName + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
    
 // Helper method to navigate to a service category and scroll the page
    private void navigateToBlog(String categoryXPath, String categoryName) {
        try {
            // Hover over the "News" menu item (adjust XPath if needed)
            WebElement BlogMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='navPages-item navPages-dropdown-child']//a[@class='navPages-action'][normalize-space()='Blog']")));
            Actions actions = new Actions(driver);
            actions.moveToElement(BlogMenu).perform();
            System.out.println("Hovered over the Dog Supplies.");

            // Click on the specified category
            WebElement categoryButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(categoryXPath)));
            categoryButton.click();
            System.out.println("Clicked on " + categoryName + " category.");

            // Perform continuous scrolling
            continuousScroll(categoryName);
        } catch (Exception e) {
            System.err.println("An error occurred while navigating to " + categoryName + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Helper method to navigate to a service category and scroll the page
    private void navigateToContact(String categoryXPath, String categoryName) {
        try {
            // Hover over the "News" menu item (adjust XPath if needed)
            WebElement ContactMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='navPages-action navPages-action-depth-max has-subMenu is-root'][normalize-space()='Contact']")));
            Actions actions = new Actions(driver);
            actions.moveToElement(ContactMenu).perform();
            System.out.println("Hovered over the Contact.");

            // Click on the specified category
            WebElement categoryButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(categoryXPath)));
            categoryButton.click();
            System.out.println("Clicked on " + categoryName + " category.");

            // Perform continuous scrolling
            continuousScroll(categoryName);
        } catch (Exception e) {
            System.err.println("An error occurred while navigating to " + categoryName + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    

    // Method to perform continuous scrolling
    public void continuousScroll(String pageName) {
        try {
            System.out.println("Starting continuous scroll on " + pageName + " page...");

            // Get the total page height
            long pageHeight = (long) js.executeScript("return document.body.scrollHeight;");
            long currentScrollPosition = 0; // Start from the top
            int scrollStep = 200; // Step in pixels for each scroll
            int delayBetweenScrolls = 500; // Delay in milliseconds for moderate speed

            // Scroll down in steps until reaching the bottom
            while (currentScrollPosition < pageHeight) {
                js.executeScript("window.scrollBy(0, " + scrollStep + ");");
                currentScrollPosition += scrollStep;

                System.out.println("Scrolled to position: " + currentScrollPosition);
                Thread.sleep(delayBetweenScrolls); // Wait between scrolls for moderate speed

                // Update the page height dynamically in case the page loads additional content
                pageHeight = (long) js.executeScript("return document.body.scrollHeight;");
            }

            System.out.println("Reached the bottom of " + pageName + " page.");
        } catch (Exception e) {
            System.err.println("Error during scrolling on " + pageName + ": " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
