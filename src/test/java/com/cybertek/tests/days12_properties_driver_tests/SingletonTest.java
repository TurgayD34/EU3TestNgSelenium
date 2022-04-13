package com.cybertek.tests.days12_properties_driver_tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    //@Test
    public void singletonTest(){
        String s1 = Singleton.getIntance();
        String s2 = Singleton.getIntance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = Driver.get();
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        driver.get("https://facebook.com");


        Driver.closeDriver();
    }
    @Test
    public void tet3() throws InterruptedException {
        WebDriver driver = Driver.get();
        Thread.sleep(2000);
        driver.get("https://amazon.com");

        Driver.closeDriver();
    }

}
