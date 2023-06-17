package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.CustomerPage;
import com.test.bank.pages.CustomerTransactionPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;


@Test
public class customerPageTest extends BankTestBase {
    @Parameters({"firstName", "lastName", "postCode", "expectedMessage", "name," +
            "currency", "expectedMessage", "customerName", "lastName", "postCode",
            "firstName", "expectedMessage", "depositAmount",
            "expectedMessage", "withdraw", "transactionMSG", "depositAmount", "withdraw", "balance"})

    @Test
    public void testCustomerScenario(String firstName, String lastName1, String postCode1, String expectedMessage1,
                                     String name, String currency, String expectedMessage2,
                                     String customerName1, String lastName2, String postCode2,
                                     String firstName2, String expectedMessage3, String depositAmount,
                                     String expectedMessage4, String withdraw, String transactionMSG,
                                     String depositAmount1, String withdraw1, String balance) throws InterruptedException {

        BankLoginPage loginPage = new BankLoginPage(driver);
        CustomerPage customerPage = new CustomerPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        CustomerTransactionPage customerTransactionPage = new CustomerTransactionPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, firstName, lastName1
                , postCode1, expectedMessage1);
        bankManagerPage.OpenAccountFunctionality(driver, name, currency,
                expectedMessage2);
        bankManagerPage.customersButtonFunctionality(customerName1, lastName2, postCode2);

        customerPage.clickHomeButton();
        customerPage.clickCustomerLogin();
        customerPage.testCustomerLogin(firstName2);
        customerPage.validateWelcomeMSG(expectedMessage2);
        customerPage.clickDepositButton(depositAmount);
        customerPage.validateDepositeSuccessfulMsg(expectedMessage3);
        customerPage.clickWithdrawButton(withdraw);
        customerPage.validateTransactionMSG(expectedMessage4);
        Thread.sleep(2000);
        customerPage.remainingBalance();
        customerPage.clickTransactionButton();
        customerTransactionPage.validatingTotalBalance(depositAmount1, withdraw1, balance);
        driver.quit();


    }
}