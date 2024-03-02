package Components;

import Helpers.ActionsHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Helpers.ActionsHelper.*;

public class FooterComponent extends BaseComponent {

    @FindBy(css = "[class='single-widget'] h2")
    WebElement subscriptionText;


    @Override
    public FooterComponent init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    protected void isLoaded() throws Error {
        if (!isElementDisplayed(subscriptionText)) {
            throw new Error("Footer is not loaded");
        }
    }

    public String getSubscriptionText() {
        return subscriptionText.getText();
    }

    public FooterComponent scrollToFooter() {
        new ActionsHelper().scrollToElement(subscriptionText);
        return this;
    }
}
