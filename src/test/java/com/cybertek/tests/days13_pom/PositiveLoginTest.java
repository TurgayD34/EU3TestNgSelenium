package com.cybertek.tests.days13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void LoginAsDriver(){
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");
    }
    @Test
    public void LoginAsStoreManager(){
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsStoreManager("User1", "UserUser123");

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");
    }
    @Test
    public void loginAsSalesManager(){
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsSalesManager();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");
        //this method using mostly

    }
}
