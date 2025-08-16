package com.ui.pages;

import com.utilities.BrowserUtility;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BrowserUtility {

    private static final By EMAIL_LOCATOR = By.id("email");
    private static final By PASSWORD_LOCATOR = By.id("passwd");
    private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginWithValidCredential(String email, String password){
    enterText(EMAIL_LOCATOR,email);
    enterText(PASSWORD_LOCATOR,password);
    clickOn(SUBMIT_BUTTON_LOCATOR);
    MyAccountPage myAccountPage = new MyAccountPage(getDriver());
    return myAccountPage;
    }
}
