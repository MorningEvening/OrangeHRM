package pages;

import base.BasePage;
import okio.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.*;

public class SystemUsersPage extends BasePage {

    By searchEmp_id = By.id("searchSystemUser_employeeName_empName");
    By searchTap_xpath =  By.xpath("//*[@id=\"searchBtn\"])");
    By getSearchTap_xpath = By.xpath("//*[@id='search_form']/fieldset/p/input[1]");

    By add_user_xpath = By.xpath("//*[@id=\"btnAdd\"]");
    By user_role_id = By.id("systemUser_userType");
    By emp_name_id = By.id("systemUser_employeeName_empName");
    By user_name_id = By.id("systemUser_userName");
    By status_id = By.id("systemUser_status");
    By pass_id = By.id("systemUser_password");
    By conf_id = By.id("systemUser_confirmPassword");

    By save_id = By.xpath("//*[@id=\"btnSave\"]");
    By user_id = By.id("searchSystemUser_userName");

    By user_mgmt = By.xpath("//*[@class='current main-menu-first-level-list-item']/ul/li/a[contains(text(),'User Management')]");
    By job_xpath= By.xpath("//*[@id=\"menu_admin_Job\"]");
    By job_titles = By.xpath("//*[@id=\"menu_admin_viewJobTitleList\"]");
    By list_titles = By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]");

    public  SystemUsersPage(WebDriver driver){
        this.driver = driver;

    }

    public void selectStatus(String select_dropdown){

        //WebElement mySelectedElem = driver.findElement(By.xpath("//select[@name=\"searchSystemUser[status]\"]"));

        WebElement mySelectedElem = driver.findElement(By.id("select"));
        System.out.println("myselected element " +mySelectedElem);
        Select dropdown= new Select(mySelectedElem);

        System.out.println("dropdown is " +dropdown);
        System.out.println("dropdown select value is " +select_dropdown);
        dropdown.selectByValue(select_dropdown);

    }

    public Boolean VerifyEmployee(String searchEmp)  {
        driver.findElement(searchEmp_id).sendKeys(searchEmp);
        wait=new WebDriverWait(driver, 20);

        System.out.println("wait is "+wait);
        //WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchBtn\"]")));
        //search.click();
        driver.findElement(getSearchTap_xpath).click();

//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();",search);

        List<WebElement> list_names;
        list_names = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[4]"));
        for(WebElement name : list_names){
            name.getText();
            if(name.getText().equals(searchEmp))
                return true;
        }
        return false;
    }

    public Boolean VerifyUser(String searchUser)  {
        driver.findElement(user_id).sendKeys(searchUser);
        wait=new WebDriverWait(driver, 20);

        System.out.println("wait is "+wait);
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchBtn\"]")));
        //search.click();

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",search);

        List<WebElement> list_names;
        list_names = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[4]"));
        for(WebElement name : list_names){
            name.getText();
            if(name.getText().equals(searchUser))
                return true;
        }
        return false;
    }


    //public void AddUser(String user_role, String emp_name, String user_name, String status, String pass, String conf_pass){
    //public void AddUser(Object user_role, Object emp_name, Object user_name, Object status, Object pass, Object conf_pass){


    public void AddUser(Map map){


         System.out.println("Inside Add user");
         //driver.findElement(add_user_xpath).click();

        WebElement element = driver.findElement(add_user_xpath);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        System.out.println("element " +element);
        System.out.println("Clicked on Add user");
        Select dropdown_user_role = new Select(driver.findElement(user_role_id));

        dropdown_user_role.selectByValue((String) map.get("user_role"));
        driver.findElement(emp_name_id).sendKeys((CharSequence) map.get("emp_name"));
        driver.findElement(user_name_id).sendKeys((CharSequence) map.get("user_name"));
        Select drop_down_status = new Select(driver.findElement(status_id));
        drop_down_status.selectByValue((String) map.get("status"));
        driver.findElement(pass_id).sendKeys((CharSequence) map.get("pass"));
        driver.findElement(conf_id).sendKeys((CharSequence) map.get("conf_pass"));


//        dropdown_user_role.selectByValue(user_role);
//        driver.findElement(emp_name_id).sendKeys(emp_name);
//        driver.findElement(user_name_id).sendKeys(user_name);
//        Select drop_down_status = new Select(driver.findElement(status_id));
//        drop_down_status.selectByValue(status);
//        driver.findElement(pass_id).sendKeys(pass);
//        driver.findElement(conf_id).sendKeys(conf_pass);


    }

    public void SaveUser(){
        //driver.findElement(save_id).click();

        //driver.findElement(save_id).sendKeys(Keys.ENTER);
//        System.out.println("Running save button!! ");
//        WebElement element = driver.findElement(save_id);
//        System.out.println("element " +element);
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();",element);

        WebDriverWait w = new WebDriverWait(driver,20);
        WebElement element = w.until(ExpectedConditions.elementToBeClickable(save_id));
        element.click();
    }

    public Boolean verifyjobTitle(String jobTtile){

        driver.findElement(job_xpath).click();
        driver.findElement(job_titles).click();
        List <WebElement> list = driver.findElements(list_titles);
        for(WebElement ele : list){
            if(ele.getText().equals(jobTtile)){
                return true;
            }
        }
        return false;
    }

}
