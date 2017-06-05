package runners;

import nl.timnederhoff.testautomation.platforms.App;
import nl.timnederhoff.testautomation.platforms.Grid;
import nl.timnederhoff.testautomation.platforms.OS;
import nl.timnederhoff.testautomation.testutils.DriverFactory;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsWindowsChrome {
    static final Logger LOG = Logger.getLogger(SauceLabsWindowsChrome.class);

    @BeforeClass
    public static void kickOff() {
        RemoteWebDriver driver = DriverFactory.setupDriver(Grid.SAUCELABS, OS.WINDOWS, App.CHROME);
        LOG.info("Started the Runner");
    }

    @AfterClass
    public static void tearDown() {
        DriverFactory.DestroyDriver();
    }
}
