package Pages;

import WaitManager.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static ActionsHelper.Actions.*;


public class LoginAndSignUpPage extends BasePage {

    @FindBy(css = "[data-qa=\"login-button\"]")
    WebElement loginButton;

    @FindBy(css = "[data-qa=\"signup-button\"]")
    WebElement signUpButton;

    @FindBy(css = "[class=\"signup-form\"]")
    private WebElement signUpForm;

    @FindBy(css = "[data-qa=\"signup-name\"]")
    private WebElement name;

    @FindBy(css = "[data-qa=\"signup-email\"]")
    private WebElement email;

    @Override
    protected void isLoaded() throws Error {
        if (!WaitHelper.waitTillElementVisible(loginButton) || !WaitHelper.waitTillElementVisible(signUpButton)) {
            throw new Error("Login and SignUp page is not fully loaded.");
        }
    }

    @Override
    public String getUrl() {
        return "/login";
    }

    @Override
    public LoginAndSignUpPage init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    public LoginAndSignUpPage openScreen() {
        return null;
    }

    public LoginAndSignUpPage writeName(String text) {
        writeText(name, text);
        return this;
    }

    public LoginAndSignUpPage writeEmail(String text) {
        writeText(email, text);
        return this;
    }

    public SignUpPage clickSignUpButton() {
        clickOnElement(signUpButton);
        return new SignUpPage().init();
    }

    public String getSignUpText() {
        return signUpForm.getText();
    }
}
