package com.test.bank.tests;

import Utils.ConfigReader;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest extends BankTestBase {
    @Test
    public void validateAddCustomerFunctionality() throws InterruptedException {


        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,
                ConfigReader.readProperty("QA_FirstName"),
                ConfigReader.readProperty("QA_LastName"),
                ConfigReader.readProperty("QA_PostCode"),
                ConfigReader.readProperty("QA_Message"));
    }

    @Parameters({"firstName", "lastName", "postCode", "expectedMessage", "name",
            "currency", "expectedMessage"})
    @Test
    public void validateOpenAccountFunctionality(String firstName, String lastName, String postCode,
                                                 String expectedMessage1, String name,
                                                 String currency, String expectedMessage2)
            throws InterruptedException {

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, firstName, lastName,
                postCode, expectedMessage1);
        bankManagerPage.OpenAccountFunctionality(driver, name, currency,
                expectedMessage2);


    }

    @Parameters({"firstName", "lastName", "postCode", "expectedMessage", "name", "currency", "expectedMessage",
            "customerName", "lastName", "postCode"})
    @Test
    public void validateCustomerFunctionality(String firstname, String lastName, String postCode,
                                              String expectedMessage1, String name,
                                              String currency, String expectedMessage2,
                                              String LastName, String PostCode) throws InterruptedException {

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, firstname, lastName,
                postCode, expectedMessage1);
        Thread.sleep(2000);
        bankManagerPage.OpenAccountFunctionality(driver, name, currency,
                expectedMessage2);
        bankManagerPage.customersButtonFunctionality(firstname, lastName, PostCode);

    }


}
