package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import nl.timnederhoff.testautomation.platforms.App;
import nl.timnederhoff.testautomation.platforms.Grid;
import nl.timnederhoff.testautomation.platforms.OS;
import nl.timnederhoff.testautomation.testutils.DriverFactory;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.RemoteWebDriver;

@CucumberOptions(
		features = "src/test/resources/features/firstFeature.feature",
		glue = "stepdefs",
		format = {"pretty", "html:target/cucumber-html-report.html"})
@RunWith(Cucumber.class)
public class LocalLinuxChrome {
	static final Logger LOG = Logger.getLogger(LocalLinuxChrome.class);

	@BeforeClass
	public static void kickOff() {
		RemoteWebDriver driver = DriverFactory.setupDriver(Grid.LOCAL, OS.LINUX, App.CHROME);
		LOG.info("Started the Runner");
	}

	@AfterClass
	public static void tearDown() {
		DriverFactory.DestroyDriver();
	}

}
