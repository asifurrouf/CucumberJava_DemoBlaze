package stepDefinitions.contact;

import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.Contact;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;

public class ContactSteps {
    private WebDriver driver;
    private PageObjectManager pom;
    private Contact contact = new Contact();

    public ContactSteps(DriverSetup driverSetup) {
        this.driver = driverSetup.driver;
        this.pom = new PageObjectManager(driver);
    }

    @And("Contact tab should be displayed at the nav bar")
    public void contactTabShouldBeDisplayedAtTheNavBar() {
        Assert.assertTrue(pom.isElementDisplayed(contact.contactTab));
    }

    @When("User clicks on the Contact tab")
    public void userClicksOnTheContactTab() {
        pom.clickElement(contact.contactTab);
    }

    @Then("New message form should be loaded")
    public void newMessageFormShouldBeLoaded() {
        Assert.assertTrue(pom.isElementDisplayed(contact.newMessageForm));
    }

    @When("User enters {string} in the Contact Email field")
    public void userEntersInTheContactEmailField(String email) {
        pom.sendKeysToElement(contact.contactEmailField, email);
    }

    @And("enters {string} in the Contact Name field")
    public void entersInTheContactNameField(String name) {
        pom.sendKeysToElement(contact.contactNameField, name);
    }

    @And("enters {string} in the Message field")
    public void entersInTheMessageField(String message) {
        pom.sendKeysToElement(contact.messageField, message);
    }

    @And("clicks on Send message button")
    public void clicksOnSendMessageButton() {
        pom.clickElement(contact.sendMessageButton);
    }

    @Then("Confirmation alert for message should be displayed")
    public void confirmationAlertForMessageShouldBeDisplayed() throws UnhandledAlertException {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            Assert.assertEquals(alertText, "Thanks for the message!!");
            alert.accept();
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
        }
    }
}
