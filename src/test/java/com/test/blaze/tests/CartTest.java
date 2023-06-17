package com.test.blaze.tests;

import Utils.ConfigReader;
import com.test.blaze.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CartTest extends BlazeTestBase {


    @Test(dataProvider = "orderData",dataProviderClass = BlazeData.class)
    public void cartPage(String category,String brand,String expectedAlertMessage,String firstName,
                         String country,String city,String cart,String month,
                         String year,String expectedMessage,String url) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickLaptop(category);
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseLaptopBrands(ConfigReader.readProperty(brand));
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.clickAddToCartButton(driver, expectedAlertMessage);
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCartbutton();
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        placeOrderPage.placeOrderFunctionality(firstName, country, city,
                cart, month,
                year, expectedMessage);
        Assert.assertEquals(driver.getCurrentUrl().trim(),url);

    }

    @Parameters({"Category", "Product", "name", "country", "city",
            "creditCard", "month", "year", "expectedMessage"})
    @Test
    public void cartPageParameter(String laptop, String product, String name,
                                  String country, String city, String creditCard,
                                  String month, String year,
                                  String expectedMessage) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickLaptop(laptop);
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseLaptopBrands(ConfigReader.readProperty("QA_Blaze_Laptop_Brand"));
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.clickAddToCartButton(driver, product);
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCartbutton();
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        placeOrderPage.placeOrderFunctionality(name, country, city,
                creditCard, month,
                year, expectedMessage);


    }
}
