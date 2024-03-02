package Pages;

import Helpers.ActionsHelper;
import Pages.Base.BasePage;
import WaitManager.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static Helpers.ActionsHelper.*;

public class HomePage extends BasePage {

    @FindBy(css = "[class=\"carousel-indicators\"]")
    WebElement carouselIndicator;

    @FindBy(css = "[class=\"product-overlay\"]")
    List<WebElement> products;

    @FindBy(css = "[class=\"features_items\"]")
    WebElement featuresItems;

    @FindBy(css = "[class=\"btn btn-default add-to-cart\"]")
    List<WebElement> addToCardButtons;

    @FindBy(css = "[class=\"btn btn-success close-modal btn-block\"]")
    WebElement continueShoppingButton;

    @FindBy(css = "[class=\"productinfo text-center\"]")
    List<WebElement> productsInfo;

    @FindBy(css = "[class=\"fa fa-angle-up\"]")
    WebElement arrowUpButton;

    @FindBy(css = "[class=\"carousel-inner\"] h2")
    List<WebElement> carouselTextList;

    @Override
    protected void isLoaded() {
            if (!ActionsHelper.isElementDisplayed(carouselIndicator) || !ActionsHelper.isElementDisplayed(featuresItems)) {
                throw new Error("Home page was not opened");
        }
    }

    @Override
    public HomePage init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    public String getUrl() {
        return null;
    }


    @Override
    public HomePage openScreen() {
        driver.get(BASE_URL+get());
        return this;
    }

    public boolean isHomePageVisible() {
        return isElementDisplayed(carouselIndicator);
    }

    public HomePage hoverOnProduct(int index) {
        new ActionsHelper().hoverOnElement(products.get(index));
        return this;
    }

    public HomePage clickOnAddToCardButton(int index) {
        hoverOnProduct(1);
        clickOnElement(addToCardButtons.get(index));
        return this.init();
    }

    public HomePage clickContinueShoppingButton() {
        clickOnElement(continueShoppingButton);
        return this;
    }

    public String[] getProductInfo(int index) {
        String productInfo = productsInfo.get(index).getText();

        // Remove "Item" and "Add to cart" from the string
        productInfo = productInfo.replace("Item", "").replace("Add to cart", "").trim();

        // Split the modified string into an array
        String[] productInfoArray = productInfo.split("\\s+");

        return productInfoArray;
    }


    public HomePage clickArrowUp() {
        ActionsHelper.clickOnElement(arrowUpButton);
        return this;
    }

    public List<String> getCarouselText() {
        List<String> textList = new ArrayList<>();

        for (WebElement element : carouselTextList) {
            textList.add(element.getText());
        }
        return textList;
    }

    public boolean isCarouselTextVisible(String text){
        return  ActionsHelper.containsEqualString(text,getCarouselText());
    }
}
