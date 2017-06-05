package nl.timnederhoff.testautomation.testutils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import nl.timnederhoff.testautomation.platforms.App;
import nl.timnederhoff.testautomation.platforms.Grid;
import nl.timnederhoff.testautomation.platforms.OS;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    private DriverFactory() {
    }

    private static RemoteWebDriver driver;
    private static Grid GRID;
    private static OS OS;
    private static App APP;

    public static RemoteWebDriver setupDriver(Grid grid, OS os, App app) {
        GRID = grid;
        OS = os;
        APP = app;

        init();

        return driver;
    }

    private static void init() {
        switch (OS) {
            case ANDROID: driver = new AndroidDriver(GRID.getUrl(), OS.getCapabilities().merge(APP.getCapabilities())); break;
            case IOS: driver = new IOSDriver(GRID.getUrl(), OS.getCapabilities().merge(APP.getCapabilities())); break;
            default: driver = new RemoteWebDriver(GRID.getUrl(), OS.getCapabilities().merge(APP.getCapabilities()));
        }
    }

    public static RemoteWebDriver getDriver() {
        if (driver == null) {
            init();
        }
        return driver;
    }

    public static void DestroyDriver() {
        driver.quit();
    }
}
