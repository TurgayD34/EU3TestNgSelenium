package com.cybertek.tests.days11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class webTablesExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void printTable(){
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());
        //Get the whole tables
        Assert.assertTrue(table.getText().contains("fbach@yahoo.com"));
        //Verify one of the element from the table
    }
    @Test
    public void getAllHeaders(){
        //How many columns on the table
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Headers Size = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }
    @Test
    public void printTableSize(){
        List<WebElement> tableSize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("tableSize.size() = " + tableSize.size());
    }
    @Test
    public void getRow(){
        //print the second row information
        WebElement secondRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr"));
//        System.out.println(secondRow.getText());

        List<WebElement> tableSize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i = 1; i <= tableSize.size(); i++) {
             WebElement tableRows = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
             System.out.println(i+" = " + tableRows.getText());
        }
    }
    @Test
    public void getAllCellInOneRow(){
        List<WebElement> allCellInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr[2]/td"));
        for (WebElement webElement : allCellInOneRow) {
            System.out.println(webElement.getText());
        }
    }
    @Test
    public void getASingleCellByIndex(){
        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody//tr[3]/td[5]"));
        System.out.println(singleCell.getText());
        WebElement singleCell2 = driver.findElement(By.xpath("//table[@id='table1']/tbody//tr[2]/td[3]"));
        System.out.println(singleCell2.getText());
    }
    @Test
    public void printAllCellsByIndex(){
        int rowNumber = getNumberOfRow();
        int colNumber = getNumberOfCol();

        for (int i = 1; i <= rowNumber; i++) {


            for (int j = 1; j <= colNumber ; j++) {
                String cellXPath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                System.out.println(cellXPath);
                WebElement cell = driver.findElement(By.xpath(cellXPath));
                System.out.println(cell.getText());

            }

        }
    }
    @Test
    public void getCellInRelationToAnotherCellInSameRow(){

        String firstName = "Tim";
        String xpath = "//table[@id='table1']//td[.='"+firstName+"']/../td[3]";
        WebElement johnEmail = driver.findElement(By.xpath(xpath));
        System.out.println(johnEmail.getText());
    }

    private int getNumberOfRow() {
        List<WebElement> table = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return table.size();
    }

    private int getNumberOfCol() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }

}
