package com.ui.tests;

import com.constant.Browser;
import com.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    HomePage homePage;
    @BeforeMethod(description = "Load the homepage of the website")
    public void setup(){
        homePage = new HomePage(Browser.CHROME);
    }
    @Test(description = "Verifies with the valid user is able to login into application", groups = {"e2e","sanity"})
    public void loginTest() throws InterruptedException {
        Assert.assertEquals(homePage.goToLoginPage().doLoginWithValidCredential("testbing@gmail.com","Password").getUserName(),"Prathamesh Pawar");
    }
}
