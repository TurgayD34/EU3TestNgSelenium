package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisableElements {

    @Test
    public void disbaleBtn(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioBtn = driver.findElement(By.cssSelector("#green"));
        greenRadioBtn.click();

        //How to check any web element is enabled or not?
//        System.out.println("greenRadioBtn.isEnabled() = " + greenRadioBtn.isEnabled());
        Assert.assertFalse(greenRadioBtn.isEnabled());

        driver.quit();
    }
    @Test
    public void enableControl() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement disableInput = driver.findElement(By.cssSelector("#input-example>input"));
        Assert.assertFalse(disableInput.isEnabled());

        WebElement clickEnableBtn = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        clickEnableBtn.click();
        Thread.sleep(3000);
        disableInput.sendKeys("Td");
        Assert.assertTrue(disableInput.isEnabled());


        driver.quit();
    }
}
