package Pages;

import Pages.Base.BasePage;
import WaitManager.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Helpers.ActionsHelper.clickOnElement;

public class AccountCreatedPage extends BasePage {

    @FindBy(css = "[data-qa=\"account-created\"]")
    WebElement accountCreated;

    @FindBy(css = "[data-qa=\"continue-button\"]")
    WebElement continueButton;

    @Override
    protected void isLoaded() throws Error {
        if (!WaitHelper.waitTillElementVisible(accountCreated) || !WaitHelper.waitTillElementVisible(continueButton)) {
            throw new Error("account was not created");
        }
    }

    @Override
    public String getUrl() {
        return "/account_created";
    }

    @Override
    public AccountCreatedPage init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    public AccountCreatedPage openScreen() {
        return null;
    }

    public void clickContinueButton() {
        clickOnElement(continueButton);
    }


    public String getAccountCreatedText() {
        return accountCreated.getText();
    }

}
