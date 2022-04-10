package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilePathExample {
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
    public void test1(){
        // /Users/tdmr/IdeaProjects/EU3TestNgSelenium/src/test/resources/text.txt
        System.out.println(System.getProperty("user.dir"));

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/text.txt";

        String fullPath = projectPath + "/" + filePath;
        System.out.println("fullPath = " + fullPath);
    }
}
