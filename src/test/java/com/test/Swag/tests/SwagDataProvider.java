package com.test.Swag.tests;

import org.testng.annotations.DataProvider;

public class SwagDataProvider {
    @DataProvider(name = "loginPositiveData")
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "https://www.saucedemo.com/"},
                {"problem_user", "secret_sauce", "https://www.saucedemo.com/"},
                {"performance_glitch_user", "secret_sauce", "https://www.saucedemo.com/"}
        };
    }

    @DataProvider(name = "loginNegativeData")
    public Object[][] getDataNegtive() {
        return new Object[][]{
                {"wrongUserName", "wrongPassword", "Epic sadface: Username and password do not match any user in this service"},
                {"", "WRONG", "Epic sadface: Username is required"},
                {"performance_glitch_user", "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},

        };
    }

    @DataProvider(name = "validateProduct")
    public Object[][] getProductInfo() {
        return new Object[][]{
                {"Sauce Labs Backpack","Sauce Labs Backpack","Sly Pack ","$29.99"},
                {"Sauce Labs Bolt T-Shirt","Sauce Labs Bolt T-Shirt","Sauce Labs bolt","$15.99"},
                {"Sauce Labs Onesie","infant onesie","Sauce Labs Onesie","infant onesie","$7.99"},
                {"Sauce Labs Bike Light","Sauce Labs Bike Light","Water-resistant with 3 lighting modes","$9.99"},
                {"Sauce Labs Fleece Jacket","Sauce Labs Fleece Jacket","zip fleece jacket","$49.99"},
                {"Test.allTheThings() T-Shirt (Red)","Test.allTheThings() T-Shirt (Red)","Super-soft and comfy","$15.99"},



        };
    }
}
