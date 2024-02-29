package WaitManager;

import DriverManager.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitHelper extends WebDriverWait {
    public WaitHelper(WebDriver driver, Duration timeout) {
        super(driver, timeout);
    }

    private static WaitHelper waitHelper = new WaitHelper(DriverHelper.getInstance().getDriver(), Duration.ofSeconds(20));

    public static void waitTillElementAppears(WebElement element) {
        waitHelper.until(ExpectedConditions.visibilityOfAllElements(element));

    }

    public static void waitTillElementsAppears(List<WebElement> elements) {
        waitHelper.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static boolean waitTillElementVisible(WebElement element) {
        return waitHelper.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

    }

}
