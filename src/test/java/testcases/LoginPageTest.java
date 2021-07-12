package testcases;

import base.BasePage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import gherkin.lexer.Th;
import io.cucumber.java.bs.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;

public class LoginPageTest extends BasePage {

    HomePage pageHome;

   @Test (groups = "smoke",invocationCount = 2)
    public void verifyLoginPage_test1(ITestContext context) throws InterruptedException {

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

       Actions actions = new Actions(driver);
       WebElement element = driver.findElement(By.xpath("//a[text()=\"Forgot your password?\"]"));
       // //a[contains(text(),"Forgot your password?")]
       actions.moveToElement(element).click().perform();
//
//       Thread.sleep(4000);
//       Action action = actions.moveToElement(element).click().build();
//       action.perform();

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
