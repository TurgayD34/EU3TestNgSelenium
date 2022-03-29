package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWaitExample {

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
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");
        // Do not use to much Thread.sleep() it makes slows the execution of tests
        WebElement usernameInput = driver.findElement(By.id("username"));

        //How to wait explicitly?
        //Create explicit wait object
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys("TD");
    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //click enable
        WebElement buttonBox = driver.findElement(By.xpath("//*[@onclick='swapInput()']"));
        buttonBox.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonBox));
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        inputBox.sendKeys("Mike Smith");
    }
}
