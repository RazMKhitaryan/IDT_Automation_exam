package Pages;

import Pages.Base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Helpers.ActionsHelper.areRightElementsDisplayed;
import static Helpers.ActionsHelper.isElementDisplayed;

public class SearchPage extends BasePage {
    @FindBy(css = "[class=\"title text-center\"]")
    WebElement searchedProductsText;

    @FindBy(css = "[class=\"col-sm-4\"]")
    List<WebElement> searchedProductsList;

    @Override
    protected void isLoaded() throws Error {
            if (!isElementDisplayed(searchedProductsText)) {
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
        driver.get(BASE_URL + getUrl());
        return this;
    }

    @Override
    public String getUrl() {
        return null;
    }

    public boolean areSearchedElementsDisplayedRight(String text) {
        return areRightElementsDisplayed(searchedProductsList, text);

    }

    public String getSearchedProductsText() {
        return searchedProductsText.getText();
    }

}
