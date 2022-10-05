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

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class RegisterAndLogin {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void BeforeTest() {
        driver = Factory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void RegisterTest() {
        driver.navigate().to(ConfigProvider.BASE_URL);
        driver.findElement(By.id("register")).findElement(By.xpath("./child::*")).click();

        String username = getString();
        String password = getString();
        driver.findElements(By.name("username")).get(1).sendKeys(username);
        driver.findElement(By.name("first-name")).sendKeys(getString());
        driver.findElement(By.name("last-name")).sendKeys(getString());
        driver.findElement(By.name("email")).sendKeys(getString() + "@gmail.com");
        driver.findElements(By.name("password")).get(1).sendKeys(password);
        driver.findElements(By.className("btn")).get(2).click();

        wait.until(visibilityOfElementLocated(By.id("logout")));
        driver.findElement(By.id("logout")).findElement(By.xpath("./child::*")).click();

        wait.until(visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).findElement(By.xpath("./child::*")).click();

        wait.until(visibilityOfElementLocated(By.className("modal-content")));
        driver.findElements(By.name("username")).get(0).sendKeys(username);
        driver.findElements(By.name("password")).get(0).sendKeys(password);
        driver.findElement(By.className("fa-sign-in")).click();

        Assert.assertEquals(driver.findElement(By.id("login-message")).getText(), "Login successful.");
    }

    @AfterTest
    public void AfterTest() {
        driver.close();
    }

    public String getString() {
        return (RandomStringUtils.randomAlphabetic(8));
    }

}
