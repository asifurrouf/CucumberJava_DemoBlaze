package stepDefinitions.cart;

import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.CartPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;

public class PurchaseSteps {
    private WebDriver driver;
    private PageObjectManager pom;
    private CartPage cartPage = new CartPage();

    public PurchaseSteps(DriverSetup driverSetup) {
        this.driver = driverSetup.driver;
        this.pom = new PageObjectManager(driver);
    }

    @When("User clicks on Ok button from the alert")
    public void userClicksOnOkButtonFromTheAlert() throws UnhandledAlertException {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
        }
    }

    @And("Clicks on Cart tab from the top nav bar")
    public void clicksOnCartTabFromTheTopNavBar() throws InterruptedException {
        pom.clickElement(cartPage.cartTab);
        Thread.sleep(2000);
    }

    @Then("Cart page should be loaded")
    public void cartPageShouldBeLoaded() {
        Assert.assertTrue(pom.isElementDisplayed(cartPage.cartTable));
    }

    @And("Place Order button should be displayed")
    public void placeOrderButtonShouldBeDisplayed() {
        Assert.assertTrue(pom.isElementDisplayed(cartPage.placeOrderButton));
    }

    @When("User clicks on Place Order button")
    public void userClicksOnPlaceOrderButton() {
        pom.clickElement(cartPage.placeOrderButton);
    }

    @Then("Place Order form should be loaded")
    public void placeOrderFormShouldBeLoaded() {
        pom.waitUntilElementIsVisible(cartPage.placeOrderForm);
        Assert.assertTrue(pom.isElementDisplayed(cartPage.placeOrderForm));
    }

    @When("User enters {string} into the Name input field")
    public void userEntersIntoTheNameInputField(String name) {
        pom.sendKeysToElement(cartPage.nameField, name);
    }

    @And("enters {string} into the Country input field")
    public void entersIntoTheCountryInputField(String country) {
        pom.sendKeysToElement(cartPage.countryField, country);
    }

    @And("enters {string} into the City input field")
    public void entersIntoTheCityInputField(String city) {
        pom.sendKeysToElement(cartPage.cityField, city);
    }

    @And("enters {string} into the Credit Card input field")
    public void entersIntoTheCreditCardInputField(String card) {
        pom.sendKeysToElement(cartPage.cardField, card);
    }

    @And("enters {string} into the Month input field")
    public void entersIntoTheMonthInputField(String month) {
        pom.sendKeysToElement(cartPage.monthField, month);
    }

    @And("enters {string} into the Year input field")
    public void entersIntoTheYearInputField(String year) {
        pom.sendKeysToElement(cartPage.yearField, year);
    }

    @And("clicks on the Purchase button")
    public void clicksOnThePurchaseButton() {
        pom.clickElement(cartPage.purchaseButton);
    }

    @Then("Purchase confirmation alert should be displayed")
    public void purchaseConfirmationAlertShouldBeDisplayed() {
//        try {
//            Alert alert = driver.switchTo().alert();
//            String alertText = alert.getText();
//            Assert.assertEquals(alertText, "Product added");
//            alert.accept();
//        } catch (NoAlertPresentException ex) {
//            ex.printStackTrace();
//        }
        Assert.assertTrue(pom.isElementDisplayed(cartPage.purchaseAlertOkButton));
    }
}
