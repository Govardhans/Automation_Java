package de.westwingnow.page.object.wishlist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {

    private WebDriver driver;
    private MoodBoard moodBoard;
    private WishListContainerComponent wishListContainerComponent;
    private WishListNavBar wishListNavBar;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
        this.moodBoard = PageFactory.initElements(this.driver, MoodBoard.class);
        this.wishListContainerComponent = PageFactory.initElements(this.driver, WishListContainerComponent.class);
        this.wishListNavBar = PageFactory.initElements(this.driver, WishListNavBar.class);
    }

    public MoodBoard getMoodBoard() {
        return moodBoard;
    }

    public WishListContainerComponent getWishListContainerComponent() {
        return wishListContainerComponent;
    }

    public WishListNavBar getWishListNavBar() {
        return wishListNavBar;
    }
}
