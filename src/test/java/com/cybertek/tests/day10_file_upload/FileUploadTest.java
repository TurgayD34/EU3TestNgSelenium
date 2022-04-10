package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/upload");
        WebElement chooseFileBtn = driver.findElement(By.id("file-upload"));
        Thread.sleep(2000);
        //Choose file it means, need to send keys
        chooseFileBtn.sendKeys("/Users/tdmr/Desktop/Text.rtf");
        WebElement uploadFile = driver.findElement(By.id("file-submit"));
        uploadFile.click();
        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
        String expectedUploadedFiles = uploadedFiles.getText();
        System.out.println("expectedUploadedFiles = " + expectedUploadedFiles);
        String actualUploadedFiles = "Text.rtf";
        Assert.assertEquals(actualUploadedFiles, expectedUploadedFiles);

    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/upload");
        WebElement chooseFileBtn = driver.findElement(By.id("file-upload"));
        Thread.sleep(2000);
        //Choose file it means, need to send keys
        chooseFileBtn.sendKeys("/Users/tdmr/Desktop/Text.rtf");
        WebElement uploadFile = driver.findElement(By.id("file-submit"));
        uploadFile.click();
        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
        String expectedUploadedFiles = uploadedFiles.getText();
        System.out.println("expectedUploadedFiles = " + expectedUploadedFiles);
        String actualUploadedFiles = "Text.rtf";
        Assert.assertEquals(actualUploadedFiles, expectedUploadedFiles);
    }
}
