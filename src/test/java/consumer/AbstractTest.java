package consumer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * Created by user on 29/04/16.
 */
public abstract class AbstractTest {

    protected static WebDriver driver;

    protected static WebDriverWait wait;

    @BeforeClass
    public static void setUp() throws Exception {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
        wait  = new WebDriverWait(driver,16);
    }

    @BeforeMethod
    public void setUpBefore() throws Exception {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}
