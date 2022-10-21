package stepDefinitions.signup;

import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.SignupPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;

public class SignupSteps {
    private WebDriver driver;
    private PageObjectManager pom;
    private SignupPage signupPage = new SignupPage();

    public SignupSteps(DriverSetup driverSetup) {
        this.driver = driverSetup.driver;
        this.pom = new PageObjectManager(driver);
    }

    @Then("Signup tab should be displayed at the nav bar")
    public void signupTabShouldBeDisplayedAtTheNavBar() {
        Assert.assertTrue(pom.isElementDisplayed(signupPage.signUpTab));
    }

    @When("User clicks on Signup tab from nav bar")
    public void userClicksOnSignupTabFromNavBar() {
        pom.clickElement(signupPage.signUpTab);
    }

    @Then("Signup form should be loaded")
    public void signupFormShouldBeLoaded() {
        Assert.assertTrue(pom.isElementDisplayed(signupPage.signUpForm));
    }

    @And("Username input field should be displayed")
    public void usernameInputFieldShouldBeDisplayed() {
        Assert.assertTrue(pom.isElementDisplayed(signupPage.usernameField));
    }

    @And("Password input field should be displayed")
    public void passwordInputFieldShouldBeDisplayed() {
        Assert.assertTrue(pom.isElementDisplayed(signupPage.passwordField));
    }

    @When("User enters username into the {string} field")
    public void userEntersUsernameIntoTheField(String Username) {
        pom.sendKeysToElement(signupPage.usernameField, Username);
    }

    @When("User enters password into the {string} field")
    public void userEntersPasswordIntoTheField(String password) {
        pom.sendKeysToElement(signupPage.passwordField, password);
    }

    @And("Clicks on Sign up button")
    public void clicksOnSignUpButton() throws InterruptedException {
        Thread.sleep(500);
        pom.clickElement(signupPage.signupButton);
        Thread.sleep(2000);
    }

    @Then("Confirmation alert should be displayed")
    public void confirmationAlertShouldBeDisplayed() throws InterruptedException, UnhandledAlertException {
        Thread.sleep(1000);
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            Assert.assertEquals(alertText, "Sign up successful.");
            alert.accept();
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
        }
    }
}
