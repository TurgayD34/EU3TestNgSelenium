package com.cybertek.tests.days13_pom;

import com.cybertek.pages.CalenderEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {

    /*
        Verify radio buttons
        Open browser
        Login as a driver
        Go to Activities -> Calendar events
        Click on calendar events
        click on repeat
        verify that repeat every day is checked
        verify that repeat weekday is not checked
     */

    @Test
    public void VerifyRadioBtn(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();
        calenderEventsPage.waitUntilLoaderScreenDisappear(); //if browser int and it has loading problem, can solve like this
//        BrowserUtils.waitFor(3);
//        BrowserUtils.waitForClickablility(calenderEventsPage.createCalenderEvent, 5);
        calenderEventsPage.createCalenderEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        Assert.assertTrue(createCalendarEventsPage.days.isSelected());
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected());
    }

    /*
        Verify repeat options
        Open browser
        Login as driver
        Go to Activities -> Calendar Event
        Click on create calendar event btn
        Click on repeat checkbox
        Verify that repeat options are daily,weekly, monthly yearly (in this order)
     */

    @Test
    public void VerifyRepeatOptions(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();
        calenderEventsPage.waitUntilLoaderScreenDisappear();
        calenderEventsPage.createCalenderEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        Select repeatDropdown = new CreateCalendarEventsPage().repeatOptionsList();
        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");
        List<String> actualList = new ArrayList<>();
        List<WebElement> actualOptions = repeatDropdown.getOptions();
        for (WebElement option : actualOptions) {
            actualList.add(option.getText());
        }
        Assert.assertEquals(actualList, expectedList);


    }
}
