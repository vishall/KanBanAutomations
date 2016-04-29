package consumer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by user on 01/03/16.
 */
public class testPhoneUntilDeliveryPage {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @Test
    public void firefoxPhoneTest() {

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://bau-ref-merch00.ref.o2.co.uk:9443/upgrade/store/phones/");

        driver.findElement(By.partialLinkText("Apple iPhone 6")).click();
        driver.manage().deleteAllCookies();

        driver.findElement(By.cssSelector("#deviceDetailsSubmit")).click();
        driver.manage().deleteAllCookies();
        driver.findElement(By.cssSelector("#callToAction")).click();

        driver.findElement(By.cssSelector("#header > div:nth-of-type(2) > div:nth-of-type(1) > div > button")).click();
        driver.findElement(By.cssSelector("#shopApp > div:nth-of-type(2) > div > div > div:nth-of-type(1) > div:nth-of-type(1) > div > form > input")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}

