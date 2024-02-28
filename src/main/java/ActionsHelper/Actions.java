package ActionsHelper;

import DriverManager.DriverHelper;
import WaitManager.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class Actions {
    private static final Logger LOGGER = LogManager.getLogger(DriverHelper.class);

    public static void clickOnElement(WebElement element) {
        WaitHelper.waitTillElementAppears(element);
        element.click();
        LOGGER.info("clicking on element -----> " + element);
    }

    public static void writeText(WebElement element, String text) {
        WaitHelper.waitTillElementAppears(element);
        element.sendKeys(text);
        LOGGER.info("writing "+ text +" text on element -----> " + element);

    }

    public static boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static boolean isTextDisplayed(WebElement element,String text) {
        return element.getText().contains(text);
    }
}
