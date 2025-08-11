package com.ui.pages;

import com.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BrowserUtility {
    private static final By myAccountNameLocator = By.xpath("//a[@title='View my customer account']/span");
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() throws InterruptedException {
        Thread.sleep(3000);
        return getVisibleText(myAccountNameLocator);
    }
}
