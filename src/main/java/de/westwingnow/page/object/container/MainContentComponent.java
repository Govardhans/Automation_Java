package de.westwingnow.page.object.container;

import de.westwingnow.page.object.components.CrossCategoryNavBar;
import de.westwingnow.page.object.components.FilterAndSortComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainContentComponent {
    //header

    private CrossCategoryNavBar crossCategoryNavBar;
    private FilterAndSortComponent filterAndSortComponent;
    private ProductContainerComponent productContainerComponent;

    public MainContentComponent(final WebDriver driver) {
        crossCategoryNavBar = PageFactory.initElements(driver, CrossCategoryNavBar.class);
        filterAndSortComponent = PageFactory.initElements(driver, FilterAndSortComponent.class);
        productContainerComponent = PageFactory.initElements(driver, ProductContainerComponent.class);
    }

    public CrossCategoryNavBar getCrossCategoryNavBar() {
        return crossCategoryNavBar;
    }

    public FilterAndSortComponent getFilterAndSortComponent() {
        return filterAndSortComponent;
    }

    public ProductContainerComponent getProductComponent() {
        return productContainerComponent;
    }
}
