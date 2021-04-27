import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {

    public static void main (String args[]) throws MalformedURLException {

        // 1. Define Desired capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.MAC);

        // 2. Chrome Options definition
        ChromeOptions options = new ChromeOptions();
        options.merge(cap);

        String hub_url = "http://192.168.1.3:4444/wd/hub";
        WebDriver driver = new RemoteWebDriver(new URL(hub_url),options);

        driver.get("https://opensource-demo.orangehrmlive.com/");
        System.out.println(driver.getTitle());
    }
}
