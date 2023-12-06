package framework.engine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {
    static WebDriver driver;
    public static WebDriver initDriver(String browserType, int implicitWait, Boolean maximize) {
        if (browserType == "chrome") {
            driver = new ChromeDriver();
        } else if (browserType == "firefox") {
            driver = new FirefoxDriver();
        } else if (browserType == "edge") {
            driver = new EdgeDriver();
        } else {
            driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        if (maximize) {
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver initDriver(String browserType) {
        return initDriver(browserType, 20, true);
    }
}
