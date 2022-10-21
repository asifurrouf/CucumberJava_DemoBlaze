package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageObjectManager {
    private WebDriver driver;
    private WebDriverWait wait;
    private int defaultWaitTime = 5;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * wait until element is visible for default wait time
     *
     * @param locator
     */
    public void waitUntilElementIsVisible(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * wait until element is visible for specific time
     *
     * @param locator
     * @param waitTime
     */
    public void waitUntilElementIsVisible(By locator, int waitTime) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * wait until element is clickable for specific time
     *
     * @param locator
     * @param waitTime
     */
    public void waitUntilElementIsClickable(By locator, int waitTime) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * click an element
     *
     * @param locator
     */
    public void clickElement(By locator) {
        waitUntilElementIsVisible(locator);
        driver.findElement(locator).click();
    }

    /**
     * click an element using javascript executor
     *
     * @param locator
     * @param waitTime
     */
    public void javaScriptClick(By locator, int waitTime) {
        waitUntilElementIsClickable(locator, waitTime);
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * click an element using javascript executor
     *
     * @param locator
     */
    public void javaScriptClick(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * click an element using javascript executor
     *
     * @param element
     */
    public void javaScriptClickElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * send inputs to an input field
     *
     * @param locator
     * @param inputText
     */
    public void sendKeysToElement(By locator, String inputText) {
        waitUntilElementIsVisible(locator);
        driver.findElement(locator).sendKeys(inputText);
    }

    /**
     * @param locator
     * @return true if element is displayed
     */
    public boolean isElementDisplayed(By locator) {
        waitUntilElementIsVisible(locator);
        return driver.findElement(locator).isDisplayed();
    }

    /**
     * @param locator
     * @return text of an element
     */
    public String getTextOfElement(By locator) {
        waitUntilElementIsVisible(locator);
        return driver.findElement(locator).getText();
    }

    /**
     * @param locator
     * @return WebElement
     */
    public WebElement getWebElement(By locator) {
        waitUntilElementIsVisible(locator);
        return driver.findElement(locator);
    }

    /**
     * @param locator
     * @return WebElement
     */
    public List<WebElement> getWebElements(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Scroll down the web page by the visibility of the element
     *
     * @param locator
     */
    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * @return current url
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * check if a new window is opened with a specific title
     *
     * @param titleText
     * @return true if the title match
     */
    public boolean isTabOpened(String titleText) {
        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        wait.until(ExpectedConditions.titleContains(titleText));
        return driver.getTitle().contains(titleText);
    }
}
