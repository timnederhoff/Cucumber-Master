package nl.timnederhoff.samples.wikipedia;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPage {

    RemoteWebDriver driver;

    public WikiPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h1.firstHeading")
    private WebElement title;

    public String getTitle() {
        return title.getText().trim();
    }

}
