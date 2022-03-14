package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class OpenBrowser {
    public static void main(String[] args) {
        // We have to enter this line every time we want to open chrome
        // Hi, webdrivermanagerm can you make chrome ready for me for automation
        WebDriverManager.chromedriver().setup();

        // WebDriver represent the browser
        // We are creating driver for chrome browser
        // new ChromeDriver() --> this part will open chrome browser
        WebDriver driver = new ChromeDriver();

        // .get(URL) method for navigation to page
        driver.get("https://cybertekschool.com");
    }
}
