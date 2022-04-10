package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTest {

    /*
        Hover over each image in the website
        Verify each name:user text is displayed
     */
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
    public void firstSolution(){

        driver.get("http://practice.cybertekschool.com/hovers");
        String expect, actual;
        WebElement img1 = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));
        WebElement user1 = driver.findElement(By.xpath("//*[contains(text(),'user1')]"));
        img1.click();
        expect = user1.getText();
        actual = "name: user1";
        Assert.assertEquals(actual, expect);


        WebElement img2 = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/img"));
        WebElement user2 = driver.findElement(By.xpath("//*[contains(text(),'user2')]"));
        img2.click();
        expect = user2.getText();
        actual = "name: user2";
        Assert.assertEquals(actual, expect);

        WebElement img3 = driver.findElement(By.xpath("//*[@id='content']/div/div[3]/img"));
        WebElement user3 = driver.findElement(By.xpath("//*[contains(text(),'user3')]"));
        img3.click();
        expect = user3.getText();
        actual = "name: user3";
        Assert.assertEquals(actual, expect);
    }
    @Test
    public void secondSolution(){
        //use find elements() - more than one element
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1 = driver.findElement(By.tagName("img"));

        Actions actions = new Actions(driver);
        actions.moveToElement(img1).perform();
        WebElement user1 = driver.findElement(By.xpath("//*[contains(text(),'user1')]"));
        // h5[.='name: user1']
        Assert.assertTrue(user1.isDisplayed(), "Verify user1 is displayed");
        //there is another but not use much
//        Assert.assertEquals(user1.isDisplayed(),true);
    }
    @Test
    public void thirdSolution(){
        // use itar
        driver.get("http://practice.cybertekschool.com/hovers");
        for (int i = 1; i <= 3; i++) {
            String xpathImg = "(//img)["+i+"]";
            WebElement img = driver.findElement(By.xpath(xpathImg));
            System.out.println(xpathImg);

            Actions actions = new Actions(driver);
            actions.moveToElement(img).perform();

            String xpathUser = "//h5[.='name: user"+i+"']";
            WebElement user = driver.findElement(By.xpath(xpathUser));
            System.out.println(xpathUser);
            Assert.assertTrue(user.isDisplayed(),"Verify user "+i+"is displayed");
        }

    }
}
