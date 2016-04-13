package consumer;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by user on 02/03/16.
 */
public class testTabletUntilDeliveryPage {

    @Test
    public void firefoxTabletTest() {


        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://bau-ref-merch00.ref.o2.co.uk:9443/upgrade/store/tablets/");


        driver.findElement(By.partialLinkText("Sony Xperia Z4")).click();
        driver.manage().deleteAllCookies();

        driver.findElement(By.cssSelector("#deviceDetailsSubmit")).click();

        driver.findElement(By.cssSelector("#callToAction")).click();

        driver.findElement(By.cssSelector("#header > div:nth-of-type(2) > div:nth-of-type(1) > div > button")).click();

        driver.findElement(By.cssSelector("#shopApp > div:nth-of-type(2) > div > div > div:nth-of-type(1) > div:nth-of-type(1) > div > form > input")).click();

        driver.close();

        driver.quit();
    }

}
