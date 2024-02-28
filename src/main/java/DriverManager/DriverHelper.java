package DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;


public class DriverHelper {

    static DriverHelper driverHelper = new DriverHelper();

    public static DriverHelper getInstance() {

        return driverHelper;
    }

    private DriverHelper() {

    }

    private static WebDriver driver;

    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    Properties properties = new Properties();

    InputStream inputStream;


    private static final Logger LOGGER = LogManager.getLogger(DriverHelper.class);


    {

        inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private final String BROWSER = properties.getProperty("BrowserType");


    public WebDriver getDriver() {
        if (threadLocal.get() == null) {
            switch (BROWSER) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "chromedriver");
                    driver = new ChromeDriver(DriverOptions.chromeOptions());
                    threadLocal.set(driver);
                    LOGGER.info("creating chrome driver-------------->");
                    break;

                case "remote chrome":
                    String hubUrl = "http://localhost:4445/wd/hub";
                    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

                    desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, DriverOptions.chromeOptions());

                    try {
                        driver = new RemoteWebDriver(new URL(hubUrl), desiredCapabilities);
                        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                        threadLocal.set(driver);
                        LOGGER.info("creating remote chrome driver-------------->");

                        break;
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }

                case "remote firefox":

                    hubUrl = "http://localhost:4445/wd/hub";
                    desiredCapabilities = new DesiredCapabilities();

                    desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, DriverOptions.firefoxOptions());

                    try {
                        driver = new RemoteWebDriver(new URL(hubUrl), desiredCapabilities);
                        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                        threadLocal.set(driver);
                        LOGGER.info("creating remote firefox driver-------------->");

                        break;
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }

            }
        }
        return threadLocal.get();

    }

    public static synchronized void killDriver() {
        if (threadLocal.get() != null) {
            threadLocal.remove();
        }
        if (driver != null) {
            driver.quit();
        }
    }

}