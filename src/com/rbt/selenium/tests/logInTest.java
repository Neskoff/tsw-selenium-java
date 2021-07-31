package com.rbt.selenium.tests;

import com.rbt.utils.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class logInTest implements Constants {
    private WebDriver driver;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty(SELENIUM_DRIVER_ID,SELENIUM_DRIVER_ROOT);
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        Map<String, Object> vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void logInTestFunction() {
        driver.get(WEBSITE_LOGIN);
        driver.manage().window().setSize(new Dimension(1440, 804));
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("neskoff@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("031463018s");
        driver.findElement(By.name("login")).click();
        Assert.assertEquals(driver.getCurrentUrl(), WEBSITE_ROOT);
    }
}
