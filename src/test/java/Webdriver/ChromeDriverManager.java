package Webdriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager
{

    public WebDriver createDriver()
    {
        ChromeOptions chromeOptions = chromeOptions();

        DesiredCapabilities desiredCapabilities = desiredCapabilities(chromeOptions);
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
        WebDriver driver = new ChromeDriver(desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(90, TimeUnit.SECONDS);
        return driver;
    }

    private DesiredCapabilities desiredCapabilities(ChromeOptions chromeOptions)
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return capabilities;
    }

    private ChromeOptions chromeOptions()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--window-size=1400,800");
        Map<String, Object> prefs = new HashMap<String, Object>();
        chromeOptions.setExperimentalOption("prefs", prefs);

        return chromeOptions;
    }
}
