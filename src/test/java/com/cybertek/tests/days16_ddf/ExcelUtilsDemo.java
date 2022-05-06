package com.cybertek.tests.days16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        //Create an object from ExcelUtil
        //It accepts two arguments
        //Argument 1: Location of the file (path)
        //Argument 2: Sheet that we want to open (sheetName)

        ExcelUtil qa3Sheet = new ExcelUtil("src/test/resources/uye.xlsx", "QA3-short");

        //How many rows in the sheet
        System.out.println("qa3Sheet.rowCount() = " + qa3Sheet.rowCount());
        //How many columns in the sheet
        System.out.println("qa3Sheet.columnCount() = " + qa3Sheet.columnCount());
        //Get all column names
        System.out.println("qa3Sheet.getColumnsNames() = " + qa3Sheet.getColumnsNames());

        //Get all data in list of maps
        List<Map<String, String>> dataList = qa3Sheet.getDataList();
        for (Map<String, String> onerow : dataList) {
            System.out.println("onerow = " + onerow);
        }
        //get a name as a value
        System.out.println("dataList.get(2) = " + dataList.get(2).get("firstname"));

        //get all data in 2d array
        String [][] dataArray = qa3Sheet.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));
    }
}
