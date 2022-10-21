package stepDefinitions.Login;

import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;

public class LoginSteps {
    private WebDriver driver;
    private PageObjectManager pom;
    private LoginPage loginPage = new LoginPage();

    public LoginSteps(DriverSetup driverSetup) {
        this.driver = driverSetup.driver;
        this.pom = new PageObjectManager(driver);
    }

    @Then("Login tab should be displayed at the nav bar")
    public void loginTabShouldBeDisplayedAtTheNavBar() {
        Assert.assertTrue(pom.isElementDisplayed(loginPage.loginTab));
    }

    @When("User clicks on Login tab from nav bar")
    public void userClicksOnLoginTabFromNavBar() {
        pom.clickElement(loginPage.loginTab);
    }

    @Then("Login form should be loaded")
    public void loginFormShouldBeLoaded() {
        Assert.assertTrue(pom.isElementDisplayed(loginPage.loginForm));
    }

    @And("Username input field should be displayed in login form")
    public void usernameInputFieldShouldBeDisplayedInLoginForm() {
        Assert.assertTrue(pom.isElementDisplayed(loginPage.usernameField));
    }

    @And("Password input field should be displayed in login form")
    public void passwordInputFieldShouldBeDisplayedInLoginForm() {
        Assert.assertTrue(pom.isElementDisplayed(loginPage.passwordField));
    }

    @When("User enters username into the {string} field in login form")
    public void userEntersUsernameIntoTheFieldInLoginForm(String username) {
        pom.sendKeysToElement(loginPage.usernameField, username);
    }

    @And("User enters password into the {string} field in login form")
    public void userEntersPasswordIntoTheFieldInLoginForm(String password) {
        pom.sendKeysToElement(loginPage.passwordField, password);
    }

    @And("Clicks on Log in button")
    public void clicksOnLogInButton() {
        pom.clickElement(loginPage.loginButton);
    }

    @Then("Username should be displayed on the nav bar")
    public void usernameShouldBeDisplayedOnTheNavBar() {
        Assert.assertTrue(pom.isElementDisplayed(loginPage.navBarUsername));
    }
}
