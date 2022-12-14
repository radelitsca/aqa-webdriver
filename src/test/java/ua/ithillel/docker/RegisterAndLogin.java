package ua.ithillel.docker;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.ithillel.UI.browser.WebDriverProviderLazy;
import ua.ithillel.UI.model.User;
import ua.ithillel.UI.utils.ConfigProvider;


public class RegisterAndLogin {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void BeforeTest() {
        driver = WebDriverProviderLazy.getInstance().getDriver();
    }

    @Test
    public void RegisterTest() {
        Faker faker = new Faker();
        User user = User.builder()
                .setUserName(faker.name().username())
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                .setPassword(faker.internet().password())
                .build();
        driver.navigate().to(ConfigProvider.BASE_URL);
        driver.findElement(By.id("register")).findElement(By.xpath("./child::*")).click();
        driver.findElements(By.name("username")).get(1).sendKeys(user.getUserName());
        driver.findElement(By.name("first-name")).sendKeys(user.getFirstName());
        driver.findElement(By.name("last-name")).sendKeys(user.getLastName());
        driver.findElement(By.name("email")).sendKeys(user.getEmail());
        driver.findElements(By.name("password")).get(1).sendKeys(user.getPassword());
        driver.findElements(By.className("btn")).get(2).click();

        driver.findElement(By.id("logout")).findElement(By.xpath("./child::*")).click();

        driver.findElement(By.id("login")).findElement(By.xpath("./child::*")).click();

        driver.findElements(By.name("username")).get(0).sendKeys(user.getUserName());
        driver.findElements(By.name("password")).get(0).sendKeys(user.getPassword());
        driver.findElement(By.className("fa-sign-in")).click();

        Assert.assertEquals(driver.findElement(By.id("login-message")).getText(), "Login successful.");
    }

    @AfterTest
    public void AfterTest() {
        driver.quit();
    }
}
