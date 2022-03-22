package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.cssSelector("#blue"));
        System.out.println(blueRadioBtn.getAttribute("value"));
        System.out.println(blueRadioBtn.getAttribute("name"));

        driver.quit();
    }
}
