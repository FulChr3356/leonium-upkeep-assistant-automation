package com.github.git_leon.upkeepassistant;

import com.git_leon.leonium.browsertools.factories.BrowserHandlerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CreateNewAccountAndSignIn {
    @Test
    public void test() {
        test("maybeso", "maybeso");
    }

    private void test(
            String username,
            String password) {
        test(username, username + "@gmail.com", password, password);
    }


    private void test(
            String username,
            String email,
            String password,
            String cpassword) {


        WebDriver webDriver = BrowserHandlerFactory.FIREFOX.getDriver();
        HomePage homePage = new HomePage(webDriver);
        homePage.navigateTo();
        RegistrationPage registrationPage = homePage.navigateToRegistrationPage();

        username = username + Long.toString(System.nanoTime(), 16); // hash
        homePage = registrationPage.signUp(username, email, password, cpassword);
        // when
        homePage.signIn(username, password);
        homePage.getBrowserHandler().getWait().forPageLoad();

        // then
        Assert.assertTrue(homePage
                .getBrowserHandler()
                .getDriver()
                .getCurrentUrl()
                .equals("https://upkeep-assistant.herokuapp.com/dashboard"));
    }
}
