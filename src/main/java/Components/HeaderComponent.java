package Components;

import ActionsHelper.Actions;
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

    @Override
    protected void isLoaded() throws Error {
        WaitHelper.waitTillElementAppears(topNavigationBar);
    }

    @Override
    public HeaderComponent init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    public LoginAndSignUpPage clickOnSignUpLogin(){
        Actions.clickOnElement(signUpLoginButton);
        return new LoginAndSignUpPage().init();
    }
}
