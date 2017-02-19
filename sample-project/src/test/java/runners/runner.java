package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
		features = "src/test/resources/features/firstFeature.feature",
		glue = "stepdefs",
		format = {"pretty", "html:target/cucumber-html-report.html"})
@RunWith(Cucumber.class)
public class runner {

}
