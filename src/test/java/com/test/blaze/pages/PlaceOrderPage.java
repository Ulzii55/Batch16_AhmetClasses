package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PlaceOrderPage {
    public PlaceOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;
    @FindBy(xpath = "//input[@id='name']")
    WebElement name;
    @FindBy(xpath = "//input[@id='country']")
    WebElement country;
    @FindBy(css = "#city")
    WebElement city;
    @FindBy(xpath = "//input[@id='card']")
    WebElement creditCard;
    @FindBy(xpath = "//input[@id='month']")
    WebElement expirationMonth;
    @FindBy(xpath = "//input[@id='year']")
    WebElement expirationYear;
    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;
    @FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
    WebElement message;
    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void placeOrderFunctionality(String name,String country,String city,String creditCard,String month,String year,
                                        String expectedMessage){
        placeOrderButton.click();
        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.creditCard.sendKeys(creditCard);
        this.expirationMonth.sendKeys(month);
        this.expirationYear.sendKeys(year);
        purchaseButton.click();
        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);
        okButton.click();

    }


}
