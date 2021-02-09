package de.westwingnow.page.object.components.wishlist;

import de.westwingnow.exceptions.WishListProductIndexOutOfBound;
import de.westwingnow.page.object.common.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WishListContainerComponent extends AbstractComponent {

    private static final Logger LOG = LoggerFactory.getLogger(WishListContainerComponent.class);
    @FindBy(css = "li.blockListProduct")
    private List<WebElement> wishListProducts;

    @FindBy(css = "div.wishlistContainers")
    private WebElement wishListContainers;


    public WishListContainerComponent(WebDriver driver) {
        super(driver);
    }

    public void removeProduct(int index) throws WishListProductIndexOutOfBound {

        wait.until((d) -> wishListProducts.size() >= 1);
        int wishListSize = wishListProducts.size();

        if (wishListSize < index || index <= 0) {
            throw new WishListProductIndexOutOfBound("Cannot remove " + index + "th Element from " + wishListSize + " element wish List");
        }
        WebElement removeProduct = wishListProducts.get(index - 1);
        String removeProductSku = removeProduct.getAttribute("data-sku");
        removeProduct.findElement(By.tagName("button")).click();

        //wait until product is removed from wish list

        wait.until(
                ExpectedConditions.
                        invisibilityOfElementLocated(
                                By.xpath("//li[@class='blockListProduct qaBlockListProduct' and @data-sku='" + removeProductSku + "']")));

    }

    public boolean isProductPresentInWishList() {
        return false;
    }


    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> wishListContainers.isDisplayed());
    }
}
