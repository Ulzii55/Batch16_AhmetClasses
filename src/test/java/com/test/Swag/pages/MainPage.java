package com.test.Swag.pages;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inventory_item_name")
    List<WebElement> allItems;

    @FindBy(xpath = "inventory_details_name large_size")
    WebElement header;

    @FindBy(css = ".inventory_details_price")
    WebElement price;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    WebElement productDetails;
    @FindBy(css = "#user-name")
    WebElement userName;
    @FindBy(css = "#password")
    WebElement passWord;
    @FindBy(css = "#login-button")
    WebElement loginButton;

    public void clickProduct(String Item) {
        for (WebElement item : allItems) {
            if (BrowserUtils.getText(item).equals(Item)) {
                item.click();
                break;

            }
        }
    }

    public void loginSuccessfully() {
      userName.sendKeys(ConfigReader.readProperty("QA_swag_userName"));
      passWord.sendKeys(ConfigReader.readProperty("QA_swag_password"));
      loginButton.click();
    }

    public void validateProductDetails(String Item,String Header, String ProductDetails, String Price) {
        Assert.assertEquals(BrowserUtils.getText(header), Header);
        Assert.assertEquals(BrowserUtils.getText(price), Price);
        Assert.assertTrue(BrowserUtils.getText(productDetails).contains(ProductDetails));


    }


}
