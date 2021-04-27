package testcases;

import base.BasePage;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeeInfoPage;

public class EmployeeInfoTest extends BasePage {

    public EmployeeInfoPage empPage;

    @Test (groups = {"sanity","broswer2"})
    public void VerifyEmpStatus(){
        empPage = pageLogin.login().click_pim();
        if(empPage.VerifyEmployeeStatus("Freelance1") == true){
            //Assert.assertTrue(true);
            test.pass("FreeLance/value to be verified is in the list");
            softAssertion.assertTrue(true);
        }
        else {
            test.fail("Failed to find the option in the list!");
            softAssertion.assertTrue(false);
             //Assert.assertTrue(false);
            System.out.println("Even after assert fail the control reaches here!!");
        }

    }

}
