package nl.timnederhoff.samples.wikipedia;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    private RemoteWebDriver driver;

    public Homepage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get("https://www.wikipedia.org");
    }

    @FindBy(css = "input#searchInput")
    private WebElement searchField;

    @FindBy(css = "i.sprite-icons-search-icon")
    private WebElement searchButton;

    public void setSearchText(String searchText) {
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }


}
