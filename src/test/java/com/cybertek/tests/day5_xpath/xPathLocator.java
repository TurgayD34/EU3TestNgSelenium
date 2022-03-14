package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xPathLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.findElement(By.xpath("//*[@onclick='button3()']")).click();
        Thread.sleep(3000);

        WebElement textBtn3 = driver.findElement(By.xpath("//p[contains(text(),' three!')]"));
        String expectedTextBtn3 = textBtn3.getText();
        System.out.println("expectedTextBtn3 = " + expectedTextBtn3);

        String actualTextBtn3 = "Clicked on button three!";

        if (actualTextBtn3.equals(expectedTextBtn3)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        driver.quit();
    }
}
