package testcases;

import base.BasePage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;

public class LoginPageTest extends BasePage {

    HomePage pageHome;

   @Test (groups = "smoke")
    public void verifyLoginPage_test1(ITestContext context){

       String share_var = "just checking";
       context.setAttribute("shared_var",share_var);
       test.log(Status.INFO, "test1 : Verifying the presence of logo");
       System.out.println("Thread num from verifyLoginPage_test1 " +Thread.currentThread().getId());

       if(pageLogin.verifyLogin()) {
            Assert.assertTrue(true);
            test.pass("test1 :  : Login page is displayed as expected!!");
        }
        else {
            Assert.assertTrue(false);
            test.fail("test1 : Logo is missing! Login page is't displayed as expected!!");
        }
    }

    //@Test (groups = "smoke")
    public void verifyLoggedIn_test2(){
        pageHome = pageLogin.login();
        String expected = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        String actual = driver.getCurrentUrl();

        test.log(Status.INFO, "test2 : Verifying if logged in successfully!!");
        System.out.println("Thread num from VerifyLoggedin_test2 " +Thread.currentThread().getId());

        try {
            test.pass("test2 : Logged in successfully");
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File("target/Spark/screenshot.png");
            //FileUtils.copyFile(SrcFile, DestFile);

            Assert.assertEquals(actual, expected);
        }
        catch (AssertionError error){
            test.fail(error.getMessage());
        }

    }
}
