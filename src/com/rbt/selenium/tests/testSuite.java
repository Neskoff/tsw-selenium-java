package com.rbt.selenium.tests;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({registerTest.class, logInTest.class, registerDetailsTest.class, addItemsTest.class,
itemSumTest.class})

public class testSuite {
    @BeforeClass
    public static void printMe() {
        System.out.println("Test Suite is running...");
    }
}