package Helpers;

import DriverManager.DriverHelper;
import WaitManager.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ActionsHelper {
    private WebDriver driver = DriverHelper.getInstance().getDriver();
    private static final Logger LOGGER = LogManager.getLogger(DriverHelper.class);

    public static void clickOnElement(WebElement element) {
        WaitHelper.waitTillElementAppears(element);
        element.click();
        LOGGER.info("clicking on element -----> " + element);
    }

    public static void writeText(WebElement element, String text) {
        WaitHelper.waitTillElementAppears(element);
        element.sendKeys(text);
        LOGGER.info("writing " + text + " text on element -----> " + element);

    }

    public static boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static boolean areRightElementsDisplayed(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getText().toLowerCase().contains(text.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTextDisplayed(WebElement element, String text) {
        return element.getText().contains(text);
    }

    public void hoverOnElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static boolean containsAllWords(String firstString, String[] secondString) {

        for (String word : secondString) {
            if (!word.isEmpty() && !firstString.contains(word)) {
                return false;
            }
        }

        return true;
    }

    public static boolean containsEqualString(String firstString, List<String> secondString) {
        for (String word : secondString) {
            if (firstString.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);


    }
}


