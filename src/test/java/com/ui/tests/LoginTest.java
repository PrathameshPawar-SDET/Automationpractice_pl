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
    @Test(description = "Verifies with the valid user is able to login into application using json file", groups = {"e2e","sanity"}, dataProviderClass = com.ui.dataprovider.LoginDataProvider.class,dataProvider = "LoginTestJSONDataProvider")
    public void loginTestWithJSON(User user) throws InterruptedException {
        Assert.assertEquals(homePage.goToLoginPage().doLoginWithValidCredential(user.getEmailaddress(), user.getPassword()).getUserName(),"Prathamesh Pawar");
    }

    @Test(description = "Verifies with the valid user is able to login into application using CSV file", groups = {"e2e","sanity"}, dataProviderClass = com.ui.dataprovider.LoginDataProvider.class,dataProvider = "LoginTestCSVDataProvider")
    public void loginTestWithCSV(User user) throws InterruptedException {
        Assert.assertEquals(homePage.goToLoginPage().doLoginWithValidCredential(user.getEmailaddress(), user.getPassword()).getUserName(),"Prathamesh Pawar");
    }
}
