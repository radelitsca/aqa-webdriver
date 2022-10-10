package ua.ithillel.pageObject;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.ithillel.UI.model.User;
import ua.ithillel.UI.pages.MainPage;
import ua.ithillel.docker.BaseTest;

public class RegisterTest extends BaseTest {

    @Test
    public void test() {
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.open();

        MainPage.RegisterForm registerForm = mainPage.clickRegister();
        User user = User.randomUser();
        registerForm.fillRegisterForm(user);

        Assert.assertTrue(mainPage.isUserLoggedIn());
    }
}
