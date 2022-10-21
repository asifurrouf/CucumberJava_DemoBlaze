package stepDefinitions;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import utils.DriverSetup;

public class Hooks {
    WebDriver driver;

    public Hooks(DriverSetup driverSetup) {
        this.driver = driverSetup.driver;
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
