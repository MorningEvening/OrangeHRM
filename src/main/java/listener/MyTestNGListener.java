package listener;


import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestNGListener implements ITestListener {

    public void onTestFailure (ITestResult result){
        System.out.println("Listener printing - Test failed!!");
    }

    public void onTestSuccess (ITestResult result){
        System.out.println("Listener printing - Test passed!");
    }

}
