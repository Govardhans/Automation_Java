package de.westwingnow.page.object.components.wishlist;

import de.westwingnow.page.object.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoodBoard extends AbstractComponent {

    @FindBy(css = ".qa-moodBoard__switchHeaderButton--wishlist")
    private WebElement wishList;

    @FindBy(css = ".qa-moodBoard__switchHeaderButton--moodBoard")
    private WebElement roomPlanner;

    public MoodBoard(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> wishList.isDisplayed());
    }
}
