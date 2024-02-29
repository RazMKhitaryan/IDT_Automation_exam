package Components;

import ActionsHelper.Actions;
import Pages.DeleteAccountPage;
import Pages.ProductsPage;
import WaitManager.WaitHelper;
import Pages.LoginAndSignUpPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        Actions.clickOnElement(signUpLoginButton);
        return new LoginAndSignUpPage().init();
    }

    public String getNavBarText() {
        return topNavigationBar.getText();
    }

    public DeleteAccountPage clickDeleteAccount() {
        Actions.clickOnElement(deleteAccount);
        return new DeleteAccountPage().init();
    }

    public ProductsPage clickOnProducts() {
        Actions.clickOnElement(products);
        return new ProductsPage().init();
    }
    public void clickOnLogout() {
        Actions.clickOnElement(logout);
    }
}
