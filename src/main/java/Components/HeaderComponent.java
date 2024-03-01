package Components;

import Pages.CartPage;
import Pages.DeleteAccountPage;
import Pages.ProductsPage;
import WaitManager.WaitHelper;
import Pages.LoginAndSignUpPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Helpers.ActionsHelper.*;

public class HeaderComponent extends BaseComponent {

    @FindBy(css = "[class=\"nav navbar-nav\"]")
    WebElement topNavigationBar;

    @FindBy(css = "[class=\"fa fa-home\"]")
    WebElement homeButton;

    @FindBy(css = "[class=\"fa fa-lock\"]")
    WebElement signUpLoginButton;

    @FindBy(css = "[class=\"fa fa-trash-o\"]")
    WebElement deleteAccount;

    @FindBy(css = "[class=\"material-icons card_travel\"]")
    WebElement products;

    @FindBy(css = "[class=\"fa fa-lock\"]")
    WebElement logout;

    @FindBy(css = "[class=\"fa fa-shopping-cart\"]")
    WebElement cartButton;

    @Override
    protected void isLoaded() throws Error {
        WaitHelper.waitTillElementAppears(topNavigationBar);
    }

    @Override
    public HeaderComponent init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    public LoginAndSignUpPage clickOnSignUpLogin() {
        clickOnElement(signUpLoginButton);
        return new LoginAndSignUpPage().init();
    }

    public String getNavBarText() {
        return topNavigationBar.getText();
    }

    public DeleteAccountPage clickDeleteAccount() {
        clickOnElement(deleteAccount);
        return new DeleteAccountPage().init();
    }

    public ProductsPage clickOnProducts() {
        clickOnElement(products);
        return new ProductsPage().init();
    }

    public void clickOnLogout() {
        clickOnElement(logout);
    }

    public CartPage clickOnCartButton() {
        clickOnElement(cartButton);
        return new CartPage().init();
    }

}
