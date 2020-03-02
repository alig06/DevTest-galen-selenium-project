package Webdriver;

import org.openqa.selenium.WebDriver;

public abstract class DriverExecutor extends ChromeDriverManager
{
    protected WebDriver driver;

    public DriverExecutor(){
        getDriver();
    }
    public WebDriver getWebDriver()
    {
        if (driver == null)
        {
            driver = createDriver();
        }
        return driver;
    }

    public WebDriver getDriver()
    {
        return getWebDriver();
    }
}

