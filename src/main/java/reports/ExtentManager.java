package reports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    static ExtentReports reports;

    public static ExtentReports getReports(){

        if(reports == null){
            reports = new ExtentReports();
            ExtentSparkReporter sparkReport = new ExtentSparkReporter("target/Spark/spark.html");
            sparkReport.config().setReportName("testing with testNG");
            sparkReport.config().setTheme(Theme.DARK);
            reports.attachReporter(sparkReport);
        }

        return reports;
    }
}
