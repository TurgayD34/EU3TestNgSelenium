package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

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
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownLink = driver.findElement(By.id("dropdownMenuLink"));
        dropdownLink.click();
        List<WebElement> elements = driver.findElements(By.className("dropdown-item"));
        System.out.println("elements = " + elements.size());
        for (WebElement element : elements) {
            System.out.println("element = " + element.getText());
        }
        //Click Yahoo
        elements.get(2).click();
    }
}
