package consumer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testSmartwatchesUntilDeliveryPage {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @Test
    public void firefoxSmartwatchTest() {

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://bau-ref-merch00.ref.o2.co.uk:9443/upgrade/store/smartwatches/");

        driver.findElement(By.partialLinkText("Samsung Gear S2")).click();
        driver.findElement(By.cssSelector("#deviceDetailsSubmit")).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-qa-gotobasket-link]")));
        driver.findElement(By.cssSelector("[data-qa-gotobasket-link]")).click();

        driver.findElement(By.name("securecheckout")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}





