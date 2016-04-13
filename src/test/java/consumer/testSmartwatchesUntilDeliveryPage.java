package consumer;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by user on 01/03/16.
 */
public class testSmartwatchesUntilDeliveryPage {

    @Test
    public void firefoxSmartwatchTest() {


        WebDriver driver = new FirefoxDriver();
        try {
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.navigate().to("https://bau-ref-merch00.ref.o2.co.uk:9443/upgrade/store/smartwatches/");


            driver.findElement(By.partialLinkText("Samsung Gear S2")).click();
            //driver.manage().deleteAllCookies();

            driver.findElement(By.cssSelector("#deviceDetailsSubmit")).click();


            //  driver.findElement(By.cssSelector("#header > div:nth-of-type(2) > div:nth-of-type(1) > div > button")).click();

            driver.findElement(By.cssSelector("#shopApp > div:nth-of-type(2) > div > div > div:nth-of-type(1) > div:nth-of-type(1) > div > form > input")).click();

            System.out.println("firefoxSmartwatchTest passed");
        } catch (Exception ex) {
            System.err.println("firefoxSmartwatchTest failed");
            ex.printStackTrace();
        } finally {
            driver.close();

            driver.quit();
        }

    }
}

