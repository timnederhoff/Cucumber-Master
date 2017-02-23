package stepdefs;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.timnederhoff.testautomation.testutils.Configuration;
import nl.timnederhoff.testautomation.testutils.Sleeper;
import org.apache.log4j.Logger;
import org.junit.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MyStepdefs {

	RemoteWebDriver driver;
	String userName = "";
	String keyPass = "";
	String url = "https://" + userName + ":" + keyPass + "@ondemand.saucelabs.com:443/wd/hub";
	final static Logger LOG = Logger.getLogger(MyStepdefs.class);

	@Given("^the first test passes$")
	public void theFirstTestPasses() throws Throwable {
		LOG.info("First test started");
		Config config = ConfigFactory.load();
		System.out.println(config.getString("environment.server"));
//		DesiredCapabilities caps = DesiredCapabilities.firefox();
//		caps.setCapability("platform", "Windows 7");
//		caps.setCapability("version", "51.0");
//		driver = new RemoteWebDriver(new URL(url), caps);
//		driver.get("https://www.wikipedia.org");
//		Sleeper.sleep(1000);
		assertTrue(true);
	}

	@When("^the second test is skipped$")
	public void theSecondTestIsSkipped() throws Throwable {
		LOG.info("Second test started");
		try {
			throw new NullPointerException("One of the steps before the test failed");
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new PendingException("skipped test because exception encountered before assertion arrived.");
		}
	}

	@Then("^the third test should fail$")
	public void theThirdTestShouldFail() throws Throwable {
		LOG.info("Third test started");
		assertEquals("Tim", "Arjen");
	}

	@After
	public void stopDriverSession() {
		driver.quit();
	}
}
