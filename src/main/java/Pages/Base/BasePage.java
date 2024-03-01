package Pages.Base;

import DriverManager.DriverHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class BasePage<T extends BasePage> extends LoadableComponent {
    protected static final Logger LOGGER = LogManager.getLogger(DriverHelper.class);

    protected WebDriver driver = DriverHelper.getInstance().getDriver();
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

    protected final String BASE_URL = properties.getProperty("BaseUrl");


    @Override
    protected void load() {

    }

    public abstract String getUrl();


    public abstract T init();

    public abstract T openScreen();

}
