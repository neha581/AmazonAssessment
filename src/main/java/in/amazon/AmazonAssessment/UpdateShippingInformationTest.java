package in.amazon.AmazonAssessment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateShippingInformationTest {
	public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
		// for cross browser here we can define multiple browsers like geckodriver for firefox and safariDriver for safari browser.
        System.setProperty("webdriver.chrome.driver", "/Users/neha/Downloads/chromedriver-mac-x64/chromedriver");
       
        // Initialize ChromeDriver
     // for cross browser testing, we can initiate additional browsers here.
        WebDriver driver = new ChromeDriver();

        // Navigate to the amazon website and add items to the cart
        driver.get("https://www.amazon.in");
        // Add items to the cart and proceed to checkout

        // Click on the "Change" link under the shipping address
        WebElement changeShippingLink = driver.findElement(By.id("change-shipping-link"));
        changeShippingLink.click();

        // Wait for the shipping address form to appear
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping-address-form")));

        // Enter a new shipping address
        WebElement shippingAddressInput = driver.findElement(By.id("shipping-address-input"));
        shippingAddressInput.clear();
        shippingAddressInput.sendKeys("H.no. 101, street 3, New colony, delhi");

        // Save the new shipping address
        WebElement saveShippingButton = driver.findElement(By.id("save-shipping-button"));
        saveShippingButton.click();

        // Wait for the shipping address to update
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("current-shipping-address"), "New Shipping Address"));

        // Verify that the new shipping address is saved and displayed
        WebElement currentShippingAddress = driver.findElement(By.id("current-shipping-address"));
        String addressText = currentShippingAddress.getText();
        if (addressText.equals("New Shipping Address")) {
            System.out.println("New shipping address saved successfully.");
        } else {
            System.out.println("Failed to save new shipping address.");
        }

        // Close the browser
        driver.quit();
    }

}
