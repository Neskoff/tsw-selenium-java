package com.rbt.selenium.tests;

import com.rbt.selenium.constants.User_Constants;
import com.rbt.selenium.constants.Website_Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class registerDetailsTest implements Website_Constants, User_Constants {
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
    public void registerDetailsFunction() {
        driver.get(WEBSITE_LOGIN);
        driver.manage().window().setSize(new Dimension(1440, 804));
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys(EMAIL);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.name("login")).click();
        driver.get(WEBSITE_USER_DETAILS);
        driver.manage().window().setSize(new Dimension(1440, 804));
        boolean accountNameCompare = driver.findElement(By.id("account_display_name"))
                .getAttribute("value").equals(USERNAME);
        boolean emailCompare = driver.findElement(By.id("account_email")).getAttribute("value").equals(EMAIL);
        boolean result = accountNameCompare && emailCompare;
        Assert.assertTrue(result);
    }
}
