package com.ui.pages;

import com.constant.Browser;
import com.constant.Env;
import com.utilities.BrowserUtility;
import com.utilities.JSONUtils;
import com.utilities.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BrowserUtility {

    private static final By SIGN_IN_LOCATOR= By.xpath("//a[contains(text(),'Sign in')]");
    public HomePage(Browser browser) {
        super(browser);
        goToWebsite(JSONUtils.readJson(Env.DEV).getUrl());
    }

    public LoginPage goToLoginPage(){
        clickOn(SIGN_IN_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }




}
