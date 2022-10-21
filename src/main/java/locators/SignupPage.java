package locators;

import org.openqa.selenium.By;

public class SignupPage {
    public By signUpTab = By.id("signin2");
    public By signUpForm = By.id("signInModal");
    public By usernameField = By.id("sign-username");
    public By passwordField = By.id("sign-password");
    public By signupButton = By.xpath("//button[contains(text(), 'Sign up')]");
}
