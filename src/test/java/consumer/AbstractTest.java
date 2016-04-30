package consumer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 29/04/16.
 */
public abstract class AbstractTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void setUpBefore() throws Exception {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}
