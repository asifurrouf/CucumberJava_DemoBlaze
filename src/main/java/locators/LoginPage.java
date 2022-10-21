package locators;

import org.openqa.selenium.By;

public class LoginPage {
    public By loginTab = By.id("login2");
    public By loginForm = By.id("logInModal");
    public By usernameField = By.id("loginusername");
    public By passwordField = By.id("loginpassword");
    public By loginButton = By.xpath("//button[contains(text(), 'Log in')]");
    public By navBarUsername = By.id("nameofuser");
}
