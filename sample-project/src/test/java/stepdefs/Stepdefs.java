package stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.timnederhoff.samples.wikipedia.Homepage;
import nl.timnederhoff.samples.wikipedia.WikiPage;
import nl.timnederhoff.testautomation.testutils.DriverFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.Assert.assertEquals;

public class Stepdefs {

	RemoteWebDriver driver = DriverFactory.getDriver();
	String userName = "";
	String keyPass = "";
	String url = "https://" + userName + ":" + keyPass + "@ondemand.saucelabs.com:443/wd/hub";
	final static Logger LOG = Logger.getLogger(Stepdefs.class);

	private Homepage homepage;
    private WikiPage wikiPage;

	@Given("^the wikipedia page is loaded$")
	public void the_wikipedia_page_is_loaded() throws Throwable {
        homepage = new Homepage(driver);
	}

	@When("^a search with keyword \"([^\"]*)\" is performed$")
	public void a_search_with_keyword_is_performed(String keyword) throws Throwable {
        homepage.setSearchText(keyword);
        homepage.clickSearchButton();
	}

	@Then("^the page with title \"([^\"]*)\" is shown$")
	public void the_page_with_title_is_shown(String title) throws Throwable {
	    wikiPage = new WikiPage(driver);
		assertEquals("The title of the page is not as expected", title, wikiPage.getTitle());
	}

	@After
	public void stopDriverSession(Scenario scenario) {
		if (scenario.isFailed()) {
			DriverFactory.DestroyDriver();
		}
	}
}
