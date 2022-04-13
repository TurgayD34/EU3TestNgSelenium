package com.cybertek.tests.days12_properties_driver_tests;

public class Singleton {

    //Singleton class will have private constructor
    //It means other classes cannot create object of this class

    private Singleton(){}

    private static String str;

    public static String getIntance(){
        //If str has no value, initialize it and return it
        if (str==null){
            System.out.println("Str is null. Assign value it");
            str = "Some value";
        }else{
            //if it has value just return it
            System.out.println("It has value, just returning it");
        }
        return str;
    }
}
