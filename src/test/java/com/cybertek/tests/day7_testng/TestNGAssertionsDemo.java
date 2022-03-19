package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","title");
        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");
    }
}
