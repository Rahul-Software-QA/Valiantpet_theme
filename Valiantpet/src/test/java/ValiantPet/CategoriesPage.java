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

public class CategoriesPage {
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
    public void BirdSuppliesPage() {
    	// Hover over the "Shop" menu item
        navigateToBirdSuppliesCategory("//a[@aria-label='Bird Supplies']", "Bird Supplies");
    }
    

    @Test(priority = 4)
    public void AllBirdSuppliesPage() {
        navigateToBirdSuppliesCategory("//a[@aria-label='All Bird Supplies']", "All Bird Supplies");
    }

    @Test(priority = 5)
    public void BirdcagesandaccessoriesPage() {
        navigateToBirdSuppliesCategory("//a[@aria-label='Bird cages and accessories']", "Bird cages and accessories");
    }

    @Test(priority = 6)
    public void BirdtoysandperchesPage() {
        navigateToBirdSuppliesCategory("//a[@aria-label='Bird toys and perches']", "Bird toys and perches");
    }
    
    @Test(priority = 7)
    public void BirdtreatsandsupplementsPage() {
        navigateToBirdSuppliesCategory("//a[@aria-label='Bird treats and supplements']", "Bird treats and supplements");
    }

    @Test(priority = 8)
    public void CatSuppliesPage() {
        navigateToCatSuppliesCategory("//a[@aria-label='Cat Supplies'][normalize-space()='Cat Supplies']", "Cat Supplies");
    }
    
    @Test(priority = 9)
    public void AllCatSuppliesPage() {
    	navigateToCatSuppliesCategory("//a[@aria-label='All Cat Supplies']", "All Cat Supplies");
    }
    
    @Test(priority = 10)
    public void CatbedsandfurniturePage() {
    	navigateToCatSuppliesCategory("//a[@aria-label='Cat beds and furniture']", "Cat beds and furniture");
    }
    
    @Test(priority = 11)
    public void CatcollarsandharnessesPage() {
    	navigateToCatSuppliesCategory("//a[@aria-label='Cat collars and harnesses']", "Cat collars and harnesses");
    }
    
    @Test(priority = 12)
    public void CatfoodPage() {
    	navigateToCatSuppliesCategory("//a[@aria-label='Cat food']", "Cat food");
    }
    
    @Test(priority = 13)
    public void CatgroomingproductsPage() {
    	navigateToCatSuppliesCategory("//a[@aria-label='Cat grooming products']", "Cat grooming products");
    }
    
    @Test(priority = 14)
    public void CathealthandwellnessproductsPage() {
    	navigateToCatSuppliesCategory("//a[@aria-label='Cat health and wellness products']", "Cat health and wellness products");
    }
    
    @Test(priority = 15)
    public void CatlitterandlitterboxesPage() {
    	navigateToCatSuppliesCategory("//a[@aria-label='Cat litter and litter boxes']", "Cat litter and litter boxes");
    }
    
    @Test(priority = 16)
    public void CattoysPage() {
    	navigateToCatSuppliesCategory("//a[@aria-label='Cat toys']", "Cat toys");
    }
    
    @Test(priority = 17)
    public void DogSuppliesPage() {
    	navigateToDogSuppliesCategory("//a[@aria-label='Dog Supplies'][normalize-space()='Dog Supplies']", "Dog Supplies");
    }
    
    @Test(priority = 18)
    public void AllDogSuppliesPage() {
    	navigateToDogSuppliesCategory("//a[@aria-label='All Dog Supplies']", "All Dog Supplies");
    }
    
    @Test(priority = 19)
    public void DogbedsandcratesPage() {
    	navigateToDogSuppliesCategory("//a[@aria-label='Dog beds and crates']", "Dog beds and crates");
    }
    
    @Test(priority = 20)
    public void DogcollarsleashesandharnessesPage() {
    	navigateToDogSuppliesCategory("//a[@aria-label='Dog collars leashes and harnesses']", "Dog collars leashes and harnesses");
    }
    
    @Test(priority = 21)
    public void DogfoodPage() {
    	navigateToDogSuppliesCategory("//a[@aria-label='Dog food']", "Dog food");
    }
    
    @Test(priority = 22)
    public void DogtoysPage() {
    	navigateToDogSuppliesCategory("//a[@aria-label='Dog toys']", "Dog toys");
    }
    
    @Test(priority = 23)
    public void DoggroomingproductsPage() {
    	navigateToDogSuppliesCategory("//a[@aria-label='Dog grooming products']", "Dog grooming products");
    }
    
    @Test(priority = 24)
    public void DogtrainingsuppliesPage() {
    	navigateToDogSuppliesCategory("//a[@aria-label='Dog training supplies']", "Dog training supplies");
    }
    
    
    @Test(priority = 25)
    public void DoghealthandwellnessproductsPage() {
    	navigateToDogSuppliesCategory("//a[@aria-label='Dog health and wellness products']", "Dog health and wellness products");
    }
    
    @Test(priority = 26)
    public void TreatsandsnacksPage() {
    	navigateToDogSuppliesCategory("//a[@aria-label='Treats and snacks']", "Treats and snacks");
    }
    
    @Test(priority = 27)
    public void FishSuppliesPage() {
    	navigateToFishSuppliesCategory("//a[@aria-label='Fish Supplies']", "Fish Supplies");
    }
    
    @Test(priority = 28)
    public void AllFishSuppliesPage() {
    	navigateToFishSuppliesCategory("//a[@aria-label='All Fish Supplies']", "All Fish Supplies");
    }
    
    @Test(priority = 29)
    public void FishaccessoriesandmaintenancesuppliesPage() {
    	navigateToFishSuppliesCategory("//a[@aria-label='Fish accessories and maintenance supplies']", "Fish accessories and maintenance supplies");
    }
    
    @Test(priority = 30)
    public void FishmedicationsandwatertreatmentsPage() {
    	navigateToFishSuppliesCategory("//a[@aria-label='Fish medications and water treatments']", "Fish medications and water treatments");
    }
    
    @Test(priority = 31)
    public void PetServicesPage() {
    	navigateToPetServicesCategory("//a[@aria-label='Pet Services']", "Pet Services");
    }
    
    @Test(priority = 32)
    public void AllPetServicesPage() {
    	navigateToPetServicesCategory("//a[@aria-label='All Pet Services']", "All Pet Services");
    }
    
    @Test(priority = 33)
    public void PetgroomingservicesPage() {
    	navigateToPetServicesCategory("//a[@aria-label='Pet grooming services']", "Pet grooming services");
    }
    
    @Test(priority = 34)
    public void PettrainingservicesPage() {
    	navigateToPetServicesCategory("//a[@aria-label='Pet training services']", "Pet training services");
    }

    // Helper method to navigate to a service category and scroll the page
    private void navigateToBirdSuppliesCategory(String categoryXPath, String categoryName) {
        try {
            // Hover over the "News" menu item (adjust XPath if needed)
            WebElement servicesMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Bird Supplies']")));
            Actions actions = new Actions(driver);
            actions.moveToElement(servicesMenu).perform();
            System.out.println("Hovered over the BirdSupplies.");

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
    private void navigateToCatSuppliesCategory(String categoryXPath, String categoryName) {
        try {
            // Hover over the "News" menu item (adjust XPath if needed)
            WebElement servicesMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Cat Supplies'][normalize-space()='Cat Supplies']")));
            Actions actions = new Actions(driver);
            actions.moveToElement(servicesMenu).perform();
            System.out.println("Hovered over the Cat Supplies.");

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
    private void navigateToDogSuppliesCategory(String categoryXPath, String categoryName) {
        try {
            // Hover over the "News" menu item (adjust XPath if needed)
            WebElement servicesMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Dog Supplies'][normalize-space()='Dog Supplies']")));
            Actions actions = new Actions(driver);
            actions.moveToElement(servicesMenu).perform();
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
    private void navigateToFishSuppliesCategory(String categoryXPath, String categoryName) {
        try {
            // Hover over the "News" menu item (adjust XPath if needed)
            WebElement servicesMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Fish Supplies']")));
            Actions actions = new Actions(driver);
            actions.moveToElement(servicesMenu).perform();
            System.out.println("Hovered over the Fish Supplies.");

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
    private void navigateToPetServicesCategory(String categoryXPath, String categoryName) {
        try {
            // Hover over the "News" menu item (adjust XPath if needed)
            WebElement servicesMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Pet Services']")));
            Actions actions = new Actions(driver);
            actions.moveToElement(servicesMenu).perform();
            System.out.println("Hovered over the Pet Services.");

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
