package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='cartur']")
    WebElement cartButton;
    @FindBy(xpath = "//td")
    List<WebElement> details;
    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;

    public void clickCartbutton(){
        cartButton.click();
    }
    public void getProductDetails(String expectedTitle, String expectedPrice) {
        List<String> expectedDetails = Arrays.asList("", expectedTitle, expectedPrice, "");
        for (int i = 1; i < details.size()- 1; i++) {
            Assert.assertEquals(BrowserUtils.getText(details.get(i)),expectedDetails.get(i));
        }
    }


}


