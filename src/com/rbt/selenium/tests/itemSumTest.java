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

public class itemSumTest implements Website_Constants, User_Constants {
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
    public void itemSumFunction() {
        String itemPrice;
        ArrayList<Double> itemsSKU = new ArrayList<>();
        driver.get(WEBSITE_TEST_CATEGORY_1);
        driver.manage().window().setSize(new Dimension(1440, 804));
        driver.findElements(By.className("secondary-image")).get(0).click();
        itemPrice = driver.findElements(By.className("price")).get(0).
                findElements(By.tagName("bdi")).get(1).getText();
        itemPrice = itemPrice.substring(0, itemPrice.length() - 7).replace(',','.');
        itemsSKU.add(Double.valueOf(itemPrice));
        driver.findElement(By.className("single_add_to_cart_button")).click();
        driver.get(WEBSITE_TEST_CATEGORY_2);
        driver.findElements(By.className("secondary-image")).get(0).click();
        itemPrice = driver.findElements(By.className("price")).get(0).
                findElements(By.tagName("bdi")).get(1).getText();
        itemPrice = itemPrice.substring(0, itemPrice.length() - 7).replace(',','.');
        itemsSKU.add(Double.valueOf(itemPrice));
        driver.findElement(By.className("single_add_to_cart_button")).click();
        driver.get(WEBSITE_TEST_CATEGORY_3);
        driver.findElements(By.className("secondary-image")).get(0).click();
        itemPrice = driver.findElements(By.className("price")).get(0).
                findElements(By.tagName("bdi")).get(1).getText();
        itemPrice = itemPrice.substring(0, itemPrice.length() - 7).replace(',','.');
        itemsSKU.add(Double.valueOf(itemPrice));
        driver.findElement(By.className("single_add_to_cart_button")).click();
        itemPrice = driver.findElement(By.className("oxy-woo-add-to-cart")).
                findElement(By.tagName("bdi")).getText();
        itemPrice = itemPrice.substring(0, itemPrice.length() - 4).replace(',','.');
        double finalPrice = Double.parseDouble(itemPrice);
        double actualPrice = itemsSKU.get(0) + itemsSKU.get(1) + itemsSKU.get(2);
        Assert.assertEquals(finalPrice, actualPrice, 00.00);
    }
}
