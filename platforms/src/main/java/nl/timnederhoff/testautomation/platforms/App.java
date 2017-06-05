package nl.timnederhoff.testautomation.platforms;

import org.openqa.selenium.remote.DesiredCapabilities;

public enum App {
    CHROME(new String[]{"browserName=chrome"}),
    FIREFOX(new String[]{"browserName=firefox"}),
    SAFARI(new String[]{"browserName=safari"}),
    IE(new String[]{"browserName=internet explorer"}),
    EDGE(new String[]{"browserName=edge"});

    DesiredCapabilities capas = new DesiredCapabilities();

    App(String[] capas) {
        for (String cap : capas) {
            this.capas.setCapability(cap.split("=")[0], cap.split("=")[1]);
        }
    }

    public DesiredCapabilities getCapabilities() {
        return capas;
    }
}