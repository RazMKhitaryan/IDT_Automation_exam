package Pages;

import Pages.Base.BasePage;
import Utils.RandomTextUtils;
import WaitManager.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static ActionsHelper.MyActions.*;


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

    @FindBy(css = "[data-qa=\"login-email\"]")
    WebElement loginEmail;


    @FindBy(css = "[data-qa=\"login-password\"]")
    WebElement loginPassword;

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

    public String writeRandomName() {
        String nameRandom = RandomTextUtils.generateRandomText();
        writeText(name, nameRandom);
        return nameRandom;
    }

    public String writeRandomEmail() {
        String emailText = RandomTextUtils.generateRandomText() + "@gmail.com";
        writeText(email, emailText);
        return emailText;
    }

    public SignUpPage clickSignUpButton() {
        clickOnElement(signUpButton);
        return new SignUpPage().init();
    }

    public LoginAndSignUpPage writeEmail(String email) {
        writeText(loginEmail, email);
        return this;
    }

    public LoginAndSignUpPage writePassword(String password) {
        writeText(loginPassword, password);
        return this;
    }

    public void clickLoginButton() {
        clickOnElement(loginButton);
    }

    public String getSignUpText() {
        return signUpForm.getText();
    }
}
