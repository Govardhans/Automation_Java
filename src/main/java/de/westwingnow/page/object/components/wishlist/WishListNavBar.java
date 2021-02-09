package de.westwingnow.page.object.components.wishlist;

import de.westwingnow.page.object.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListNavBar extends AbstractComponent {

    @FindBy(css = "li[data-qa-name='Wunschliste']")
    private WebElement wishList;

    @FindBy(css = ".blockWishlistNavigation__addListButton")
    private WebElement newWishList;

    public WishListNavBar(WebDriver driver) {
        super(driver);
    }

    //ToDo:
    public void createNewList(String listName) {

    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> wishList.isDisplayed());
    }
}
