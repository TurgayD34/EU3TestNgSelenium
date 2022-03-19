package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class FirstTestNGTest {
    @Test
    public void test1(){
        System.out.println("My first Test Case");
    }
    @Test
    public void test2(){
        System.out.println("My second Test Case");
    }
    @Test
    public void test3(){
        System.out.println("My third Test Case");
    }
    @BeforeMethod
    public void setup(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
    }
    @BeforeClass
    public void classSetup(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void classTearDown(){
        System.out.println("After Class");
    }

}
