package nl.timnederhoff.testautomation.platforms;

import java.net.MalformedURLException;
import java.net.URL;

public enum Grid {
    LOCAL("http://localhost:4444/wd/hub"),
    BROWSERSTACK("https://browserstack.com:4444/wd/hub"),
    SAUCELABS("https://User:keyPass@ondemand.saucelabs.com:443/wd/hub"),
    PERFECTO("https://mycloud.perfectomobile.com/nexperience");

    String url;

    Grid(String url) {
        this.url = url;
    }

    public URL getUrl() {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            return null;
        }
    }

}
