package testcases;

import DataProviders.TestDataProvider;
import base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SystemUsersPage;

import java.util.HashMap;
import java.util.Map;

public class SystemUsersTest extends BasePage {

    public SystemUsersPage pageSys;

    //@Test (groups = "smoke")
    public void verifyUsers() {
        pageSys = pageLogin.login().click_admin();
        if((pageSys.VerifyUser("John Smith") == true)) {
            test.pass("Users page verified!!");
            Assert.assertTrue(true);
        }
        else{
            test.fail(" Failed to verify Users page!!");
            Assert.assertTrue(false);
        }
    }

    @Test (groups = "sanity", dataProviderClass = TestDataProvider.class,dataProvider ="getData")
    //public void AddUser(String user_role, String emp_name, String user_name, String status, String pass, String conf_pass){

    public void AddUser(Map data){
        pageSys = pageLogin.login().click_admin();

        System.out.println("Running Adduser for " +data.get("user_role"));
        //if(pageSys.VerifyEmployee(emp_name)){

        if(pageSys.VerifyEmployee((String) data.get("emp_name"))){
            System.out.println("User found");
            //pageSys.AddUser(user_role,emp_name,user_name,status,pass,conf_pass);

            //pageSys.AddUser(data.get("user_role"),data.get("emp_name"),data.get("user_name"),data.get("status"),data.get("pass"),data.get("conf_pass"));
            pageSys.AddUser(data);
            pageSys.SaveUser();
//            if(pageSys.VerifyUser(user_name)){
//                test.pass("User added successfully");
//                Assert.assertTrue(true);
//            }else {
//                test.fail("Failed to add!!");
//                Assert.assertTrue(false);
//            }
        }
        else {
            System.out.println("User Not found");
            test.fail("Username doesn't exist");
            Assert.assertTrue(false);
        }

        // On this page entering the data in the fields from the data provider

    }


}
