package testcases;

import base.BasePage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BasePage {

    public HomePage pageHome;

    @Test (groups = {"smoke", "browser1"},timeOut = 1000)
    public void adminTabTest(ITestContext context){
        String shared_cal = (String) context.getAttribute("shared_var");
        System.out.println("Shared val from adminTabTest " +shared_cal);
        System.out.println("Thread num from adminTabTest " +Thread.currentThread().getId());
        pageHome = pageLogin.login();
        if(pageHome.verifyAdminPage() == true) {
            test.pass("Admin page verified");
            Assert.assertTrue(true);
       }
        else {
            test.fail("Failed to verify Admin page");
            Assert.assertTrue(false);
        }
    }
    @Test (groups = {"smoke", "broswer2"})
    public void PIMtabTest(){
        pageHome = pageLogin.login();
        System.out.println("Thread num from PIMtabTest " +Thread.currentThread().getId());
        if(pageHome.verifyPIMpage() == true){
            test.pass("Employee page verified");
            Assert.assertTrue(true);
        }
    }

}
