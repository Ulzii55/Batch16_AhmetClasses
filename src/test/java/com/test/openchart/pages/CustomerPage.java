package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
    public CustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//i[@class='fas fa-plus']")
    WebElement addCustomer;
    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstName;
    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastName;
    @FindBy(xpath = "//input[@name='email']")
    WebElement email;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//input[@name='confirm']")
    WebElement confirmPassword;
    @FindBy(css = "#input-newsletter")
    WebElement newsLetterButton;
    @FindBy(css = "#input-safe")
    WebElement safeButton;
    @FindBy(xpath = "//i[@class='fas fa-save']")
    WebElement customerSaveButton;
    @FindBy(xpath = "div[@id='alert']")
    WebElement warningMessage;

    public void customerAddFunctionality(String firstName,String lastName,String email,
                                         String password,String confirmPassword) throws InterruptedException {
        addCustomer.click();
        Thread.sleep(500);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        Thread.sleep(500);
        this.newsLetterButton.click();
        Thread.sleep(500);
        this.safeButton.click();
        Thread.sleep(500);
        this.customerSaveButton.click();
    }

    public String validateWarningmessage(){
        return BrowserUtils.getText(warningMessage);
    }














}



















