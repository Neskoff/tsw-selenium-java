package com.rbt.selenium.tests;

import com.rbt.selenium.constants.User_Constants;
import com.rbt.selenium.constants.Website_Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

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
        Assert.assertEquals(driver.getCurrentUrl(), WEBSITE_ROOT);
    }
}
