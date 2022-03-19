package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) {
        /*
        Task
        go to amazon.com
        search for selenium
        click search button
        verify 1-48 of 498 results for "selenium"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");

        WebElement searchBtn = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBtn.sendKeys("selenium");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        WebElement getResult = driver.findElement(By.xpath("//span[contains(text(),' results for')]"));
        String expectedResult = getResult.getText();
        String actaulResult = "1-48 of 498 results for";

        if (expectedResult.equals(actaulResult)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
            System.out.println("actaulResult = " + actaulResult);
            System.out.println("expectedResult = " + expectedResult);
        }

        driver.quit();
    }
}
