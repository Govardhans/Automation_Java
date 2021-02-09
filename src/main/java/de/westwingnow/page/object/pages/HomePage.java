package de.westwingnow.page.object.pages;

import com.codeborne.selenide.Selenide;
import de.westwingnow.page.object.container.ContainerComponent;
import de.westwingnow.page.object.components.header.Header;
import de.westwingnow.page.object.components.login.LoginOrRegisterComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage {
    private static Logger LOG = LoggerFactory.getLogger(HomePage.class);
    private static final long TIMEOUT_IN_SECONDS = 30;
    private Header header;
    private LoginOrRegisterComponent loginOrRegisterComponent;
    private ContainerComponent containerComponent;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookies;
    private WebDriverWait wait;

    private static final String TITLE = "Ihr Möbel & Interior Online-Shop | WestwingNow";


    public HomePage(final WebDriver driver) {
        this.header = PageFactory.initElements(driver, Header.class);
        this.loginOrRegisterComponent = PageFactory.initElements(driver, LoginOrRegisterComponent.class);
        this.containerComponent = new ContainerComponent(driver);

        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public Header getHeader() {
        return header;
    }

    public LoginOrRegisterComponent getLoginOrRegisterComponent() {
        return loginOrRegisterComponent;
    }

    public ContainerComponent getContainerComponent() {
        return containerComponent;
    }

    public boolean isDisplayed() {
        return Selenide.title().equalsIgnoreCase(TITLE);
    }

    public void acceptCookiesPolicy() {
        try {
            wait.until((d) -> acceptCookies.isDisplayed());
            acceptCookies.click();
        } catch (Exception ex) {
            LOG.info("Cookies notification didn't pop-up");
        }

    }
}
