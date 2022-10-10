package ua.ithillel.UI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ua.ithillel.UI.model.User;
import ua.ithillel.UI.utils.ConfigProvider;
import ua.ithillel.UI.utils.WaitUtils;

public class MainPage extends Page {
    private By registerLink = By.xpath("//a[@data-target=\"#register-modal\"]");
    private By logInMessage = By.id("registration-message");
    private By logoutlink = By.xpath("//a[@onclick=\"logout()\"]");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProvider.BASE_URL);
    }

    public RegisterForm clickRegister() {
        driver.findElement(registerLink).click();
        return new RegisterForm();
    }

    public class RegisterForm {
        private By userName = By.id("register-username-modal");
        private By firstName = By.id("register-first-modal");
        private By lastName = By.id("register-last-modal");
        private By email = By.id("register-email-modal");
        private By password = By.id("register-password-modal");
        private By registerButton = By.xpath("//button[@onclick=\"return register()\"]");

        public void fillRegisterForm(User user) {
            driver.findElement(userName).sendKeys(user.getUserName());
            driver.findElement(firstName).sendKeys(user.getFirstName());
            driver.findElement(lastName).sendKeys(user.getLastName());
            driver.findElement(email).sendKeys(user.getEmail());
            driver.findElement(password).sendKeys(user.getPassword());
            driver.findElement(registerButton).click();
            WaitUtils.waitForElementToDisappear(driver, By.className("modal-content"));
        }

    }

    public boolean isUserLoggedIn() {
        WaitUtils.waitUntilElementIsVisible(driver, logoutlink);
        return driver.findElements(logoutlink).size()>0;
    }

    public LoginForm logout() {
        WaitUtils.waitUntilElementIsVisible(driver, logoutlink);
        driver.findElement(logoutlink).click();
        return new LoginForm();

    }

    public class LoginForm {
        private By loginLink = By.xpath("//li[@id=\"login\"]//*");
        private By userNameLogin = By.id("username-modal");
        private By passwordLogin = By.id("password-modal");
        private By loginButton = By.xpath("//button[@onclick=\"return login()\"]");

        public void login(User user) {
            WaitUtils.waitUntilElementIsVisible(driver, loginLink);
            driver.findElement(loginLink).click();
            driver.findElement(userNameLogin).sendKeys(user.getUserName());
            driver.findElement(passwordLogin).sendKeys(user.getPassword());
            driver.findElement(loginButton).click();
        }
    }

}
