package com.test.openchart.tests;

import Utils.BrowserUtils;
import com.test.openchart.pages.CustomerPage;
import com.test.openchart.pages.MainPage;
import com.test.openchart.pages.OpenChartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerPageTest extends OpenChartTestBase {

    @Test
    public void validatePermissionMessage() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage = new OpenChartLoginPage(driver);
        openChartLoginPage.loginFunctionality("demo", "demo");
        MainPage mainPage = new MainPage(driver);
        mainPage.mainPageFunctionality();

        CustomerPage customerPage=new CustomerPage(driver);
        customerPage.customerAddFunctionality(driver,"Ulzii","Ganbat","ulzii@gmail.com",
                "12345","12345");

    }
}
