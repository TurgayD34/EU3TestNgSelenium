package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=a6aa0");

        //Click the destroy the world button
        driver.findElement(By.xpath("//*[@id='j_idt311:j_idt312']/span[2]")).click();

        //Click No button
        driver.findElement(By.xpath("//button[.='No']")).click();
    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlert.click();
        //Switch to JS alert pop up
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);
        alert.dismiss(); //cancel

        //Click for JS prompt
        driver.findElement(By.xpath("//button[3]")).click();
        alert.sendKeys("Merhaba");
        Thread.sleep(2000);
        alert.accept();
    }
}
