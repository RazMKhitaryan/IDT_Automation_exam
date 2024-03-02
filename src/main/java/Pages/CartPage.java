package Pages;

import Helpers.ActionsHelper;
import Pages.Base.BasePage;
import WaitManager.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Helpers.ActionsHelper.*;

public class CartPage extends BasePage {

    @FindBy(css = "[class=\"btn btn-default check_out\"]")
    WebElement proceedToCheckoutButton;

    @Override
    protected void isLoaded() {
        if (!ActionsHelper.isElementDisplayed(proceedToCheckoutButton)) {
            throw new Error("Create page was not opened");
        }
    }

    @Override
    public String getUrl() {
        return "/view_cart";
    }

    @Override
    public CartPage init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    public CartPage openScreen() {
        driver.get(BASE_URL + getUrl());
        return this;
    }

    public boolean isCartPageOpened() {
        return isElementDisplayed(proceedToCheckoutButton);
    }

    public CheckoutPage clockOnProceedToCheckout() {
        clickOnElement(proceedToCheckoutButton);
        return new CheckoutPage().init();
    }


}
