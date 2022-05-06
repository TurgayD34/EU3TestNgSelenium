package com.cybertek.tests.days16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    @DataProvider
    public Object [][] testData(){

        String [][] data = {
                {"Person of Interest", "10"},
                {"Sherlock", "9"},
                {"Breaking Bad","8"},
                {"The Office","7"},
                {"Friends", "6"},
                {"West World", "10"},
        };
        return data;
    }
    @Test(dataProvider = "testData")
    public void test1(String tvshow, String rating){
        System.out.println("Tv show: "+tvshow+" has rating "+rating);
    }
}
