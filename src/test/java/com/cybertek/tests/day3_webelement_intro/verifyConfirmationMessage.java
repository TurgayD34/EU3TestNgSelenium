package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        String expectedEmail = "td@gmail.com";
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys(expectedEmail);
        Thread.sleep(2000);

        String actualemail = emailInputBox.getAttribute("value");
        if (expectedEmail.equals(actualemail)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        WebElement retrievePassButton = driver.findElement(By.id("form_submit"));
        retrievePassButton.click();
        Thread.sleep(2000);

        WebElement confMessage = driver.findElement(By.name("confirmation_message"));
        String expectedConfText = confMessage.getText();
        String actualConfText = "Your e-mail's been sent!";

        if (expectedConfText.equals(actualConfText)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            System.out.println("actualConfText = " + actualConfText);
            System.out.println("expectedConfText = " + expectedConfText);
        }


        driver.quit();
    }
}
