package de.westwingnow.page.object.components.header;

import de.westwingnow.page.object.common.AbstractComponent;
import de.westwingnow.page.object.pages.WishListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WishListComponent extends AbstractComponent {

    private WebDriver driver;
    private static final Logger LOG = LoggerFactory.getLogger(WishListComponent.class);

    @FindBy(css = "div[data-testid='wishlist-bubble']")
    private WebElement wishListElement;

    @FindBy(css = "span[data-testid='wishlist-counter']")
    private WebElement wishListCounter;

    public WishListComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WishListPage viewWishList() {
        wishListElement.click();
        return new WishListPage(driver);
    }

    public int getWishListCount() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until((d) -> wishListCounter.isDisplayed());
            if (wishListCounter.isDisplayed()) {
                return Integer.parseInt(wishListCounter.getText());
            }
        } catch (Exception ex) {
            LOG.info("No items in the wish List");
        }
        return 0;
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> wishListElement.isDisplayed());
    }
}
