package Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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

