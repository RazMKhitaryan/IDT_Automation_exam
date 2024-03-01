package Pages;

import Pages.Base.BasePage;
import WaitManager.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends BasePage {
    @FindBy(css = "[class=\"btn btn-default check_out\"]")
    WebElement placeOrder;

    @FindBy(css = "[class=\"address_firstname address_lastname\"]")
    List<WebElement> firstnameLastname;

    @FindBy(css = "[class=\"address_address1 address_address2\"]")
    List<WebElement> companyAddressAddress2;

    @FindBy(css = "[class=\"address_city address_state_name address_postcode\"]")
    List<WebElement> cityStateZipcode;

    @FindBy(css = "[class=\"address_country_name\"]")
    List<WebElement> country;

    @FindBy(css = "[class=\"address_phone\"]")
    List<WebElement> phone;

    @FindBy(id = "address_delivery")
    WebElement addressDelivery;

    @FindBy(id = "cart_info")
    WebElement cardInfo;


    @Override
    public String getUrl() {
        return "/checkout";
    }

    @Override
    public CheckoutPage init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    public CheckoutPage openScreen() {
        return null;
    }

    @Override
    protected void isLoaded() throws Error {
        if (!WaitHelper.waitTillElementVisible(placeOrder)) {
            throw new Error("Login and SignUp page is not fully loaded.");
        }
    }

    public String extractProductDetails() {
        List<WebElement> productRows = cardInfo.findElements(By.tagName("tr"));
        List<String> productDetailsList = new ArrayList<>();

        // Iterate over each table row and extract the text
        for (WebElement productRow : productRows) {
            productDetailsList.add(productRow.getText());
        }

        // Join the list items into a single string, removing unnecessary characters
        String productDetailsText = String.join(" ", productDetailsList)
                .replace("[", "")
                .replace("]", "")
                .replace(".", "")
                .replace(",", "")
                .replace(">", "")
                .replace("Rs", "Rs.")
                .replace("Item", "")
                .replace("Add to cart", "")
                .trim();

        return productDetailsText;
    }

    public String[] getAddressDeliveryTextAsString() {
        List<WebElement> addressItems = addressDelivery.findElements(By.tagName("li"));
        List<String> addressDeliveryTextList = new ArrayList<>();
        for (WebElement addressItem : addressItems) {
            String text = addressItem.getText().trim();
            if (!text.equalsIgnoreCase("YOUR DELIVERY ADDRESS")) {
                addressDeliveryTextList.add(text);
            }
        }

        // Convert the list to a string and apply the modifications
        String addressDeliveryText = addressDeliveryTextList.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(".", "")
                .replace(", ", ",");

        // Split the modified string into an array
        String[] wordsToCheck = addressDeliveryText.split("\\s+|(?<=,)|(?=,)");

        // Return the modified string
        return wordsToCheck;
    }
}


