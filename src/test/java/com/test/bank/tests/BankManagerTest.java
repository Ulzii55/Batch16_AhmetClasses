package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest extends BankTestBase {
    @Test
    public void validateAddCustomerFunctionality() throws InterruptedException {


        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Ulzii", "Ganbat",
                "60123", "Customer added successfully with customer id");
    }

    @Test
    public void validateOpenAccountFunctionality() throws InterruptedException {

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Ulzii", "Ganbat",
                "60123", "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver, "Ulzii Ganbat", "Dollar",
                "Account created successfully with account Number");


    }

    @Test
    public void validateCustomerFunctionality() throws InterruptedException {

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Ulzii", "Ganbat",
                "60123", "Customer added successfully with customer id");
        Thread.sleep(2000);
        bankManagerPage.OpenAccountFunctionality(driver, "Ulzii Ganbat", "Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customersButtonFunctionality("Ulzii", "Ganbat", "60123");

    }


}
