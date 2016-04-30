package consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

/**
 * Created by user on 01/03/16.
 */
public class ConsumerDeliveryPageTest extends AbstractTest {

    @Test(dataProvider = "withTariffData")
    public void firefoxWithTariffTest(String deviceUrl, String deviceName) {
        driver.navigate().to("https://bau-ref-merch00.ref.o2.co.uk:9443/upgrade/store/"+ deviceUrl +"/");

        driver.findElement(By.partialLinkText(deviceName)).click();
        driver.manage().deleteAllCookies();

        driver.findElement(By.cssSelector("#deviceDetailsSubmit")).click();
        driver.manage().deleteAllCookies();
        driver.findElement(By.cssSelector("#callToAction")).click();

        driver.findElement(By.cssSelector("#header > div:nth-of-type(2) > div:nth-of-type(1) > div > button")).click();
        driver.findElement(By.name("securecheckout")).click();
        Assertion assertion = new Assertion();
        assertion.assertEquals(driver.getTitle(), "O2 | Delivery");
    }

    @Test(dataProvider = "withoutTariffData")
    public void firefoxWithoutTariffTest(String deviceUrl, String deviceName) {

        driver.navigate().to("https://bau-ref-merch00.ref.o2.co.uk:9443/upgrade/store/"+ deviceUrl +"/");

        driver.findElement(By.partialLinkText(deviceName)).click();
        driver.findElement(By.cssSelector("#deviceDetailsSubmit")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-qa-gotobasket-link]")));
        driver.findElement(By.cssSelector("[data-qa-gotobasket-link]")).click();

        driver.findElement(By.name("securecheckout")).click();
        Assertion assertion = new Assertion();
        assertion.assertEquals(driver.getTitle(), "O2 | Delivery");
    }

    @DataProvider(name = "withoutTariffData")
    public static Object[][] withoutTariffData() {
        return new Object[][] {
                {"smartwatches", "Samsung Gear S2"},
                {"accessories", "Samsung Galaxy Wireless Charging Plate"},
                {"fitness-trackers", "Fitbit Blaze"}
        };
    }

    @DataProvider(name = "withTariffData")
    public static Object[][] withTariffData() {
        return new Object[][] {
                {"phones", "Apple iPhone 6"},
                {"mobile-broadband", "Huawei 4G In-Car wifi"},
                {"tablets", "Sony Xperia Z4"},
        };
    }
}

