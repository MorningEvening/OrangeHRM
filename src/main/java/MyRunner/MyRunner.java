package MyRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/pritipradhan/IdeaProjects/OrangeHRM/src/main/java/Features",
                 glue = {"stepDefinitions"})
public class MyRunner {


}
