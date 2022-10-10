package ua.ithillel.UI.browser;

import org.openqa.selenium.WebDriver;

public class WebDriverProviderLazy {

    private static WebDriverProviderLazy instance;
    private WebDriver driver;

    private WebDriverProviderLazy() {
        driver = Factory.getDriver();
    }

    public static WebDriverProviderLazy getInstance() {
        if (instance == null) {
            instance = new WebDriverProviderLazy();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
