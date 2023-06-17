package com.test.blaze.tests;

import com.test.blaze.pages.HomePage;
import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookProPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BlazeMacBookTest extends BlazeTestBase {
    @Parameters({"Product", "MacBook", "expectedHeader", "expectedPrice", "expectedDescription",
            "expectedAlertmsg"})
    @Test
    public void homePage(String product, String MacBook, String expectedHeader, String expectedPrice,
                         String expectedDescription, String expectedAlertMsg) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickLaptop(product);
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseLaptopBrands(MacBook);
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.macbookProInformation(expectedHeader,
                expectedPrice, expectedDescription);

        macBookProPage.clickAddToCartButton(driver, expectedAlertMsg);

    }


}
