package Pages;

import ActionsHelper.MyActions;
import Pages.Base.BasePage;
import Utils.RandomTextUtils;
import WaitManager.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static ActionsHelper.MyActions.*;

public class PaymentPage extends BasePage {

    @FindBy(css = "[data-qa='name-on-card']")
    private WebElement nameOnCard;

    @FindBy(css = "[data-qa='card-number']")
    private WebElement cardNumber;

    @FindBy(css = "[data-qa='cvc']")
    private WebElement cvc;

    @FindBy(css = "[data-qa='expiry-month']")
    private WebElement expiryMonth;

    @FindBy(css = "[data-qa='expiry-year']")
    private WebElement expiryYear;

    @FindBy(css = "[data-qa='pay-button']")
    private WebElement payButton;

    @FindBy(css = "div[class='col-sm-9 col-sm-offset-1'] p")
    WebElement paymentSuccess;

    @Override
    protected void isLoaded() throws Error {
        if (!WaitHelper.waitTillElementVisible(payButton) || !WaitHelper.waitTillElementVisible(cardNumber)) {
            throw new Error("payment page is not fully loaded.");
        }
    }

    @Override
    public String getUrl() {
        return "/payment";
    }

    @Override
    public PaymentPage init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    public PaymentPage openScreen() {
        return null;
    }

    public PaymentPage writeNameOnCard() {
        writeText(nameOnCard, RandomTextUtils.generateRandomText());
        return this;
    }

    public PaymentPage writeCardNumber() {
        writeText(cardNumber, String.valueOf(RandomTextUtils.generateRandomNumber(1000000, 1000020)));
        return this;
    }

    public PaymentPage writeCVC() {
        writeText(cvc, String.valueOf(RandomTextUtils.generateRandomNumber(100, 110)));
        return this;
    }

    public PaymentPage selectExpiryMonth() {
        writeText(expiryMonth, String.valueOf(RandomTextUtils.generateRandomNumber(1, 12)));
        return this;
    }

    public PaymentPage selectExpiryYear() {
        writeText(expiryYear, String.valueOf(RandomTextUtils.generateRandomNumber(1996, 2024)));
        return this;
    }

    public PaymentPage clickPayButton() {
        clickOnElement(payButton);
       return this.init();
    }


    public WebElement getPaymentMessage() {
        return paymentSuccess;
    }
}
