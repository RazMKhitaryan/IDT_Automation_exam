package Pages;

import ActionsHelper.Actions;
import WaitManager.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {
    @FindBy(css = "[class=\"title text-center\"]")
    WebElement searchedProductsText;

    @FindBy(css = "[class=\"col-sm-4\"]")
    List<WebElement> searchedProductsList;

    @Override
    protected void isLoaded() throws Error {
        if (!WaitHelper.waitTillElementVisible(searchedProductsText)) {
            throw new Error("Search page was not opened");
        }
    }

    @Override
    public SearchPage init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    public SearchPage openScreen() {
        return null;
    }

    @Override
    public String getUrl() {
        return null;
    }

    public boolean areSearchedElementsDisplayedRight(String text) {
        return Actions.areRightElementsDisplayed(searchedProductsList, text);

    }

    public String getSearchedProductsText() {
        return searchedProductsText.getText();
    }

}
