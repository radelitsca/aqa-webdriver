package ua.ithillel.docker;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.ithillel.UI.browser.Factory;
import ua.ithillel.UI.utils.ConfigProvider;

import java.time.Duration;


public class RegisterUser {
    private WebDriver driver;

    @BeforeTest
    public void BeforeTest() {

        driver = Factory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void RegisterTest() {
        driver.navigate().to(ConfigProvider.BASE_URL);

        driver.findElement(By.id("register")).findElement(By.xpath("./child::*")).click();

        driver.findElements(By.name("username")).get(1).sendKeys(getString());
        driver.findElements(By.name("first-name")).get(0).sendKeys(getString());
        driver.findElement(By.name("last-name")).sendKeys(getString());
        driver.findElement(By.name("email")).sendKeys(getString() + "@gmail.com");
        driver.findElements(By.name("password")).get(1).sendKeys(getString());
        driver.findElements(By.className("btn")).get(2).click();

        Assert.assertEquals(driver.findElement(By.id("registration-message")).getText(), "Registration and login successful.");

    }

    @AfterTest
    public void AfterTest() {
        driver.close();
    }

    public String getString() {
        return (RandomStringUtils.randomAlphabetic(6));
    }

}
