package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import reports.ExtentManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver driver;
    public LoginPage pageLogin;
    public WebDriverWait wait;
    public ExtentSparkReporter sparkReport;
    public ExtentReports extent;
    public ExtentTest test;
    public SoftAssert softAssertion;
    public TakesScreenshot scrShot;
    public Properties prop;


    @BeforeMethod //(alwaysRun = true)
    public void setup_before_each_test(ITestResult res, ITestContext con) throws IOException, ParseException {

        prop = new Properties();
        String path = "/Users/pritipradhan/IdeaProjects/OrangeHRM/src/main/resources/project.properties";
        FileInputStream fp = new FileInputStream(path);
        prop.load(fp);

        System.setProperty("webdriver.chrome.driver",
                "/Users/pritipradhan/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        pageLogin = new LoginPage(driver,prop);

        extent = ExtentManager.getReports();
        test = extent.createTest(res.getMethod().getMethodName().toLowerCase());
        softAssertion = new SoftAssert();
        scrShot =((TakesScreenshot)driver);

        System.out.println("** Printing from BasePage ** Running :" +res.getMethod().getMethodName().toLowerCase());
         String [] arr = con.getAllTestMethods()[0].getGroups();
         for(String arr_elem : arr){
            System.out.println(arr_elem);
        }
        System.out.println("-------");
        System.out.println("Comment added just to check git first commit");

//        String path_sys_data = System.getProperty("user.dir")+"/src/main/resources/test2.json";
//        FileReader reader = new FileReader(path_sys_data);
//
//        JSONParser parser = new JSONParser();
//        JSONObject json = (JSONObject) parser.parse(reader);
//
//        JSONArray arr_all_tests = (JSONArray) json.get("testdata");
//        System.out.println("Array of testdata : "+arr_all_tests);
//
//        for(int i=0; i<arr_all_tests.size();i++){
//
//            JSONObject testcase = (JSONObject) arr_all_tests.get(i);
//            String testcase_name = (String) testcase.get("testname");
//            System.out.println("Test case is "+testcase_name);
//
//            JSONArray arr_data = (JSONArray) testcase.get("data");
//            //System.out.println("Data is : "+arr_data);
//            // iterating through data and
//            for(int j=0;j<arr_data.size();j++){
//                JSONObject testcase_data = (JSONObject) arr_data.get(j);
//                System.out.println("testcase data " +testcase_data);
//                Set<String> keys = testcase_data.keySet();
//                System.out.println(" Key set is " +keys);
//                Iterator iterator = keys.iterator();
//                while (iterator.hasNext()){
//                    String key = (String) iterator.next();
//                    System.out.println("key and value : " +key +" " +testcase_data.get(key) );
//                }
//            }
//        }





    }

//     creating the extent report in before test will only be helpful fo creating same report for test cases running in same file
//    @BeforeSuite
//    public void report_setup(){
//        sparkReport = new ExtentSparkReporter("target/Spark/spark.html");
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReport);
//    }

  @AfterMethod //(alwaysRun = true)
    public void tearDown_after_each_test(){
        driver.close();
        extent.flush();
        softAssertion.assertAll();
    }

}
