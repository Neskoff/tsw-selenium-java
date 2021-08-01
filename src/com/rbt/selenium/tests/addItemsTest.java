package com.rbt.selenium.tests;

import com.rbt.selenium.constants.User_Constants;
import com.rbt.selenium.constants.Website_Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;

public class addItemsTest implements Website_Constants, User_Constants {
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
    public void addItemsFunction() {
        ArrayList<String> itemsSKU = new ArrayList<>();
        driver.get(WEBSITE_TEST_CATEGORY_1);
        driver.manage().window().setSize(new Dimension(1440, 804));
        driver.findElements(By.className("secondary-image")).get(0).click();
        itemsSKU.add(driver.findElement(By.id("span-517-19476")).getText());
        driver.findElement(By.className("single_add_to_cart_button")).click();
        driver.get(WEBSITE_TEST_CATEGORY_2);
        driver.findElements(By.className("secondary-image")).get(0).click();
        itemsSKU.add(driver.findElement(By.id("span-517-19476")).getText());
        driver.findElement(By.className("single_add_to_cart_button")).click();
        driver.get(WEBSITE_TEST_CATEGORY_3);
        driver.findElements(By.className("secondary-image")).get(0).click();
        itemsSKU.add(driver.findElement(By.id("span-517-19476")).getText());
        driver.findElement(By.className("single_add_to_cart_button")).click();
        /* NOTE: Stupid Workaround because you can't get child elements of a pseudo class */
        boolean result = driver.getPageSource().toLowerCase().contains(itemsSKU.get(0).toLowerCase())
                &&driver.getPageSource().toLowerCase().contains(itemsSKU.get(1).toLowerCase())
                &&driver.getPageSource().toLowerCase().contains(itemsSKU.get(2).toLowerCase());
        Assert.assertTrue(result);
    }
}
