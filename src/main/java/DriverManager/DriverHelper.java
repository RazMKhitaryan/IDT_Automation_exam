package DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverHelper {

    private static final Logger LOGGER = LogManager.getLogger(DriverHelper.class);

    private static final DriverHelper driverHelper = new DriverHelper();

    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    private static final Properties properties = new Properties();

    private static final String BROWSER;
    private static final String BASE_URL;
    private static final String HUB_URL;


    static {
        try (InputStream inputStream = DriverHelper.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BROWSER = properties.getProperty("BrowserType");
        BASE_URL = properties.getProperty("BaseUrl");
        HUB_URL = properties.getProperty("HubUrl");
    }

    private DriverHelper() {

    }

    public static DriverHelper getInstance() {
        return driverHelper;
    }

    public WebDriver getDriver() {
        if (threadLocal.get() == null) {
            switch (BROWSER) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "chromedriver");
                    WebDriver chromeDriver = new ChromeDriver(DriverOptions.chromeOptions());
                    threadLocal.set(chromeDriver);
                    LOGGER.info("Creating chrome driver -------------->");
                    break;

                case "firefox":
                    System.setProperty("webdriver.chrome.driver", "chromedriver");
                    WebDriver firefoxDriver = new FirefoxDriver(DriverOptions.firefoxOptions());
                    threadLocal.set(firefoxDriver);
                    LOGGER.info("Creating firefox driver -------------->");
                    break;

                case "remote chrome":
                    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                    desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, DriverOptions.chromeOptions());

                    try {
                        WebDriver remoteChromeDriver = new RemoteWebDriver(new URL(HUB_URL), desiredCapabilities);
                        threadLocal.set(remoteChromeDriver);
                        LOGGER.info("Creating remote chrome driver -------------->");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "remote firefox":
                    desiredCapabilities = new DesiredCapabilities();
                    desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, DriverOptions.firefoxOptions());

                    try {
                        WebDriver remoteFirefoxDriver = new RemoteWebDriver(new URL(HUB_URL), desiredCapabilities);
                        threadLocal.set(remoteFirefoxDriver);
                        LOGGER.info("Creating remote firefox driver -------------->");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                default:
                    throw new Error("Write chrome, firefox, remote chrome , remote firefox");
            }
        }
        return threadLocal.get();
    }

    public static void setup() {
        WebDriver driver = getInstance().getDriver();
        driver.get(BASE_URL);
        LOGGER.info("Opening the URL ----> " + BASE_URL);
        driver.manage().window().setSize(new Dimension(1900, 1200));
    }

    public static void killDriver() {
        WebDriver driverInstance = threadLocal.get();
        if (driverInstance != null) {
            driverInstance.quit();
            LOGGER.info("Quitting the WebDriver -------------->");
            threadLocal.remove();
        }
    }
}