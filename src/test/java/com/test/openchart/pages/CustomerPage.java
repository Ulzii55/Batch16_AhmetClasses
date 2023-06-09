package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
    @FindBy(xpath = "//button[@aria-label='Save']")  //button[@aria-label='Save']
    WebElement customerSaveButton;
    @FindBy(css = ".alert")
    WebElement warningMessage;

    public void customerAddFunctionality(WebDriver driver,String firstName, String lastName, String email,
                                         String password, String confirmPassword) throws InterruptedException {
        addCustomer.click();
        Thread.sleep(500);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        BrowserUtils.scrollWithJS(driver,newsLetterButton);
        BrowserUtils.clickWithJS(driver,newsLetterButton);
        BrowserUtils.clickWithJS(driver,safeButton);
        customerSaveButton.click();
        Assert.assertEquals(BrowserUtils.getText(warningMessage),"Warning: You do not have permission to modify customers!");


   }


}



















