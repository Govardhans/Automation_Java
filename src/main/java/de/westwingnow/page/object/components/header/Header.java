package de.westwingnow.page.object.components.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Header {

    private WebDriver driver;
    private SearchComponent searchComponent;
    private WishListComponent wishListComponent;
    private NavBarComponent navBarComponent;

    public Header(final WebDriver driver) {
        this.driver = driver;
        this.searchComponent = PageFactory.initElements(driver, SearchComponent.class);
        this.wishListComponent = PageFactory.initElements(driver, WishListComponent.class);
        this.navBarComponent = PageFactory.initElements(driver, NavBarComponent.class);
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public WishListComponent getWishListComponent() {
        return wishListComponent;
    }

    public NavBarComponent getNavBarComponent() {
        return navBarComponent;
    }
}
