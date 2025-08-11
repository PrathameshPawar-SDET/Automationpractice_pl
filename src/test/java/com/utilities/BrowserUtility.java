package com.utilities;

import com.constant.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtility {

    private WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    public BrowserUtility(WebDriver driver){
        super();
        this.driver=driver;
    }

    public BrowserUtility(Browser browsername){
        if (browsername==Browser.CHROME){
            driver = new ChromeDriver();
        }
        else if (browsername==Browser.FIREFOX){
            driver = new FirefoxDriver();
        } else if (browsername==Browser.EDGE) {
            driver= new EdgeDriver();

        }
        else {
            System.out.println("Invalid Browser Name....");
        }
    }

    public void goToWebsite(String url){
        driver.get(url);
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public void clickOn(By locator){
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void enterText(By locator,String text){
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public String getVisibleText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

}
