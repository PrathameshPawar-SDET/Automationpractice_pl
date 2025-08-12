package com.ui.tests;

import com.constant.Browser;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    HomePage homePage;
    @BeforeMethod(description = "Load the homepage of the website")
    public void setup(){
        homePage = new HomePage(Browser.CHROME);
    }
    @Test(description = "Verifies with the valid user is able to login into application", groups = {"e2e","sanity"}, dataProviderClass = com.ui.dataprovider.LoginDataProvider.class,dataProvider = "LoginTestDataProvider")
    public void loginTest(User user) throws InterruptedException {
        Assert.assertEquals(homePage.goToLoginPage().doLoginWithValidCredential(user.getEmailaddress(), user.getPassword()).getUserName(),"Prathamesh Pawar");
    }
}
