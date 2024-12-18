package ValiantPet;

import java.time.Duration;
import java.time.Instant;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class AccountPage {

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
            
            // Navigate to 'Returns' section
            navigateToReturns("//a[@class='navBar-action'][normalize-space()='Returns']", "Returns");
            Thread.sleep(2000);
            
            // Navigate to 'Messages' section
            navigateToMessages("//a[normalize-space()='Messages (0)']", "Messages");
            Thread.sleep(2000);
            
            // Navigate to 'Addresses' section
            navigateToAddresses("//a[@class='navBar-action'][normalize-space()='Addresses']", "Addresses");
            Thread.sleep(2000);
            
            WebElement NewAddressesButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[@class='address-symbol']")));
            NewAddressesButton.click();
            Thread.sleep(2000);
            
            WebElement FirstNameButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='FormField_4_input']")));
            FirstNameButton.sendKeys("Gideon");
            Thread.sleep(2000);
            
            WebElement LastNameButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='FormField_5_input']")));
            LastNameButton.sendKeys("Smitham");
            Thread.sleep(2000);
            
            WebElement CampanyNameButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='FormField_6_input']")));
            CampanyNameButton.sendKeys("XYZ");
            Thread.sleep(2000);
            
            WebElement PhoneNumberButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='FormField_7_input']")));
            PhoneNumberButton.sendKeys("8956235689");
            Thread.sleep(2000);
            
            WebElement AddressLine1Button = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='FormField_8_input']")));
            AddressLine1Button.sendKeys("601");
            Thread.sleep(2000);
            
            WebElement AddressLine2Button = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='FormField_9_input']")));
            AddressLine2Button.sendKeys("Pennsylvania 940");
            Thread.sleep(2000);
            
            WebElement CityButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='FormField_10_input']")));
            CityButton.sendKeys("Mt Pocono");
            Thread.sleep(2000);

            WebElement CountryButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//select[@id='FormField_11_select']")));
            CountryButton.sendKeys("United States");
            Thread.sleep(2000);
            
            WebElement StateButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//select[@id='FormField_12_input']")));
            StateButton.sendKeys("California");
            Thread.sleep(2000);
            
            WebElement ZipCodeButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='FormField_13_input']")));
            ZipCodeButton.sendKeys("18344");
            Thread.sleep(2000);
            
            WebElement SaveAddressButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@value='Save Address']")));
            SaveAddressButton.click();
            Thread.sleep(2000);
            
            // Navigate to 'Wish Lists' section
            navigateToWishLists("//a[@class='navBar-action'][normalize-space()='Wish Lists']", "Wish Lists");
            Thread.sleep(2000);
            
            WebElement NewWishListButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[normalize-space()='New Wish List']")));
            NewWishListButton.click();
            Thread.sleep(2000);
            
            WebElement wishlistnameButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='wishlistname']")));
            wishlistnameButton.sendKeys("Test");
            
            WebElement shareWhishListButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[@for='publicwishlist']")));
            shareWhishListButton.click();
            
            WebElement CreateWishListButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@value='Create Wish List']")));
            CreateWishListButton.click();
            
            WebElement editWishListButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[@class='button button--small button--primary']")));
            editWishListButton.click();
            
            WebElement editwishlistnameButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='wishlistname']")));
            editwishlistnameButton.sendKeys("Test phase");
            
            WebElement saveWhishListButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@value='Save Wish List']")));
            saveWhishListButton.click();
            Thread.sleep(2000);
            
            WebElement DeleteButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@value='Delete All']")));
            DeleteButton.click();
            Thread.sleep(5000);
            
            // Navigate to 'Wish Lists' section
            navigateToRecentlyViewed("//a[@class='navBar-action'][normalize-space()='Recently Viewed']", "Recently Viewed");
            Thread.sleep(2000);
            
            // Navigate to 'Wish Lists' section
            navigateToAccountSettings("//a[@class='navBar-action'][normalize-space()='Account Settings']", "Account Settings");
            Thread.sleep(2000);
            
            WebElement updateDetailsButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@class='button button--primary']")));
            updateDetailsButton.click();
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
        } catch (Exception e) {
            System.err.println("Failed to navigate to " + sectionName + ": " + e.getMessage());
        }
    }
    
    private void navigateToReturns(String xpath, String sectionName) {
        try {
            WebElement sectionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            sectionButton.click();
            System.out.println("Navigated to " + sectionName + " section.");
        } catch (Exception e) {
            System.err.println("Failed to navigate to " + sectionName + ": " + e.getMessage());
        }
    }
    
    private void navigateToMessages(String xpath, String sectionName) {
        try {
            WebElement sectionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            sectionButton.click();
            System.out.println("Navigated to " + sectionName + " section.");
        } catch (Exception e) {
            System.err.println("Failed to navigate to " + sectionName + ": " + e.getMessage());
        }
    }
    
    private void navigateToAddresses(String xpath, String sectionName) {
        try {
            WebElement sectionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            sectionButton.click();
            System.out.println("Navigated to " + sectionName + " section.");
        } catch (Exception e) {
            System.err.println("Failed to navigate to " + sectionName + ": " + e.getMessage());
        }
    }
    
    private void navigateToWishLists(String xpath, String sectionName) {
        try {
            WebElement sectionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            sectionButton.click();
            System.out.println("Navigated to " + sectionName + " section.");
        } catch (Exception e) {
            System.err.println("Failed to navigate to " + sectionName + ": " + e.getMessage());
        }
    }
    
    private void navigateToRecentlyViewed(String xpath, String sectionName) {
        try {
            WebElement sectionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            sectionButton.click();
            System.out.println("Navigated to " + sectionName + " section.");
        } catch (Exception e) {
            System.err.println("Failed to navigate to " + sectionName + ": " + e.getMessage());
        }
    }
    
    private void navigateToAccountSettings(String xpath, String sectionName) {
        try {
            WebElement sectionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            sectionButton.click();
            System.out.println("Navigated to " + sectionName + " section.");
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