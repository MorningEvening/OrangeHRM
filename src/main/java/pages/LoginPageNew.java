package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Properties;

public class LoginPageNew extends BasePage {

    WebDriver driver;

    @FindBy(how= How.XPATH, using = "//*[@id=\"divLogo\"]/img")
    WebElement loginPage;

    public LoginPageNew (WebDriver driver){
        this.driver = driver;
    }


    public Boolean verifyLogin(){
        System.out.println("Running method from LoginPageNew ");
        if(loginPage!=null)
            return true;
        else
            return false;

    }
}
