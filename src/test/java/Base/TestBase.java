package Base;

import DriverManager.DriverHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static DriverManager.DriverHelper.killDriver;

public class TestBase {
    private static final Logger LOGGER = LogManager.getLogger(DriverHelper.class);

    private WebDriver driver = DriverHelper.getInstance().getDriver();

    Properties properties = new Properties();

    InputStream inputStream;


    {

        inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private final String BASE_URL = properties.getProperty("BaseUrl");


    @BeforeMethod
    public void startDriver() {
        driver.get(BASE_URL);
        LOGGER.info("Opening the url ----> " + BASE_URL);
        driver.manage().window().setSize(new Dimension(1900, 1200));
    }


    @AfterMethod
    protected void tearDown() {
        killDriver();
    }
}

