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

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

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

        System.out.println("Browser setup complete.");
    }

    @Test(priority = 1)
    public void openHomePage() {
        driver.get("https://valiant-pet-demo.mybigcommerce.com/");
        System.out.println("Navigated to the Valiant Pet website.");
        pause(2000); // Pause to allow the page to load
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

    @Test(priority = 3)
    public void clickShopButton() {
        WebElement shopButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[contains(@class,'slick-slide slick-current slick-active')]//a[@aria-label='Slide number 1, Shop Now'][normalize-space()='Shop Now']")));
        shopButton.click();
        System.out.println("Clicked on 'Shop Now' button.");
        pause(2000); // Pause before navigating back
        driver.navigate().back();
    }

    @Test(priority = 4)
    public void navigateSlider() {
        try {
            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@aria-label='Next slide']")));
            scrollToElement(nextButton);
            nextButton.click();
            System.out.println("Clicked on 'Next' button.");
            pause(2000); // Pause for slider animation

            WebElement previousButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@aria-label='Previous slide']")));
            scrollToElement(previousButton);
            previousButton.click();
            System.out.println("Clicked on 'Previous' button.");
            pause(2000); // Pause for slider animation
        } catch (Exception e) {
            System.out.println("Error navigating the slider: " + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void interactWithCategoryButtons() throws InterruptedException {
        clickCategoryButton("//a[@aria-label='Dog Supplies']//span[@class='category-link'][normalize-space()='Shop Now']");
        Thread.sleep(2000); // Pause for 2 seconds
        clickCategoryButton("//a[@aria-label='Birds Supplies']//span[@class='category-link'][normalize-space()='Shop Now']");
        Thread.sleep(2000); // Pause for 2 seconds
        clickCategoryButton("//a[@aria-label='Cat Supplies']//span[@class='category-link'][normalize-space()='Shop Now']");
        Thread.sleep(2000); // Pause for 2 seconds
        clickCategoryButton("//a[@aria-label='Fish & Aquarium Supplies']//span[@class='category-link'][normalize-space()='Shop Now']");
        Thread.sleep(2000); // Pause for 2 seconds
        clickCategoryButton("//a[@aria-label='Small Pet Bedding & Litter']//span[@class='category-link'][normalize-space()='Shop Now']");
        
         // Scroll down to bring list and grid view buttons into view
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
    }

    @Test(priority = 6)
    public void interactWithSecondarySlider() {
        WebElement rightButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[2]//section[1]//button[2]")));
        rightButton.click();
        System.out.println("Clicked 'Right' button on secondary slider.");
        pause(2000); // Pause for slider animation

        WebElement leftButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@aria-label='Go to slide 1 of 2'][normalize-space()='Previous']")));
        leftButton.click();
        System.out.println("Clicked 'Left' button on secondary slider.");
        pause(2000); // Pause for slider animation
        
    }

    @Test(priority = 7)
    public void addToCartWithHover() {
        try {
            // Locate the product element
            WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[2]//section[1]//div[1]//div[1]//div[3]//article[1]")));
            // Hover over the product
            Actions actions = new Actions(driver);
            actions.moveToElement(product).perform();
            System.out.println("Hovered over the product.");
            pause(2000);

            // Click 'Add to Cart' button
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[2]//section[1]//div[1]//div[1]//div[3]//article[1]//div[1]//div[2]//div[2]//div[1]//a[1]//span[1]")));
            addToCartButton.click();
            System.out.println("Clicked 'Add to Cart' button.");
            pause(2000);

            // Click 'Quick View' button
            WebElement quickViewButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[2]//section[1]//div[1]//div[1]//div[3]//article[1]//figure[1]//figcaption[1]//div[1]//button[1]//*[name()='svg']")));
            quickViewButton.click();
            System.out.println("Clicked 'Quick View' button.");
            pause(2000);

            // Close 'Quick View' modal
            WebElement quickViewCloseButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//body/div[@id='modal']/button[@title='Close']/span[2]")));
            quickViewCloseButton.click();
            System.out.println("Closed 'Quick View' modal.");
            pause(2000);

            // Click 'Compare' button
            WebElement compareButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[2]//section[1]//div[1]//div[1]//div[3]//article[1]//figure[1]//figcaption[1]//div[1]//label[1]/*[name()='svg'][1]")));
            compareButton.click();
            System.out.println("Clicked 'Compare' button.");
            pause(2000);

            // Close 'Compare' modal
            WebElement compareCloseButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[2]//section[1]//div[1]//div[1]//div[3]//article[1]//figure[1]//figcaption[1]//div[1]//label[1]/*[name()='svg'][1]")));
            compareCloseButton.click();
            System.out.println("Closed 'Compare' modal.");
            pause(2000);

            // Scroll down to bring list and grid view buttons into view
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");

        } catch (Exception e) {
            System.out.println("Error during hover or add to cart actions: " + e.getMessage());
        }
    }

    @Test(priority = 8)
    public void interactWithSecondarySlider1() {
        try {
            System.out.println("Starting Test 8 - interactWithSecondarySlider1");
            clickSliderButton(By.xpath("//button[@aria-label='Go to slide 3 of 3'][normalize-space()='Next']"));
            clickSliderButton(By.xpath("//button[@aria-label='Go to slide 1 of 3'][normalize-space()='Previous']"));
        } catch (Exception e) {
            System.out.println("Error during secondary slider interaction: " + e.getMessage());
        }
    }

	
	
	private void clickSliderButton(By xpath) {
		// TODO Auto-generated method stub
		
	}

	@Test(priority = 9)
    public void PopularProducts() {
        WebElement PopularProducts = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@data-sec='first-sec']//span[@class='plus plus-one']//div[@class='plus-background']//*[name()='svg']")));
        PopularProducts.click();
        System.out.println("Clicked on 'PopularProducts' button.");
        pause(2000); // Pause before navigating back
        WebElement AddtocartButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='product-item product-show is-shown']//span[contains(text(),'Add to Cart')]")));
        AddtocartButton.click();
            System.out.println("Popup closed.");
        
        driver.navigate().back();
    }
	
	

	@AfterClass
    public void tearDown() {
        if (driver != null) {
             driver.quit();
            System.out.println("Browser closed.");
        }
    }

    // Utility Methods
    private void clickCategoryButton(String xpath) {
        try {
            WebElement categoryButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            categoryButton.click();
            System.out.println("Clicked on a category 'Shop Now' button.");
            pause(2000); // Pause before navigating back
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Category button not found: " + xpath);
        }
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println("Scrolled to element: " + element);
    }

    private void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Error during sleep: " + e.getMessage());
        }
    }
}
