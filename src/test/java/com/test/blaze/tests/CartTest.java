package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.annotations.Test;

public class CartTest extends BlazeTestBase {

    @Test
    public void cartPage() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        homePage.clickLaptop("Laptops");
        LaptopPage laptopPage=new LaptopPage(driver);
        laptopPage.chooseLaptopBrands("MacBook Pro");
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.clickAddToCartButton(driver,"Product added");
        CartPage cartPage=new CartPage(driver);
        cartPage.clickCartbutton();
        PlaceOrderPage placeOrderPage=new PlaceOrderPage(driver);
        placeOrderPage.placeOrderFunctionality("Ulzii","Mongolia","UlanBator",
                "127841`98274`9812476","12",
                "2023","Thank you for your purchase!");



    }
}
