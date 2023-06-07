package com.test.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerTransactionPage {
    public CustomerTransactionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[.='500']")
    WebElement totalDepositAmount;
    @FindBy(xpath = "//td[.='300']")
    WebElement totalWithdrawAmount;

    public void validatingTotalBalance(String depositAmount,String withDrawAmount,String balance){
        int finalBalance=Integer.parseInt(depositAmount)-Integer.parseInt(withDrawAmount);
        Assert.assertEquals(finalBalance,Integer.parseInt(balance));
    }

}
