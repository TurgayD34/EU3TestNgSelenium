package com.cybertek.tests.days13_pom;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.CalenderEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Verify;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /*
        Test Case
            Open Chrome Browser
            Login as a Driver
            Verify that page subtitle is Quick Launchpad
            Go to Activities -> Calender Events
            Verify that page subtitle is Calendar Events
     */

    @Test
    public void VerifySubtitles(){
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        //Verify that page subtitle is Quick Launchpad

        String expected = "Quick Launchpad";

        String actual = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actual, expected, "verify subtitle");

        expected = "Quick Launchpadd";

        Assert.assertNotEquals(actual, expected, "Verify not equals");

        //Verify that page subtitle is Calendar Events

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();

        BrowserUtils.waitFor(2);

        //If the calenderEvents page working no need to use waitFor

        Assert.assertEquals(calenderEventsPage.getPageSubTitle(),"Calendar Events", "Verify Calendar Events");
    }
}
