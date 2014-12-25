package adminModulePackage01;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Srikanth on 14/12/2014.
 */
public class BaseTest extends BaseClass {
    @BeforeClass
    public static void startBrowser() {
        driver = new FirefoxDriver();
        driver.get("http://insoftt.trial47.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @AfterClass
    public static void stopBrowser() {
        driver.quit();
    }
}
