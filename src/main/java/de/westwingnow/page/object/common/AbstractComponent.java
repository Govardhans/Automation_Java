package de.westwingnow.page.object.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public AbstractComponent(final WebDriver driver) {
        this.wait = new WebDriverWait(driver, 30);
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isDisplayed();
}
