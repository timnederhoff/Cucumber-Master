package nl.timnederhoff.testautomation.platforms;

import org.openqa.selenium.remote.DesiredCapabilities;

import static nl.timnederhoff.testautomation.platforms.DeviceType.DESKTOP;
import static nl.timnederhoff.testautomation.platforms.DeviceType.MOBILE;

public enum OS {
    WINDOWS(DESKTOP, new String[]{"platformName=WINDOWS"}),
    LINUX(DESKTOP, new String[]{"platformName=LINUX"}),
    OSX(DESKTOP, new String[]{"platformName=MAC"}),
    ANDROID(MOBILE, new String[]{}),
    IOS(MOBILE, new String[]{});

    DeviceType deviceType;
    DesiredCapabilities capas = new DesiredCapabilities();

    OS(DeviceType deviceType, String[] capas) {
        for (String cap : capas) {
            this.capas.setCapability(cap.split("=")[0], cap.split("=")[1]);
        }
        this.deviceType = deviceType;

    }

    public boolean isMobile() {
        return deviceType == DeviceType.MOBILE;
    }

    public DesiredCapabilities getCapabilities() {
        return capas;
    }
}