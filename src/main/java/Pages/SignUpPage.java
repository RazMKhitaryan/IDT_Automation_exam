package Pages;

import WaitManager.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignUpPage extends BasePage {

    @FindBy(css = "[class=\"title text-center\"]")
    List<WebElement> accountInformationText;

    @FindBy(id = "[id=\"id_gender1\"]")
    WebElement mrGender;

    @FindBy(id = "[id=\"id_gender2\"]")
    WebElement msGender;

    @Override
    protected void isLoaded()  {
        if (!WaitHelper.waitTillElementVisible(mrGender) || !WaitHelper.waitTillElementVisible(msGender)) {
            throw new Error("Login and SignUp page is not fully loaded.");
        }
    }

    @Override
    public String getUrl() {
        return "/signup";
    }

    @Override
    public SignUpPage init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    public SignUpPage openScreen() {
        driver.get(BASE_URL + getUrl());
        return init();
    }

    public String getAccountInformationText() {
        return accountInformationText.get(0).getText();
    }

}
