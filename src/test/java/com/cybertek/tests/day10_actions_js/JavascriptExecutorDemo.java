package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavascriptExecutorDemo {
        WebDriver driver;

        @BeforeMethod
        public void setUp() {
            driver = WebDriverFactory.getDriver("chrome");
        }

        @AfterMethod
        public void tearDown() throws InterruptedException {
            Thread.sleep(2000);
            driver.quit();
        }

        @Test
        public void ClickWithJS(){
            driver.get("http://practice.cybertekschool.com/");

            WebElement dropDown = driver.findElement(By.linkText("Dropdown"));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", dropDown);
        }

        @Test
        public void typeWithJS(){
            driver.get("http://practice.cybertekschool.com/dynamic_controls");
            WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            String text = "Hello disable input";

            jse.executeScript("arguments[0].setAttribute('value', '"+text+"')", inputBox);
        }

        @Test
        public void ScrollDownAndUp() throws InterruptedException {
            driver.get("http://practice.cybertekschool.com/infinite_scroll");

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                jse.executeScript("window.scrollBy(0,500)");
            }
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                jse.executeScript("window.scrollBy(0,-500)");
            }
        }

        @Test
        public void ScrollToElement() throws InterruptedException {
            driver.get("https://www.amazon.com/");
            WebElement scrollNewCustomer = driver.findElement(By.xpath("//span[@class='icp-color-base' and contains(text(),'English')]"));
            Thread.sleep(1000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", scrollNewCustomer);
        }
}
