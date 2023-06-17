package com.test.Swag.tests;

import com.beust.ah.A;
import com.test.Swag.pages.SwagloginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends SwagTestBase {
    @Test(dataProvider = "loginPositiveData",dataProviderClass = SwagDataProvider.class)
    public void PositiveloginPage(String userName,String password,String url){
        SwagloginPage swagloginPage=new SwagloginPage(driver);
        swagloginPage.LoginFunctionality(userName,password);
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    @Test(dataProvider = "loginNegativeData",dataProviderClass = SwagDataProvider.class)
    public void validateNegativelogin(String userName,String password,String expectedMessage){
        SwagloginPage swagloginPage=new SwagloginPage(driver);
        swagloginPage.LoginFunctionality(userName,password);
        Assert.assertEquals(swagloginPage.errorMessage(),expectedMessage);
    }



}
