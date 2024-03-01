package Components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductComponent extends BaseComponent {
    @FindBy(css = "[class=\"cart_description\"]")
    WebElement description;

    @FindBy(css = "[class=\"cart_price\"]")
    WebElement price;

    @FindBy(css = "[class=\"disabled\"]")
    WebElement quantity;


    @Override
    public ProductComponent init() {
        PageFactory.initElements(driver, this);
        return this;
    }


    @Override
    protected void isLoaded() throws Error {

    }

    public String getAllProductInfo() {
        return description.getText() + "," + price.getText() + "," + quantity.getText();
    }

}
