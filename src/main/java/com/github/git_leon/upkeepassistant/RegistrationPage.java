package com.github.git_leon.upkeepassistant;

import com.git_leon.leonium.browsertools.WebPage;
import com.git_leon.leonium.browsertools.With;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends MyWebPage {
    private By byInputUsername = With.tagAttributeValue("input", "name", "username");
    private By byInputEmail = With.tagAttributeValue("input", "name", "email");
    private By byInputPassword = With.tagAttributeValue("input", "name", "password");
    private By byInputConfirmPassword = With.tagAttributeValue("input", "name", "cpassword");
    private By byButtonRegister = With.buttonText("Register");
    private By byButtonLogin = With.buttonText("Login");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void inputUsername(String userName) {
        getBrowserHandler().sendKeys(byInputUsername, userName);
    }

    public void inputEmail(String email) {
        getBrowserHandler().sendKeys(byInputEmail, email);
    }

    public void inputPassword(String password) {
        getBrowserHandler().sendKeys(byInputPassword, password);
    }

    public void inputConfirmPassword(String password) {
        getBrowserHandler().sendKeys(byInputConfirmPassword, password);
    }

    public HomePage clickRegisterButton() {
        getBrowserHandler().getWebEntity(byButtonRegister).click();
        getBrowserHandler().getWait().forAlert();
        getBrowserHandler()// dismiss message box
                .getDriver()
                .switchTo()
                .alert()
                .dismiss();
        return new HomePage(getBrowserHandler().getDriver());
    }

    public HomePage signUp(String username, String email, String password, String cpassword) {
        inputUsername(username);
        inputEmail(email);
        inputPassword(password);
        inputConfirmPassword(cpassword);
        return clickRegisterButton();
    }

    @Override
    public void navigateTo() {
        getBrowserHandler().navigateTo("https://upkeep-assistant.herokuapp.com/registration");
    }
}
