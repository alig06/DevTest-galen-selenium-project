package utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.galenframework.api.Galen;
import com.galenframework.browser.Browser;
import com.galenframework.config.GalenConfig;
import com.galenframework.config.GalenProperty;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;

import Webdriver.DriverExecutor;

public class LayoutDesignHelper extends DriverExecutor
{

    private String specFile;
    private static final String SPEC_PATH = "specs/";

    public void checkLayoutDesign(Browser browser, String specFile, List<String> includedTags){
        GalenConfig.getConfig().setProperty(GalenProperty.SCREENSHOT_FULLPAGE,"true");

        specFile = SPEC_PATH + specFile;

        reportCreator(includedTags);
    }

    public void reportCreator(List<String> includedTags){

        LayoutReport layoutReport = null;
        try
        {
            layoutReport = Galen.checkLayout(getDriver(), specFile, includedTags);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // Creating a list of tests
        List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

        // Creating an object that will contain the information about the test
        GalenTestInfo test = GalenTestInfo.fromString("Login page on mobile device test");

        // Adding layout report to the test report
        test.getReport().layout(layoutReport, "check layout on mobile device");
        tests.add(test);


        // Exporting all test reports to html
        try
        {
            new HtmlReportBuilder().build(tests, "target/galen-html-reports");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
