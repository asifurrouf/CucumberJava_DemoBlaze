package stepDefinitions.cart;

import base.PageObjectManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.CartPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;

public class CartSteps {
    private WebDriver driver;
    private PageObjectManager pom;
    private CartPage cartPage = new CartPage();

    public CartSteps(DriverSetup driverSetup) {
        this.driver = driverSetup.driver;
        this.pom = new PageObjectManager(driver);
    }

    @Then("Add to cart button should be displayed")
    public void addToCartButtonShouldBeDisplayed() {
        Assert.assertTrue(pom.isElementDisplayed(cartPage.addToCartButton));
    }

    @When("User clicks on Add to cart button")
    public void userClicksOnAddToCartButton() throws InterruptedException {
        pom.clickElement(cartPage.addToCartButton);
        Thread.sleep(2000);
    }

    @Then("Product added alert should be loaded")
    public void productAddedAlertShouldBeLoaded() throws InterruptedException, UnhandledAlertException {
        Thread.sleep(1000);
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            Assert.assertEquals(alertText, "Product added");
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
        }
        Thread.sleep(2000);
    }
}
