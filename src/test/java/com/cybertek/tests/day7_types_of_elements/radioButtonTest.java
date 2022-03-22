package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class radioButtonTest {

    @Test
    public void TC001_blueIsSelected(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.id("blue"));
        blueRadioBtn.click();
        WebElement redRadioBtn = driver.findElement(By.cssSelector("#red"));
        WebElement yellowRadioBtn = driver.findElement(By.cssSelector("#yellow"));
        WebElement blackRadioBtn = driver.findElement(By.cssSelector("#black"));

        Assert.assertTrue(blueRadioBtn.isSelected(), "Verify blue is selected");
        Assert.assertFalse(redRadioBtn.isSelected(), "Verify red is not selected");
        Assert.assertFalse(yellowRadioBtn.isSelected(), "Verify red is not selected");
        Assert.assertFalse(blackRadioBtn.isSelected(), "Verify red is not selected");

        driver.quit();
    }
    @Test
    public void TC002_redIsSelected(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.id("blue"));
        WebElement redRadioBtn = driver.findElement(By.cssSelector("#red"));
        redRadioBtn.click();
        WebElement yellowRadioBtn = driver.findElement(By.cssSelector("#yellow"));
        WebElement blackRadioBtn = driver.findElement(By.cssSelector("#black"));

        Assert.assertFalse(blueRadioBtn.isSelected(), "Verify blue is not selected");
        Assert.assertTrue(redRadioBtn.isSelected(), "Verify red is selected");
        Assert.assertFalse(yellowRadioBtn.isSelected(), "Verify red is not selected");
        Assert.assertFalse(blackRadioBtn.isSelected(), "Verify red is not selected");

        driver.quit();
    }
    @Test
    public void TC003_yellowIsSelected(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.id("blue"));
        WebElement redRadioBtn = driver.findElement(By.cssSelector("#red"));
        WebElement yellowRadioBtn = driver.findElement(By.cssSelector("#yellow"));
        yellowRadioBtn.click();
        WebElement blackRadioBtn = driver.findElement(By.cssSelector("#black"));

        Assert.assertFalse(blueRadioBtn.isSelected(), "Verify blue is not selected");
        Assert.assertFalse(redRadioBtn.isSelected(), "Verify red is not selected");
        Assert.assertTrue(yellowRadioBtn.isSelected(), "Verify red is selected");
        Assert.assertFalse(blackRadioBtn.isSelected(), "Verify red is not selected");

        driver.quit();
    }
    @Test
    public void TC004_blackIsSelected(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.id("blue"));
        WebElement redRadioBtn = driver.findElement(By.cssSelector("#red"));
        WebElement yellowRadioBtn = driver.findElement(By.cssSelector("#yellow"));
        WebElement blackRadioBtn = driver.findElement(By.cssSelector("#black"));
        blackRadioBtn.click();

        Assert.assertFalse(blueRadioBtn.isSelected(), "Verify blue is not selected");
        Assert.assertFalse(redRadioBtn.isSelected(), "Verify red is not selected");
        Assert.assertFalse(yellowRadioBtn.isSelected(), "Verify red is not selected");
        Assert.assertTrue(blackRadioBtn.isSelected(), "Verify red is selected");

        driver.quit();
    }
    @Test
    public void TC005_testOneTimeAll() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.id("blue"));
        blueRadioBtn.click();
//        Thread.sleep(3000);
        WebElement redRadioBtn = driver.findElement(By.cssSelector("#red"));
        WebElement yellowRadioBtn = driver.findElement(By.cssSelector("#yellow"));
        WebElement blackRadioBtn = driver.findElement(By.cssSelector("#black"));

        Assert.assertTrue(blueRadioBtn.isSelected(), "Verify blue is selected");
        Assert.assertFalse(redRadioBtn.isSelected(), "Verify red is not selected");
        Assert.assertFalse(yellowRadioBtn.isSelected(), "Verify red is not selected");
        Assert.assertFalse(blackRadioBtn.isSelected(), "Verify red is not selected");

        redRadioBtn.click();
//        Thread.sleep(3000);
        Assert.assertFalse(blueRadioBtn.isSelected(), "Verify blue is not selected");
        Assert.assertTrue(redRadioBtn.isSelected(), "Verify red is selected");
        Assert.assertFalse(yellowRadioBtn.isSelected(), "Verify red is not selected");
        Assert.assertFalse(blackRadioBtn.isSelected(), "Verify red is not selected");

        yellowRadioBtn.click();
//        Thread.sleep(3000);
        Assert.assertFalse(blueRadioBtn.isSelected(), "Verify blue is not selected");
        Assert.assertFalse(redRadioBtn.isSelected(), "Verify red is not selected");
        Assert.assertTrue(yellowRadioBtn.isSelected(), "Verify red is selected");
        Assert.assertFalse(blackRadioBtn.isSelected(), "Verify red is not selected");

        blackRadioBtn.click();
//        Thread.sleep(3000);
        Assert.assertFalse(blueRadioBtn.isSelected(), "Verify blue is not selected");
        Assert.assertFalse(redRadioBtn.isSelected(), "Verify red is not selected");
        Assert.assertFalse(yellowRadioBtn.isSelected(), "Verify red is not selected");
        Assert.assertTrue(blackRadioBtn.isSelected(), "Verify red is selected");

        driver.quit();
    }
}
