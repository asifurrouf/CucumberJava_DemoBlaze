package locators;

import org.openqa.selenium.By;

public class Contact {
    public By contactTab = By.xpath("//a[contains(text(), 'Contact')]");
    public By newMessageForm = By.xpath("(//div[@class=\"modal-body\"]/form)[1]");
    public By contactEmailField = By.id("recipient-email");
    public By contactNameField = By.id("recipient-name");
    public By messageField = By.id("message-text");
    public By sendMessageButton = By.xpath("//button[contains(text(), 'Send message')]");
}