package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {
    public static void main(String[] args) throws InterruptedException {
    /*
    * Verify URL changed
    * Open browser
    * go to ...... links to an external site
    * enter any mail
    * click on retrieve password
    * verify that url changed to ......
    * */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        String expectedURL = driver.getCurrentUrl();
        WebElement retrievePassButton = driver.findElement(By.id("form_submit"));
        retrievePassButton.click();

        String actualURL = driver.getCurrentUrl();
        if (expectedURL.equals(actualURL)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("td@gmail.com");
        retrievePassButton.click();
        Thread.sleep(5000);

        String expectedSendUrl = "http://practice.cybertekschool.com/email_sent";
        String actualSendUrl = driver.getCurrentUrl();
        if (expectedSendUrl.equals(actualSendUrl)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        System.out.println("actualSendUrl = " + actualSendUrl);
        System.out.println("expectedSendUrl = " + expectedSendUrl);
        driver.quit();
    }
}
