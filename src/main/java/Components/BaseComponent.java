package Components;

import DriverManager.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class BaseComponent<T extends BaseComponent> extends LoadableComponent {

    protected WebDriver driver = DriverHelper.getInstance().getDriver();

    @Override
    protected void load() {

    }

    public abstract T init();


}
