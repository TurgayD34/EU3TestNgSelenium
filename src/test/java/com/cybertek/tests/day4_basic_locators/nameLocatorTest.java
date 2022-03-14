package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        driver.manage().window().maximize();

        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("TDemir");

        // proper way
//        WebElement email = driver.findElement(By.name("email"));
//        email.sendKeys("td@gmail.com");

        // lazy way
        driver.findElement(By.name("email")).sendKeys("td@gmail.com");
        // Both are doing same job

//        WebElement signUp = driver.findElement(By.className("radius"));
//        signUp.click();

        driver.findElement(By.className("radius")).click();
        Thread.sleep(3000);

        driver.quit();
    }
}
