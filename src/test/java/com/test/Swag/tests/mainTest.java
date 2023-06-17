package com.test.Swag.tests;

import com.test.Swag.pages.MainPage;
import org.testng.annotations.Test;

public class mainTest extends SwagTestBase {
    @Test(dataProvider = "validateProduct",dataProviderClass = SwagDataProvider.class)
    public void validateProduct(String item,String header,String description,String price){
        MainPage mainPage=new MainPage(driver);
        mainPage.loginSuccessfully();
        mainPage.clickProduct(item);
        mainPage.validateProductDetails(header,description,price);
    }

}
