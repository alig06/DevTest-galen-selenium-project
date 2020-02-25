package Webdriver;

import org.openqa.selenium.WebDriver;

public abstract class DriverExecuter extends ChromeDriverManager
{
    protected static WebDriver driver;

    public DriverExecuter()
    {
        getWebDriver();
    }


    public WebDriver getWebDriver()
    {
        if (driver == null)
        {
            createDriver();
        }
        return driver;
    }

    public static WebDriver getDriver()
    {
        return driver;
    }
}

