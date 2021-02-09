package de.westwingnow.page.object.container;

import de.westwingnow.page.object.components.BreadCrumbsComponent;
import de.westwingnow.page.object.components.SideBarComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *
 */
public class ContainerComponent {

    private SideBarComponent sideBarComponent;
    private BreadCrumbsComponent breadCrumbsComponent;
    private MainContentComponent mainContentComponent;

    public ContainerComponent(final WebDriver driver) {
        sideBarComponent = PageFactory.initElements(driver, SideBarComponent.class);
        breadCrumbsComponent = PageFactory.initElements(driver, BreadCrumbsComponent.class);
        mainContentComponent = new MainContentComponent(driver);
    }

    public SideBarComponent getSideBarComponent() {
        return sideBarComponent;
    }

    public BreadCrumbsComponent getBreadCrumbsComponent() {
        return breadCrumbsComponent;
    }

    public MainContentComponent getMainContentComponent() {
        return mainContentComponent;
    }
}
