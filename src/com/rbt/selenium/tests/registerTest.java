package com.rbt.selenium.tests;

import com.rbt.selenium.constants.User_Constants;
import com.rbt.selenium.constants.Website_Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class registerTest implements Website_Constants, User_Constants {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty(SELENIUM_DRIVER_ID,SELENIUM_DRIVER_ROOT);
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    /*NOTE:Before running this test please change the USERNAME, EMAIL and PASSWORD
    In the User_Constants Interface, otherwise the test will fail because the user
    is already registered.
     */
    @Test
    public void registerTestFunction() {
        driver.get(WEBSITE_REGISTER);
        driver.manage().window().setSize(new Dimension(1440, 804));
        driver.findElement(By.id("reg_username")).click();
        driver.findElement(By.id("reg_username")).sendKeys(USERNAME);
        driver.findElement(By.id("reg_email")).click();
        driver.findElement(By.id("reg_email")).sendKeys(EMAIL);
        driver.findElement(By.id("reg_password")).click();
        driver.findElement(By.id("reg_password")).sendKeys(PASSWORD);
        driver.findElement(By.name("register")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(WEBSITE_ROOT, driver.getCurrentUrl());
    }
}
