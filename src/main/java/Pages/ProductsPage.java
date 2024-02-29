package Pages;

import WaitManager.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static ActionsHelper.Actions.clickOnElement;
import static ActionsHelper.Actions.writeText;
import static Utils.RandomTextUtils.generateRandomNumber;

public class ProductsPage extends BasePage {
    @FindBy(css = "[class=\"title text-center\"]")
    WebElement allProductsText;

    @FindBy(css = "[class=\"fa fa-search\"]")
    WebElement searchButton;

    @FindBy(id = "search_product")
    WebElement searchInput;

    @Override
    protected void isLoaded() throws Error {
        if (!WaitHelper.waitTillElementVisible(searchButton) || !WaitHelper.waitTillElementVisible(allProductsText)) {
            throw new Error("Products page was not opened");
        }
    }

    @Override
    public String getUrl() {
        return "/products";
    }

    @Override
    public ProductsPage init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    public ProductsPage openScreen() {
        return null;
    }

    public String getAllProductsText() {
        return allProductsText.getText();
    }

    public SearchPage clickSearchButton(){
        clickOnElement(searchButton);
        return new SearchPage().init();
    }

    public ProductsPage searchProduct(String text) {
        writeText(searchInput,text);
        return this;
    }
}
