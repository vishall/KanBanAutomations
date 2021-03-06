package consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static org.testng.Assert.assertEquals;

/**
 * Created by user on 01/03/16.
 */
public class ConsumerDeliveryPageTest extends AbstractTest {

    @Test(dataProvider = "ConnectedDevices")
    public void firefoxWithTariffTest(String deviceUrl, String deviceName) {
        driver.navigate().to("https://bau-ref-merch00.ref.o2.co.uk:9444/upgrade/store/"+ deviceUrl +"/");

        if(!(deviceUrl == "mobile-broadband"))
        driver.findElement(By.className("page-all")).click();

        driver.findElement(By.partialLinkText(deviceName)).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#deviceDetailsSubmit")));

        driver.findElement(By.cssSelector("#deviceDetailsSubmit")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-qa-simo-tariff-buynow]")));
        driver.findElement(By.cssSelector("[data-qa-simo-tariff-buynow]")).click();

        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#qa-proceed-to-basket-dock-header")));
        driver.findElement(By.cssSelector("#qa-proceed-to-basket-dock-header")).click();
        driver.findElement(By.name("securecheckout")).click();
        wait.until(ExpectedConditions.titleIs(driver.getTitle()));

        assertEquals(driver.getTitle(), "O2 | Delivery");
    }

//    @Test(dataProvider = "NonConnectedDevices")
//    public void firefoxWithoutTariffTest(String deviceUrl, String deviceName) {
//
//        driver.navigate().to("https://bau-ref-merch00.ref.o2.co.uk:9444/upgrade/store/"+ deviceUrl +"/");
//
//        driver.findElement(By.className("page-all")).click();
//
//        driver.findElement(By.partialLinkText(deviceName)).click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#deviceDetailsSubmit")));
//        driver.findElement(By.cssSelector("#deviceDetailsSubmit")).click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-qa-gotobasket-link]")));
//        driver.findElement(By.cssSelector("[data-qa-gotobasket-link]")).click();
//
//        driver.findElement(By.name("securecheckout")).click();
//        wait.until(ExpectedConditions.titleIs(driver.getTitle()));
//
//        assertEquals(driver.getTitle(), "O2 | Delivery");
//    }

    @Test(dataProvider = "AccessoriesData")
    public void firefoxAccessoriesTest(String deviceUrl, String deviceName) {

        driver.navigate().to("https://bau-ref-merch00.ref.o2.co.uk:9444/upgrade/store/"+ deviceUrl +"/");

        driver.findElement(By.className("page-all")).click();


        driver.findElement(By.partialLinkText(deviceName)).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#deviceDetailsSubmit")));
        driver.findElement(By.cssSelector("#deviceDetailsSubmit")).click();

//        WebDriverWait wait = new WebDriverWait(driver,15);
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-qa-gotobasket-link]")));
//        driver.findElement(By.cssSelector("[data-qa-gotobasket-link]")).click();

        driver.findElement(By.name("securecheckout")).click();
        Assertion assertion = new Assertion();
        wait.until(ExpectedConditions.titleIs(driver.getTitle()));
        assertion.assertEquals(driver.getTitle(), "O2 | Delivery");
    }

//    @DataProvider(name = "NonConnectedDevices")
//    public static Object[][] NonConnectedDevices() {
//        return new Object[][] {
//                {"smartwatches", "Samsung Gear VR Black"}
//              //  {"fitness-trackers", "Garmin vivosmart HR"}
//        };
//    }

    @DataProvider(name = "AccessoriesData")
    public static Object[][] AccessoriesData() {
        return new Object[][] {

                {"accessories/all", "Samsung Original Convertible Wireless Charger Black"},

        };
    }

    @DataProvider(name = "ConnectedDevices")
    public static Object[][] ConnectedDevices() {
        return new Object[][] {
                {"phones", "Samsung Galaxy S8 Plus"},
                {"mobile-broadband", "Huawei 4G Pocket Hotspot Plus"},
                {"tablets", "Alcatel Plus 10"},
        };
    }
}

