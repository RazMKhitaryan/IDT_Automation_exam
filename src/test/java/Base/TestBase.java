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
import static DriverManager.DriverHelper.setup;

public class TestBase {

    @BeforeMethod
    public void startDriver() {
        setup();
    }


    @AfterMethod
    protected synchronized void tearDown() {
        killDriver();
    }
}

