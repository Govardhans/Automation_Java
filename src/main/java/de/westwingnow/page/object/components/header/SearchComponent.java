package de.westwingnow.page.object.components.header;

import de.westwingnow.page.object.common.AbstractComponent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchComponent extends AbstractComponent {

    @FindBy(css = "input[data-testid='search-input']")
    WebElement searchField;

    @FindBy(css = "div[data-testid='search-input-dismiss-click']")
    WebElement searchGlass;

    public SearchComponent(WebDriver driver) {
        super(driver);
    }

    public void search(String str) {
        searchField.clear();
        searchField.sendKeys(str + Keys.ENTER);
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> searchField.isDisplayed());
    }
}
