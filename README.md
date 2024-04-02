# AmazonAssessment
This repository contains Selenium test scripts for testing various scenarios on Amazon.in. The tests are written in Java and utilize the Selenium WebDriver framework for browser automation.

Prerequisites Before running the tests, ensure you have the following prerequisites installed:
Java Development Kit (JDK) installed on your machine. WebDriver executable files for Chrome, Firefox, and Safari browsers. Download the respective drivers and ensure they are added to your system PATH or set the system properties in the test scripts accordingly. Maven installed on your machine. This is required to manage dependencies and build the project. Setup Clone this repository to your local machine: bash Copy code git clone https://github.com/neha581/AmazonAutomationAssessment.git Navigate to the project directory: bash Copy code cd AmazonAutomationAssessment Import the project into your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

Ensure the WebDriver paths are correctly set in the test scripts (if not added to PATH).

Running the Tests You can run the tests using Maven commands or directly from your IDE.

Using Maven Commands Open a terminal/command prompt.

Navigate to the project directory.

Execute the following command to run the tests:

bash Copy code mvn test This command will execute all test scenarios across Chrome, Firefox, and Safari browsers.

Using IDE Open the project in your preferred Java IDE.

Navigate to the test class (e.g., AddToCartTest.java, UpdateShippingInformationTest.java, RemoveItemsFromCartTest.java).

Right-click on the test class and select "Run" or "Run As" > "Java Application".

Test Scenarios

Adding Items to Cart Objective: Verify that users can add items to their cart from the product detail page. Steps: Navigate to the Amazon homepage. Search for a specific product. Select a product from the search results. Click the "Add to Cart" button. Expected Result: The item is added to the cart, and the cart count is incremented by one.

Updating Shipping Information Objective: Confirm that users can update their shipping address during the checkout process. Steps: Add items to the cart and proceed to checkout. Click on the "Change" link under the shipping address. Enter a new shipping address and save it. Expected Result: The new shipping address is saved and displayed as the current shipping address for the order.

Removing Items from Cart Objective: Test the functionality of removing items from the cart. Steps: Add multiple items to the cart. Navigate to the cart page. Remove an item from the cart. Expected Result: The item is removed from the cart, and the cart total is updated accordingly.
