package Pages;

import Pages.Base.BasePage;
import WaitManager.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Helpers.ActionsHelper.clickOnElement;

public class DeleteAccountPage extends BasePage {

    @FindBy(css = "[data-qa=\"account-deleted\"]")
    WebElement accountDeleted;

    @FindBy(css = "[data-qa=\"continue-button\"]")
    WebElement continueButton;


    @Override
    protected void isLoaded() throws Error {
        if (!WaitHelper.waitTillElementVisible(accountDeleted)) {
            throw new Error("Delete account page was not loaded");
        }
    }

    @Override
    public String getUrl() {
        return "/delete_account";
    }

    @Override
    public DeleteAccountPage init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    public DeleteAccountPage openScreen() {
        driver.get(BASE_URL + get());
        return this;
    }

    public String getAccountDeletedText() {
        return accountDeleted.getText();
    }

    public void clickContinueButton() {
        clickOnElement(continueButton);
    }

}
