package in.amazon.AmazonAssessment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoveItemsFromCartTest {
	public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
		// for cross browser here we can define multiple browsers like geckodriver for firefox and safariDriver for safari browser.
        System.setProperty("webdriver.chrome.driver", "/Users/neha/Downloads/chromedriver-mac-x64/chromedriver");
       
        // Initialize ChromeDriver
     // for cross browser testing, we can initiate additional browsers here.
        WebDriver driver = new ChromeDriver();

        // Navigate to the amazon.in and add multiple items to the cart
        driver.get("https://www.amazon.in");
        // Add multiple items to the cart

        // Navigate to the cart page
        WebElement cartLink = driver.findElement(By.id("cart-link"));
        cartLink.click();

        // Wait for the cart page to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart-page")));

        // Remove an item from the cart
        WebElement removeItemButton = driver.findElement(By.xpath("//button[@class='remove-item-button']"));
        removeItemButton.click();

        // Wait for the cart to update after item removal
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='cart-item']")));

        // Verify that the item is removed from the cart
        WebElement cartTotal = driver.findElement(By.id("cart-total"));
        String totalText = cartTotal.getText();
        if (totalText.equals("Updated cart total amount")) {
            System.out.println("Item removed from the cart successfully.");
        } else {
            System.out.println("Failed to remove item from the cart.");
        }

        // Close the browser
        driver.quit();
    }

}
