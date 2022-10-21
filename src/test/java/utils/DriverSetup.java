package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverSetup {
    public WebDriver driver;

    public WebDriver setDriver() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
        Properties properties = new Properties();

        properties.load(fis);

        String url = properties.getProperty("url");
        String browserProperties = properties.getProperty("browser");
        String browserMaven = System.getProperty("browser");

        String browser = browserMaven != null ? browserMaven : browserProperties;

        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();
            }
            if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir" + "/src/test/resources/geckodriver.exe"));
                driver = new FirefoxDriver();
            }
            driver.manage().window().maximize();
            driver.get(url);
        }
        return driver;
    }

    public DriverSetup() throws IOException {
        driver = setDriver();
    }
}
