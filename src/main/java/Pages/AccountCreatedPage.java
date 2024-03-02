package Pages;

import Helpers.ActionsHelper;
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
        if (!ActionsHelper.isElementDisplayed(accountCreated) || !ActionsHelper.isElementDisplayed(continueButton)) {
            throw new Error("Account Created page was not opened");
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
        driver.get(BASE_URL+getUrl());
        return this;
    }

    public void clickContinueButton() {
        clickOnElement(continueButton);
    }


    public String getAccountCreatedText() {
        return accountCreated.getText();
    }

}
