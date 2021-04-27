package runner;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testNGRunner {

    public static void main (String [] args) {
        TestNG testng = new TestNG();
        XmlSuite suite1 = new XmlSuite();
        suite1.setName("Suite");

        List<XmlSuite> allSuites = new ArrayList<XmlSuite>();
        allSuites.add(suite1);
        testng.setXmlSuites(allSuites);

        XmlTest test = new XmlTest(suite1);
        test.setName("test");

        Map<String,String> parameters = new HashMap<>();
        parameters.put("browser1","chrome");
        parameters.put("broswer2","safari");
        test.setParameters(parameters);

        List<XmlClass> classes = new ArrayList<>();
        XmlClass testClass = new XmlClass("testcases.LoginPageTest");

        List<XmlInclude> methods = new ArrayList<>();
        methods.add(new XmlInclude("verifyLoginPage_test1"));
        methods.add(new XmlInclude("verifyLoggedIn_test2"));
        testClass.setIncludedMethods(methods);

        classes.add(testClass);
        test.setXmlClasses(classes);
//      classes.add(new XmlClass("testcases.EmployeeInfoTest"));
//      classes.add(new XmlClass("testcases.SystemUsersTest"));

          testng.run();

    }

}
