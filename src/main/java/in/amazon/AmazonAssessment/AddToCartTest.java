package in.amazon.AmazonAssessment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartTest {
	public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
		// for cross browser here we can define multiple browsers like geckodriver for firefox and safariDriver for safari browser.
        System.setProperty("webdriver.chrome.driver", "/Users/neha/Downloads/chromedriver-mac-x64/chromedriver");
   
        // Initialize ChromeDriver
        // for cross browser testing, we can initiate additional browsers here.
        WebDriver driver = new ChromeDriver();

        // Navigate to the Amazon homepage
        driver.get("https://www.amazon.in");

     // Search for a specific product
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone 12");
        searchBox.submit();
        
     
       
        // Wait for search results to load
       WebDriverWait wait = new WebDriverWait(driver, 20);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-component-type='s-search-result']")));

        // Select a product from the search results (let's assume we click the first product)
        WebElement firstProduct = driver.findElement(By.xpath("//div[@data-component-type='s-search-result'][1]"));
        firstProduct.click();

        // Click the "Add to Cart" button
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // Wait for the cart count to update
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("nav-cart-count"), "1"));

        // Verify the cart count is incremented by one
        WebElement cartCount = driver.findElement(By.id("nav-cart-count"));
        String countText = cartCount.getText();
        int itemCount = Integer.parseInt(countText);
        if (itemCount == 1) {
            System.out.println("Item added to cart successfully.");
        } else {
            System.out.println("Failed to add item to cart.");
        }

        // Close the browser
        driver.quit();
    }

   

}
