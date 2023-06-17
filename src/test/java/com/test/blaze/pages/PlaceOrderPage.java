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
                                        String expectedMessage) throws InterruptedException {
        Thread.sleep(1000);
        placeOrderButton.click();
        Thread.sleep(1000);

        this.name.sendKeys(name);
        Thread.sleep(1000);

        this.country.sendKeys(country);
        Thread.sleep(1000);

        this.city.sendKeys(city);
        Thread.sleep(1000);

        this.creditCard.sendKeys(creditCard);
        Thread.sleep(1000);

        this.expirationMonth.sendKeys(month);
        Thread.sleep(1000);

        this.expirationYear.sendKeys(year);
        Thread.sleep(1000);

        purchaseButton.click();
        Thread.sleep(1000);

        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);
        okButton.click();
        Thread.sleep(1000);


    }


}
