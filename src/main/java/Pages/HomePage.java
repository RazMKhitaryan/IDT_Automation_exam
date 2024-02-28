package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static WaitManager.WaitHelper.waitTillElementAppears;

public class HomePage extends BasePage {

    @FindBy(css = "[class=\"carousel-indicators\"]")
    WebElement carouselIndicator;


    @FindBy(css = "[class=\"features_items\"]")
    WebElement featuresItems;

    @Override
    protected void isLoaded() {
        waitTillElementAppears(carouselIndicator);
        waitTillElementAppears(featuresItems);
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
        return null;
    }


}
