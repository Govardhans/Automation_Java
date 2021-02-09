package de.westwingnow.step.def;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import de.westwingnow.config.TestConfig;
import de.westwingnow.exceptions.WishListProductIndexOutOfBound;
import de.westwingnow.page.object.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepDefinations extends BaseSteps {

    private static Logger logger = LoggerFactory.getLogger(StepDefinations.class);

    @Before
    public void init(Scenario scenario) {
        logger.info(">>>>>>>>>>>>>>>  Test Started <<<<<<<<<<<<<<");
        Selenide.open("");
        webDriver = WebDriverRunner.getWebDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        logger.info(">>>>>>>>>>>>>>>  Test Status {} <<<<<<<<<<<<<<", scenario.getStatus());
        logger.info("\n\n");
        webDriver.quit();
    }

    @Given("I am on the WestwingNow home page")
    public void iAmOnTheWestwingNowHomePage() {
        homePage = new HomePage(webDriver);
        homePage.isDisplayed();
        homePage.acceptCookiesPolicy();
    }

    @When("I search for {string}")
    public void iSearchFor(String string) {
        searchComponent = homePage.getHeader().getSearchComponent();
        searchComponent.isDisplayed();
        searchComponent.search(string);
    }

    @Then("I should see product listing page with a list of products")
    public void iShouldSeeProductListingPageWithAListOfProducts() {
        productContainerComponent =
                homePage.getContainerComponent().getMainContentComponent().getProductComponent();
        productContainerComponent.isDisplayed();
    }

    @When("I click on wishlist icon of the first found product")
    public void iClickOnWishlistIconOfTheFirstFoundProduct() {
        productContainerComponent.addProductInWishList(1);
    }

    @Given("I store current wish list item's count in to {string}")
    public void iStoreCurrentWishListItemSCountInTo(String key) {
        int wishListCount = homePage.getHeader().getWishListComponent().getWishListCount();
        testContext.setContext(key, wishListCount);
    }

    @Then("I should see the login\\/registration overlay")
    public void iShouldSeeTheLoginRegistrationOverlay() {
        loginOrRegisterComponent = homePage.getLoginOrRegisterComponent();
        loginOrRegisterComponent.isDisplayed();
    }

    @When("I switch to login form of the overlay")
    public void iSwitchToLoginFormOfTheOverlay() {
        loginOrRegisterComponent.switchToLoginForm();
    }

    @When("I log in with {string}  credentials")
    public void iLogInWithCredentials(String userName) {
        loginOrRegisterComponent.login(TestConfig.USER_ID, TestConfig.USER_PASSWORD);
    }

    @Then("the product should be added to the wishlist")
    public void theProductShouldBeAddedToTheWishlist() {
        int wishListCount = homePage.getHeader().getWishListComponent().getWishListCount();
        Assert.assertTrue(wishListCount > 0);

    }

    @Then("{string} should be incremented by {int}")
    public void shouldBeIncrementedBy(String string, Integer counter) {
        Object obj = testContext.getContext(string);
        int expectedValue = (int) obj + counter;
        int actualValue = homePage.getHeader().getWishListComponent().getWishListCount();

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Then("I go to the wishlist page")
    public void iGoToTheWishlistPage() {
        wishListPage = homePage.getHeader().getWishListComponent().viewWishList();
        wishListPage.getWishListContainerComponent().isDisplayed();
    }

    @Then("I delete the product from my wishlist")
    public void iDeleteTheProductFromMyWishlist() throws WishListProductIndexOutOfBound {
        wishListPage.getWishListContainerComponent().removeProduct(1);
    }

    @Then("the product should be removed from the wishlist")
    public void theProductShouldBeRemovedFromTheWishlist() {
    }
}
