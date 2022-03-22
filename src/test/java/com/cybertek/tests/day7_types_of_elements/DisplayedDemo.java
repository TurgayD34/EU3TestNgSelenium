package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");


        // This username element is not visible on the screen

        /*
        Task
        Verify username inputbox is not displayed on the screen
        click start button
        verify username displayed on the screen
         */
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement startBtn = driver.findElement(By.cssSelector("#start>button"));
        startBtn.click();
        Assert.assertFalse(usernameInput.isDisplayed());
        driver.quit();
    }

}
