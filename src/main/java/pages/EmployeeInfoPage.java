package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class EmployeeInfoPage extends BasePage {

    By emp_search = By.xpath("//*[@id=\"empsearch_employee_status\"]/option");

    public EmployeeInfoPage(WebDriver driver){
        this.driver = driver;
    }

    public Boolean VerifyEmployeeStatus(String status){

        List<WebElement> emp_status = driver.findElements(emp_search);

        for(WebElement emp : emp_status) {
            System.out.println(emp.getText());
            if (emp.getText().equals(status))
                return true;
        }
        return false;
    }

}
