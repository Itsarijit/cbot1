package cukeTests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "Features/user2",
        tags = "@getstarted",
        
        format = { "pretty",
        "html:target/site/cucumber-pretty",
        "rerun:target/rerun.txt",
        "json:target/CA.json" })
public class RunCukesTest2 extends AbstractTestNGCucumberTests {
}