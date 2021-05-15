package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage  {

    public By admin = By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]");
    public By pim = By.xpath("//*[@id=\"menu_pim_viewPimModule\"]");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public Boolean verifyAdminPage(){
        if(driver.findElement(admin)!=null)
            return true;
        else
            return false;
    }

    public Boolean verifyPIMpage(){
        if(driver.findElement(pim)!=null)
            return true;
        else
            return false;
    }

    public SystemUsersPage click_admin(){
        driver.findElement(admin).click();
        return new SystemUsersPage(driver);
    }

    public EmployeeInfoPage click_pim(){
        driver.findElement(pim).click();
        return new EmployeeInfoPage(driver);
    }

}
