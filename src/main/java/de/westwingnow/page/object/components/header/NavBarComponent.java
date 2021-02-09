package de.westwingnow.page.object.components.header;

import de.westwingnow.page.object.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBarComponent extends AbstractComponent {

    @FindBy(css = "a[href='/new-products/']")
    private WebElement newProductLink;

    public NavBarComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> newProductLink.isDisplayed());
    }
}
