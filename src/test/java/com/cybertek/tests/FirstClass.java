package com.cybertek.tests;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class FirstClass {
    public static void main(String[] args) {

        Faker faker = new Faker(); // Creating dummy data. Create fake name.

        System.out.println(faker.name().fullName());
        System.out.println(faker.harryPotter().character());
        System.out.println(faker.address().cityName());
        System.out.println(faker.finance().creditCard(CreditCardType.MASTERCARD));
    }
}
