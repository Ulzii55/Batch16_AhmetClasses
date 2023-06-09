package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerPage {


    public CustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homeButton;
    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLogin;
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerName;
    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;
    @FindBy(xpath = "//div//strong[contains(text(),' Welcome ')]")
    WebElement welcomeMSG;
    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountToBeDeposited;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement deposit;
    @FindBy(xpath = "//span[.='Deposit Successful']")
    WebElement depositSuccessfulMessage;
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawButton;
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountToBeWithdraw;
    @FindBy(xpath = "//button[.='Withdraw']")
    WebElement withdraw;
    @FindBy(xpath = "//span[.='Transaction successful']")
    WebElement transactionSuccessfulMsg;
    @FindBy(xpath = "//strong[.='200']")   //div[@ng-hide='noAccount']//strong[2] use indexing !!!
    WebElement balance;
    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionButton;
    public void clickHomeButton() {
        homeButton.click();
    }

    public void clickCustomerLogin() {
        customerLogin.click();
    }

    public void testCustomerLogin(String firstName) {
        BrowserUtils.selectBy(customerName, firstName, "text");
        loginButton.click();
    }

    public void validateWelcomeMSG(String expectedMessage) {
        Assert.assertEquals(BrowserUtils.getText(welcomeMSG), expectedMessage);
    }

    public void clickDepositButton(String depositAmount) {
        depositButton.click();
        amountToBeDeposited.sendKeys(depositAmount);
        deposit.click();
    }

    public void validateDepositeSuccessfulMsg(String expectedMsg) {
        Assert.assertEquals(BrowserUtils.getText(depositSuccessfulMessage), expectedMsg);
    }

    public void clickWithdrawButton(String withdrawAmount) throws InterruptedException {
        withdrawButton.click();
        Thread.sleep(3000);
        amountToBeWithdraw.sendKeys(withdrawAmount);
        withdraw.click();
    }
    public void validateTransactionMSG(String expectedMSG){
        Assert.assertEquals(BrowserUtils.getText(transactionSuccessfulMsg),expectedMSG);
    }
    public void clickTransactionButton(){
        transactionButton.click();
    }
    public void remainingBalance(){
        balance.getText();
    }


}
