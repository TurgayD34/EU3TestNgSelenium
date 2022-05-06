package com.cybertek.tests.days16_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object [][] userData(){
        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytacttestdata.xlsx","QA3-short");

        String [][] dataArray = qa3short.getDataArrayWithoutFirstRow();
        //We use getDataArrayWithoutFirstRow because it will skip first line and start from username

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void testData(String username, String password, String firstName,String lastName){
        extentLogger = report.createTest("Test "+firstName +" "+lastName);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullName = dashboardPage.getUserName();
        String expectedFullName = firstName + " " + lastName;

        Assert.assertEquals(actualFullName, expectedFullName,"Verify full name ");
        extentLogger.pass("PASSED");

        //Switch the URL in conf.pro to qa3
    }
}
