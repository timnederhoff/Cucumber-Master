package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;



@CucumberOptions(
		features = "src/test/resources/features/firstFeature.feature",
		glue = "stepdefs",
		format = {"pretty", "html:target/cucumber-html-report.html"})
@RunWith(Cucumber.class)
public class Runner {
	static final Logger LOG = Logger.getLogger(Runner.class);

	@BeforeClass
	public static void kickOff() {
		LOG.info("Started the Runner");
	}

}
