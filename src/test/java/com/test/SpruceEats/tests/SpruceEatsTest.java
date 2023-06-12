package com.test.SpruceEats.tests;

import com.test.SpruceEats.pages.Homepage;
import com.test.SpruceEats.pages.SeafoodPage;
import org.testng.annotations.Test;

public class SpruceEatsTest extends SpruceTestBase{
    @Test
    public void homePage() throws InterruptedException {
        Homepage homepage=new Homepage(driver);
        homepage.chooseOption(driver);
        SeafoodPage seafoodPage=new SeafoodPage(driver);
        seafoodPage.validateFoodChoice(driver,"Fish for dinner",
                "6-Ingredient Roasted Salmon Fillets");
    }
}
