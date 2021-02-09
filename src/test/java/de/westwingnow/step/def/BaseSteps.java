package de.westwingnow.step.def;

import de.westwingnow.page.object.components.header.SearchComponent;
import de.westwingnow.page.object.components.login.LoginOrRegisterComponent;
import de.westwingnow.page.object.container.ProductContainerComponent;
import de.westwingnow.page.object.pages.HomePage;
import de.westwingnow.page.object.pages.WishListPage;
import de.westwingnow.utils.TestContext;
import org.openqa.selenium.WebDriver;

/**
 * This class stores instances of page and components
 * to share across all test steps definitions
 */
public class BaseSteps {
    protected HomePage homePage;
    protected WishListPage wishListPage;
    protected WebDriver webDriver;
    protected SearchComponent searchComponent;
    protected ProductContainerComponent productContainerComponent;
    protected LoginOrRegisterComponent loginOrRegisterComponent;
    protected TestContext testContext = new TestContext();

}
