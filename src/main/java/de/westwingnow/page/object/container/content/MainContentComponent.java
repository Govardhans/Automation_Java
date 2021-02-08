package de.westwingnow.page.object.container.content;

import de.westwingnow.page.object.container.content.main.CrossCategoryNavBar;
import de.westwingnow.page.object.container.content.main.FilterAndSortComponent;
import de.westwingnow.page.object.container.content.main.ProductComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainContentComponent {
    //header

    private CrossCategoryNavBar crossCategoryNavBar;
    private FilterAndSortComponent filterAndSortComponent;
    private ProductComponent productComponent;

    public MainContentComponent(final WebDriver driver) {
        crossCategoryNavBar = PageFactory.initElements(driver, CrossCategoryNavBar.class);
        filterAndSortComponent = PageFactory.initElements(driver, FilterAndSortComponent.class);
        productComponent = PageFactory.initElements(driver, ProductComponent.class);
    }

    public CrossCategoryNavBar getCrossCategoryNavBar() {
        return crossCategoryNavBar;
    }

    public FilterAndSortComponent getFilterAndSortComponent() {
        return filterAndSortComponent;
    }

    public ProductComponent getProductComponent() {
        return productComponent;
    }
}
