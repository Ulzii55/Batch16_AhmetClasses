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
        mainPage.clickCloseButton();
        mainPage.clickCustomerMenuButton();
        mainPage.clickCustomerButton();


        CustomerPage customerPage=new CustomerPage(driver);
        customerPage.customerAddFunctionality("ulzii","ganbat","ulzii@gmail.com",
                "ulzii1234","ulzii1234");
              Assert.assertEquals(customerPage.validateWarningmessage(),
                      "Warning: You do not have permission to modify customers!");
    }
}
