package com.cybertek.tests.day2_WebDriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
//        Thread.sleep(3000);
//        driver.navigate().to("https://facebook.com");
//        Thread.sleep(3000);
//        driver.navigate().back();

        String title = driver.getTitle();
        // Option + Enter + Enter
        System.out.println("title = " + title); // soutv + enter

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);
    }
}
