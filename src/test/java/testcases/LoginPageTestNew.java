package testcases;

import base.BasePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPageNew;

public class LoginPageTestNew extends BasePage {


    @Test(groups = "sanity")
    public void verifyLoginPage_test_new(){

        LoginPageNew loginPageNew = PageFactory.initElements(driver, LoginPageNew.class);
        if(loginPageNew.verifyLogin()){
            Assert.assertTrue(true);
            test.pass("test1 :  : Login page is displayed as expected!!");
        }
        else {
            Assert.assertTrue(false);
            test.fail("test1 : Logo is missing! Login page is't displayed as expected!!");
        }
    }

}
