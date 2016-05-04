//package Agent;
//
//import consumer.AbstractTest;
//import org.junit.Ignore;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by user on 29/04/16.
// */
//public class AgentDeliveryPageTest extends AbstractTest {
//
//
//    @Test
//    public void firefoxWithTariffTest(){
//
//        driver.navigate().to("https://bau-ref-merch00.ref.o2.co.uk:9443/agent/app/home?PartnerId=o2");
//
//        List<WebElement> links = driver.findElements(By.tagName("a"));
//
//        links.get(0).click();
//
//        WebDriverWait wait = new WebDriverWait(driver,15);
//        wait.until(ExpectedConditions.elementToBeClickable(By.className("buy")));
//
//        List<WebElement> tariff = driver.findElements(By.className("buy"));
//        tariff.get(0).click();
//
//        driver.findElement(By.id("devicesTab")).click();
//
//
//        WebDriverWait wait1 = new WebDriverWait(driver,15);
//        wait1.until(ExpectedConditions.elementToBeClickable(By.className("buy")));
//        List<WebElement> device = driver.findElements(By.className("buy"));
//        wait.until(ExpectedConditions.elementToBeClickable(By.className("buy")));
//        device.get(0).click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("option")));
//        List<WebElement> dropdown = driver.findElements(By.tagName("option"));
//        dropdown.get(2).click();
//        }
//    }
//
