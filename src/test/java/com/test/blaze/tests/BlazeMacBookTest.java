package com.test.blaze.tests;

import com.test.blaze.pages.HomePage;
import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookProPage;
import org.testng.annotations.Test;

public class BlazeMacBookTest extends BlazeTestBase{
    @Test
     public void homePage() throws InterruptedException {
         HomePage homePage=new HomePage(driver);
         homePage.clickLaptop("Laptops");
         LaptopPage laptopPage=new LaptopPage(driver);
         laptopPage.chooseLaptopBrands("MacBook Pro");
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.macbookProInformation("MacBook Pro",
                "$1100 *includes tax",
                "Product description\n" +
                        "Apple has introduced three new versions of its MacBook Pro line, including a " +
                        "13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that " +
                        "sits above the MacBook Pro's keyboard.");

        macBookProPage.clickAddToCartButton(driver,"Product added");

    }


}
