package com.cybertek.utilities;

public class Verify {
    public static Verify verifyResult(String expected, String actual){
        if (expected.equals(actual)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        return null;
    }
}
