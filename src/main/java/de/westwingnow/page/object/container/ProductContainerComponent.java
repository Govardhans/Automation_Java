package de.westwingnow.page.object.container;

import de.westwingnow.page.object.common.AbstractComponent;
import de.westwingnow.page.object.model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductContainerComponent extends AbstractComponent {

    private static final Logger LOG = LoggerFactory.getLogger(ProductContainerComponent.class);

    @FindBy(css = "div[data-testid='generic-product']")
    List<WebElement> genericProductList;

    @FindBy(css = "div[data-testid='wishlist-icon']")
    List<WebElement> wishListIconList;

    @FindBy(css = "div[data-testid='popup-backdrop']")
    WebElement popUpBackDrop;

    @FindBy(css = "div[data-testid='shop-to-club-popup-wrapper']")
    WebElement shopToClubPopUp;

    @FindBy(css = "data-testid='product-title'")
    List<WebElement> productTitleList;

    public ProductContainerComponent(WebDriver driver) {
        super(driver);
    }

    private void closeShopToClubPopUp() {
        try {
            wait.until((d) -> shopToClubPopUp.isDisplayed());
            LOG.info("shop to club window poped-up");
            js.executeScript("arguments[0].click()", popUpBackDrop);
            LOG.info("shop to club window closed");
        } catch (Exception ex) {
        }
    }

    public void addProductInWishList(int index) {
        LOG.info("Add product at index {} to wish list", index);
        this.closeShopToClubPopUp();

        index = index == 0 ? index : index - 1;
        WebElement productElement = genericProductList.get(index);

        WebElement wishListIcon = wait.until(ExpectedConditions.visibilityOf(
                productElement.findElement(By.cssSelector("div[data-testid='wishlist-icon']"))));

        Product product = getProductDetails(productElement);
        LOG.info("product details {} ", product.toString());

        if (product.isAddedToWishList()) {
            LOG.warn("Product is already added to wishlist");
        } else {
            wishListIcon.click();
        }
    }

    public Product getProductDetails(WebElement element) {
        boolean isAddedToWishList = false;
        String title = "";
        String brandTitle = "";
        String price = "";
        try {
            WebElement svg = element.findElement(By.cssSelector("svg"));
            isAddedToWishList = Boolean.parseBoolean(svg.getAttribute("data-is-selected"));
        } catch (Exception ex) {
            LOG.error("wishlist icon is not visible");
        }

        try {
            WebElement productTitle = element.findElement(By.cssSelector("div[data-testid='product-title']"));
            title = productTitle.getText();
        } catch (Exception ex) {
            LOG.error("Product title element is not visible");
        }

        try {
            WebElement brandTitleElement = element.findElement(By.cssSelector("div[class^='ProductInfoBox__StyledBrandText']"));
            brandTitle = brandTitleElement.getText();
        } catch (Exception ex) {
            LOG.error("brand title element is not visible");
        }

        try {
            WebElement priceElement = element.findElement(By.cssSelector("span[data-testid='product-price']"));
            price = priceElement.getText();
        } catch (Exception ex) {
            LOG.error("Price element is not visible");
        }

        return new Product(title, brandTitle, price, isAddedToWishList);

    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> genericProductList.size() > 1);
    }
}
