package com.test.openchart.tests;

import com.test.openchart.pages.MainPage;
import com.test.openchart.pages.OpenChartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest extends OpenChartTestBase {
    @Test

    public void happyPathLogin() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage = new OpenChartLoginPage(driver);
        openChartLoginPage.loginFunctionality("demo", "demo");
        Assert.assertEquals(driver.getTitle().trim(), "Dashboard");


    }

    @Test
    public void validateNegativeLogin() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
        openChartLoginPage.loginFunctionality("wrongusername","wrongpassword");
        Assert.assertEquals(openChartLoginPage.errorMessage(),"No match for Username and/or Password.");
    }

}





