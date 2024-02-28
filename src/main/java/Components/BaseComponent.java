package Components;

import DriverManager.DriverHelper;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.SlowLoadableComponent;

import java.time.Clock;
import java.time.Duration;

public abstract class BaseComponent<T extends BaseComponent> extends LoadableComponent {

    protected WebDriver driver = DriverHelper.getInstance().getDriver();

    @Override
    protected void load() {

    }

    public abstract T init();




}
