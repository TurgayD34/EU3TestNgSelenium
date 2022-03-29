package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/iframe");

        //How to switch frames

        // 1. Switch using by name or id attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        // clear before sendkeys
        WebElement iframe =  driver.findElement(By.id("tinymce"));
        iframe.clear();
        iframe.sendKeys("Merhaba Dunya!!!");

        //goes back to first frame(main html)
        //goes back to first frame, useful when we have switched multiple frmaes
        driver.switchTo().defaultContent();

        // 2. Switching with index
        driver.switchTo().frame(0);
        WebElement iframeIndex =  driver.findElement(By.id("tinymce"));
        iframeIndex.clear();
        iframeIndex.sendKeys("Merhaba Dunya with index!!!");

        driver.switchTo().parentFrame();

        // 3. Switching with Web Element
        WebElement iframeWE = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeWE);
        iframeIndex.clear();
        driver.findElement(By.id("tinymce")).sendKeys("Merhaba Dunya!!! with WE");
    }
    @Test
    public void test2(){
        driver.get("https://practice-cybertekschool.herokuapp.com/nested_frames");
        //Switching to frame top
        driver.switchTo().frame("frame-top");
        //Switching to frame middle
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        //Switching to frame right
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //Switching to frame left
        driver.switchTo().parentFrame();
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //Switching to frame bottom
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        /*
           HTML (default content)
              0 - frame top (parent frame)
                  0 - left
                  1 - middle
                  2 - right
              1 - frame bottom
         */
    }
}
