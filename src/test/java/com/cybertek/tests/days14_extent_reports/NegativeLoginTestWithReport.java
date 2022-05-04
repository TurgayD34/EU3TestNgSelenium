package com.cybertek.tests.days14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void emptyUsernameTest(){
        //name of the test
        extentLogger = report.createTest("Wrong Username Test");//I need to remember only this

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("some_username");
        extentLogger.info("Enter Username: some_username");

        loginPage.passwordInput.sendKeys("driver_password");
        extentLogger.info("Enter Password: driver_password");

        loginPage.loginBtn.click();
        extentLogger.info("Click Login Button");

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Username Test is PASSED");
    }
    @Test
    public void emptyPasswordTest(){
        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter Username: driver_username");
        loginPage.usernameInput.sendKeys("driver_username");

        extentLogger.info("Enter Password: some_password");
        loginPage.passwordInput.sendKeys("some_password");

        extentLogger.info("Click Login Button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Password Test is PASSED");
    }

}
