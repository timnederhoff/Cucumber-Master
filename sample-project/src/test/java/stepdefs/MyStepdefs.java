package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.timnederhoff.testautomation.testutils.Configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MyStepdefs {
	@Given("^the first test passes$")
	public void theFirstTestPasses() throws Throwable {
		System.out.println(Configuration.SERVER);
		assertTrue(true);
	}

	@When("^the second test is skipped$")
	public void theSecondTestIsSkipped() throws Throwable {
		try {
			throw new NullPointerException("One of the steps before the test failed");
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new PendingException("skipped test because exception encountered before assertion arrived.");
		}
	}

	@Then("^the third test should fail$")
	public void theThirdTestShouldFail() throws Throwable {
		assertEquals("Tim", "Arjen");
	}

}
