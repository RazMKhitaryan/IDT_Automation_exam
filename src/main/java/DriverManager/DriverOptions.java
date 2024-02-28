package DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class DriverOptions {

    public static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        options.addArguments("--disable-web-security", "--no-sandbox", "--disable-dev-shm-usage");
      //  options.addArguments("--headless");
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return options;
    }

    public static FirefoxOptions firefoxOptions(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--disable-web-security", "--no-sandbox", "--disable-dev-shm-usage");
        firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return firefoxOptions;
    }
}
