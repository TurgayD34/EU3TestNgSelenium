package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

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
    public void SwitchWindowsTest(){
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("Title before new window = " + driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("Title after new window = " + driver.getTitle());

        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
        }
        System.out.println("Title after switch to new window = " + driver.getTitle());
    }
    @Test
    public void moreThan2Windows(){
        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("Before switch to = " + driver.getTitle());

        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        //loop through each window
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);

            //whenever your title equals to your expected window title
            if (!handle.equals("New Window")){
                //stop on that window
                break;
            }
        }
        System.out.println("Title after switch new window = " + driver.getTitle());
    }
}
