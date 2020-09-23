package com.github.git_leon.upkeepassistant;

import com.git_leon.leonium.browsertools.WebPage;
import com.git_leon.leonium.browsertools.With;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends MyWebPage {
    private By byInputUsername = With.tagAttributeValue("input", "name", "username");
    private By byInputPassword = With.tagAttributeValue("input", "name", "password");
    private By byButtonSignIn = With.buttonText("Sign in");
    private By byButtonCreateAccount = With.buttonText("Create an account");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage navigateToRegistrationPage() {
        getBrowserHandler().getWebEntity(byButtonCreateAccount).click();
        return new RegistrationPage(getBrowserHandler().getDriver());
    }

    @Override
    public void navigateTo() {
        getBrowserHandler().navigateTo("https://upkeep-assistant.herokuapp.com/");
    }

    public void signIn(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickSignInButton();
    }

    public void clickSignInButton() {
        getBrowserHandler().getWebEntity(byButtonSignIn).click();
    }

    public void inputUsername(String userName) {
        getBrowserHandler().sendKeys(byInputUsername, userName);
    }

    public void inputPassword(String password) {
        getBrowserHandler().sendKeys(byInputPassword, password);
    }
}
