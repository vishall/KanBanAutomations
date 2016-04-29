package consumer;

import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by user on 02/03/16.
 */
public class testTabletUntilDeliveryPage {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @Test
    public void firefoxTabletTest() {

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://bau-ref-merch00.ref.o2.co.uk:9443/upgrade/store/tablets/");


        driver.findElement(By.partialLinkText("Sony Xperia Z4")).click();
        driver.manage().deleteAllCookies();

        driver.findElement(By.cssSelector("#deviceDetailsSubmit")).click();

        driver.findElement(By.cssSelector("#callToAction")).click();

        driver.findElement(By.cssSelector("#header > div:nth-of-type(2) > div:nth-of-type(1) > div > button")).click();

        driver.findElement(By.name("securecheckout")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}
