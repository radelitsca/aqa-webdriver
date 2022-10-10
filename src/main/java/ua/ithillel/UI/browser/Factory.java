package ua.ithillel.UI.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

import static ua.ithillel.UI.utils.ConfigProvider.BROWSER;

public class Factory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        driver = getDriver(Browsers.valueOf(BROWSER.toUpperCase()));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }


    private static WebDriver getDriver(Browsers browser) {
        switch (browser) {
            case CHROME:
                return getChromeDriver();
            case SAFARI:
                return getSafariDriver();
            default:
                throw new IllegalArgumentException("Such browser is not implemented");
        }
    }

    private static WebDriver getSafariDriver() {
        if (driver == null) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static WebDriver getChromeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }
}
