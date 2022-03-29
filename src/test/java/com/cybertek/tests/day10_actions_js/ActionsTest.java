package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.accessibility.AccessibleTable;
import java.util.List;

public class ActionsTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1 = driver.findElement(By.tagName("img"));

        // Actions ==> Class that contains all the user interactions
        // How to create actions ==> Passing driver as a constructor
        Actions actions = new Actions(driver);

        // Perform() ==> Perform the action, complete the action
        // moveToElement ==> move your mouse to web element (hover over)
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));
        String viewLinkText = viewLink.getText();
        System.out.println("viewLinkText = " + viewLinkText);

        Assert.assertTrue(viewLink.isDisplayed());
    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

//        List<WebElement> acceptAndClose = driver.findElement(By.id("onetrust-accept-btn-handler"));
//        List<WebElement> acceptCookies = driver.findElement(By.xpath("//*[.='Accept Cookies']"));
//        if (acceptAndClose.size() > 0){
//            acceptAndClose.get(0).click();
//        }else if(acceptCookies.size() > 0){
//            acceptCookies.get(0).click();
//        }
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        Thread.sleep(3000);

        actions.dragAndDrop(source, target).perform();
    }
    @Test
    public void dragAndDrop2() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        Thread.sleep(2000);
//        actions.moveToElement(source).clickAndHold().moveToElement(target).release().perform();
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();
    }
}
