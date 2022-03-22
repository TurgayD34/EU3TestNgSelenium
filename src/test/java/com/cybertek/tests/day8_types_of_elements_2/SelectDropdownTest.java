package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {

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
        WebElement dropdownElement = driver.findElement(By.id("state"));

        Select stateDropdown = new Select(dropdownElement);
        List<WebElement> options = stateDropdown.getOptions();
        System.out.println("options.size() = " + options.size());
        for (WebElement option : options) {
            System.out.println("option = " + option.getText());
        }
    }
    @Test
    public void test2() throws InterruptedException {
        // How to select first element from dropdown

        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("state"));

        Select stateDropdown = new Select(dropdownElement);
        String expectedOption = "Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
//        System.out.println("expectedOption = " + expectedOption);
//        System.out.println("actualOption = " + actualOption);
        Assert.assertEquals(actualOption,expectedOption);

        // How to select option from dropdown
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia"); //Select an option from dropdown
        expectedOption = "Virginia";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption);

        // Select using index
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Wyoming");
        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption);

        // Select by value
        Thread.sleep(2000);
        stateDropdown.selectByValue("AZ");
        expectedOption = "Arizona";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption);


    }
}
