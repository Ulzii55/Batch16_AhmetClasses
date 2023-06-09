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
import org.testng.annotations.Test;

import java.time.Duration;


@Test
public class customerPageTest extends BankTestBase{

 @Test
    public void testCustomerScenario() throws InterruptedException {

        BankLoginPage loginPage = new BankLoginPage(driver);
        CustomerPage customerPage = new CustomerPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        CustomerTransactionPage customerTransactionPage=new CustomerTransactionPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Ulzii", "Ganbat"
                , "60123", "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver, "Ulzii Ganbat", "Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customersButtonFunctionality("Ulzii", "Ganbat", "60123");

        customerPage.clickHomeButton();
        customerPage.clickCustomerLogin();
        customerPage.testCustomerLogin("Ulzii Ganbat");
        customerPage.validateWelcomeMSG("Welcome Ulzii Ganbat !!");
        customerPage.clickDepositButton("500");
        customerPage.validateDepositeSuccessfulMsg("Deposit Successful");
        customerPage.clickWithdrawButton("300");
        customerPage.validateTransactionMSG("Transaction successful");
        Thread.sleep(2000);
        customerPage.remainingBalance();
        customerPage.clickTransactionButton();
        customerTransactionPage.validatingTotalBalance("500","300","200");
        driver.quit();



    }
}