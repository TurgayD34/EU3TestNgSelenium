package com.cybertek.tests.days13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("driver_username");
        loginPage.passwordInput.sendKeys("password");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");
    }
    @Test
    public void wrongUsernameTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys("user");
        loginPage.passwordInput.sendKeys("driver_password");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");
    }
    @Test
    public void wrongUsernameAndPasswordTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys("user");
        loginPage.passwordInput.sendKeys("password");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");
    }
    @Test
    public void emptyUsernameTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys("");
        loginPage.passwordInput.sendKeys("driver_password");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");
    }
    @Test
    public void emptyPasswordTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys("driver_username");
        loginPage.passwordInput.sendKeys("");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");
    }
}
