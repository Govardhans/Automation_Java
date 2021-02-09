package de.westwingnow.page.object.components.login;

import de.westwingnow.page.object.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginOrRegisterComponent extends AbstractComponent {

    private static final Logger LOG = LoggerFactory.getLogger(LoginOrRegisterComponent.class);

    @FindBy(css = "div[data-testid='login_and_register']")
    WebElement overLayElement;

    @FindBy(css = "input[data-testid='long-register-email-field']")
    WebElement emailField;

    @FindBy(css = "input[data-testid='long-register-password-field']")
    WebElement passwordField;

    @FindBy(name = "isNewsletterSubscribed")
    WebElement newsLetterSubCheckBox;

    @FindBy(name = "isTermsAccepted")
    WebElement termsAcceptedCheckBox;

    @FindBy(css = "button[data-testid='login_reg_submit_btn']")
    WebElement submitBtn;

    @FindBy(css = "button[data-testid='login_reg_switch_btn']")
    WebElement loginOrRegisterToggleBtn;

    @FindBy(css = "div[class^='ForgotPasswordLink']")
    WebElement forgotPasswordLink;

    @FindBy(css = "span[class^='StyledFormError'] font font")
    WebElement loginErrorElement;


    public LoginOrRegisterComponent(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password) {
        wait.until((d) -> forgotPasswordLink.isDisplayed());
        LOG.info("Login screen is displayed");
        emailField.sendKeys(userName);
        passwordField.sendKeys(password);
        submitBtn.click();
    }

    public void switchToLoginForm() {
        if (isRegisterScreenDisplayed()) {
            loginOrRegisterToggleBtn.click();
        }
    }

    public void switchToRegisterForm() {
        if (!isRegisterScreenDisplayed()) {
            loginOrRegisterToggleBtn.click();
        }
    }

    //ToDo: registration is onetime process
    public void register() {

    }

    private boolean isRegisterScreenDisplayed() {
        return termsAcceptedCheckBox.isDisplayed() && submitBtn.isDisplayed();
    }

    public boolean isLoginSuccessful() {
        return !loginErrorElement.isDisplayed();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> overLayElement.isDisplayed());
    }
}
