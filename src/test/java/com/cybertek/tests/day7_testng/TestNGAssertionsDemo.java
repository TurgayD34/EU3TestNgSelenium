package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @BeforeMethod
    public void beforeMethod(){ System.out.println("Open browser");}
    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","title");
        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");
    }
    @Test
    public void test2(){
        Assert.assertEquals("test2","test2");
    }
    @Test
    public void test3(){
        String expectedTitle = "Cyb";
        String actualTitle = "Cybertek";

        // If we use 'if' statement
//        if (actualTitle.startsWith(expectedTitle))
        // Condition will be true or false

        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "Verify title starts with Cyb");
    }
    @Test
    public void test4(){
        // Verify email contains @ sign
        String email = "john@gmail.com";
//        if (email.contains("@"))
        Assert.assertTrue(email.contains("@"), "Verify email contains @ sign");
    }
    @Test
    public void test5(){
        String email = "johngmail.com";
        Assert.assertFalse(email.contains("@"));
        // Condition is false but returns true
    }
    @Test
    public void test6(){
        Assert.assertNotEquals("Td", "td");
    }

    @AfterMethod
    public void afterMethod(){ System.out.println("Close browser"); }
}
