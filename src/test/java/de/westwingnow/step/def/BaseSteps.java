package de.westwingnow.step.def;

import de.westwingnow.page.object.HomePage;
import de.westwingnow.page.object.container.content.main.ProductComponent;
import de.westwingnow.page.object.header.SearchComponent;
import de.westwingnow.page.object.login.LoginOrRegisterComponent;
import de.westwingnow.page.object.wishlist.WishListPage;
import de.westwingnow.utils.TestContext;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    protected HomePage homePage;
    protected WishListPage wishListPage;
    protected WebDriver webDriver;
    protected SearchComponent searchComponent;
    protected ProductComponent productComponent;
    protected LoginOrRegisterComponent loginOrRegisterComponent;
    protected TestContext testContext = new TestContext();

}
