package com.cybertek.tests.days15_review;

import com.cybertek.pages.Contacts.ContactInfoPage;
import com.cybertek.pages.Contacts.ContactPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {

    /*
        Open the chrome
        go to qa1
        login as salesmanager
        navigate customers -> contacts
        click on email mb.....@example.com
        verify that fullname is Mariam Bractstone
        verify that email is mbrack...@example.com
        verify that phone number is ......
     */

    @Test
    public void contactDetailsTest() {

        extentLogger = report.createTest("Contact Info Verification");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();
        extentLogger.info("Username: "+loginPage.usernameInput);
        extentLogger.info("Password: "+loginPage.passwordInput);
        extentLogger.info("Login as a Sales Manager");

        extentLogger.info("Navigate to --> Customers > Contacts");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Customers", "Contacts");


        ContactPage contactPage = new ContactPage();
        extentLogger.info("Click on mbrackstone9@example.com");
        contactPage.waitUntilLoaderScreenDisappear();
        String email = "mbrackstone9@example.com";
        contactPage.getContactEmail(email).click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualFullName = contactInfoPage.fullName.getText();
        String actualPhone = contactInfoPage.phone.getText();
        String actualEmail = contactInfoPage.email.getText();

        extentLogger.info("Verify full name is Mariam Brackstone");
        Assert.assertEquals(actualFullName, "Mariam Brackstone");
        extentLogger.info("Verify phone number is +18982323434");
        Assert.assertEquals(actualPhone, "+18982323434");
        extentLogger.info("Verify email is mbrackstone9@example.com");
        Assert.assertEquals(actualEmail, "mbrackstone9@example.com");

        extentLogger.pass("Passed");









    }
}
