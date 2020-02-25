package utils;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import Webdriver.DriverExecuter;

public class TwitterHelper extends DriverExecuter
{

    @Test
    public void test(){
        driver.get(UrlHelper.BASE_URL.pageUrl);
    }

    @AfterAll
    static void after()
    {
        driver.quit();
        driver = null;
    }
}
