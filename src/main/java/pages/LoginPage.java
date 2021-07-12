package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginPage extends BasePage {

    By loginPage = By.xpath("//*[@id=\"divLogo\"]/img");
    By forgotPass = By.xpath("//a[contains(text(),'Forgot')]");
    // when new login page is created it
    public LoginPage(WebDriver driver, Properties prop, WebDriverWait wait){

        this.driver = driver;
        this.prop = prop;
        this.wait = wait;
    }

    public Boolean verifyLogin() throws InterruptedException {

        /* Practice */

//        driver.navigate().back();
//        Thread.sleep(2000);
//        driver.navigate().forward();
//        Thread.sleep(2000);
//        driver.navigate().to("https://Google.com");
//
//        driver.navigate().back();
//        driver.navigate().back();
//        driver.navigate().refresh();

//        wait.until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver wdriver) {
//                return ((JavascriptExecutor) driver).executeScript(
//                        "return document.readyState"
//                ).equals("complete");
//            }
//        });

//        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
//        System.out.println("wait is " +wait);
//        wait.until(ExpectedConditions.elementToBeClickable(By.name("Submit")));
//
//        driver.findElement(By.id("txtUsername")).sendKeys("temp");
//        driver.navigate().refresh();
//        Thread.sleep(2000);

//        driver.findElement(By.name("txtUsername")).sendKeys("again this time name");
//        driver.navigate().refresh();
//
//        Thread.sleep(2000);
//        driver.findElement(By.linkText("Forgot your password?")).click();
//
//        //System.out.println("Page Source " +driver.getPageSource());
//        //System.out.println("Title of the page :- " +driver.getTitle());
//
//        Thread.sleep(4000);
//
//        driver.navigate().back();
        //driver.findElement(By.linkText("LinkedIn OrangeHRM group")).click();
        //driver.navigate().back();

        //driver.findElement(By.partialLinkText("All rights reserved")).click();

        if(driver.findElement(loginPage)!=null)
            return true;
        else
            return false;

    }
    public HomePage login(){
        System.out.println("Inside login");
        System.out.println("Driver is " +driver);
        System.out.println("prop is " +prop);
        System.out.println("Username from prop file " +prop.getProperty("username"));
        driver.findElement(By.id("txtUsername")).sendKeys(prop.getProperty("username"));
        driver.findElement(By.id("txtPassword")).sendKeys(prop.getProperty("password"));
        driver.findElement(By.id("btnLogin")).click();

        return (new HomePage(driver));
    }


}
