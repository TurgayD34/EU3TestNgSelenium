package com.cybertek.tests.day2_WebDriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.navigate().to("https://facebook.com");
        Thread.sleep(3000);
        driver.navigate().back(); // back
        Thread.sleep(3000);
        driver.navigate().forward(); // forward
        driver.navigate().refresh(); // Refresh

    }
}
