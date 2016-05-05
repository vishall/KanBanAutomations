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

    @Test(dataProvider = "ConnectedDevices")
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

    @Test(dataProvider = "NonConnectedDevices")
    public void firefoxWithoutTariffTest(String deviceUrl, String deviceName) {

        driver.navigate().to("https://bau-ref-merch00.ref.o2.co.uk:9443/upgrade/store/"+ deviceUrl +"/");

        driver.findElement(By.partialLinkText(deviceName)).click();
        driver.findElement(By.cssSelector("#deviceDetailsSubmit")).click();

        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-qa-gotobasket-link]")));
        driver.findElement(By.cssSelector("[data-qa-gotobasket-link]")).click();

        driver.findElement(By.name("securecheckout")).click();
        Assertion assertion = new Assertion();
        assertion.assertEquals(driver.getTitle(), "O2 | Delivery");
    }

    @Test(dataProvider = "AccessoriesData")
    public void firefoxAccessoriesTest(String deviceUrl, String deviceName) {

        driver.navigate().to("https://bau-ref-merch00.ref.o2.co.uk:9443/upgrade/store/"+ deviceUrl +"/");

        driver.findElement(By.partialLinkText(deviceName)).click();
        driver.findElement(By.cssSelector("#deviceDetailsSubmit")).click();

        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-qa-gotobasket-link]")));
        driver.findElement(By.cssSelector("[data-qa-gotobasket-link]")).click();

        driver.findElement(By.name("securecheckout")).click();
        Assertion assertion = new Assertion();
        assertion.assertEquals(driver.getTitle(), "O2 | Delivery");
    }

    @DataProvider(name = "NonConnectedDevices")
    public static Object[][] NonConnectedDevices() {
        return new Object[][] {
                {"smartwatches", "Samsung Gear S2"},
                {"fitness-trackers", "Fitbit Blaze"}
        };
    }

    @DataProvider(name = "AccessoriesData")
    public static Object[][] AccessoriesData() {
        return new Object[][] {

                {"accessories", "Samsung Galaxy Wireless Charging Plate"},

        };
    }

    @DataProvider(name = "ConnectedDevices")
    public static Object[][] ConnectedDevices() {
        return new Object[][] {
                {"phones", "Apple iPhone 6"},
                {"mobile-broadband", "Huawei 4G In-Car wifi"},
                {"tablets", "Sony Xperia Z4"},
        };
    }
}
