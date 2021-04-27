package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginPage extends BasePage {

    By loginPage = By.xpath("//*[@id=\"divLogo\"]/img");
    // when new login page is created it
    public LoginPage(WebDriver driver, Properties prop){

        this.driver = driver;
        this.prop = prop;
    }

    public Boolean verifyLogin(){
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
