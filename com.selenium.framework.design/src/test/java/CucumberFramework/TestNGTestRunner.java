package CucumberFramework;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/hellocucumber",
glue = "classpath:hellocucumber.StepDefinitions",
plugin = {
    "pretty",
    "html:target/cucumber-reports.html",
    "json:target/cucumber.json"
},
monochrome = true, tags="@tag2")

public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
