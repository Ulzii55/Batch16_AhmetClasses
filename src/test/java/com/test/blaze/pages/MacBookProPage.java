package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MacBookProPage {
    public MacBookProPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    WebElement header;
    @FindBy(tagName = "h3")
    WebElement price;
    @FindBy(xpath = "//div[@id='myTabContent']")
    WebElement description;
    @FindBy(linkText = "Add to cart")
    WebElement addToCartButton;

    public void macbookProInformation(String expectedHeader, String expectedPrice, String expectedDescription) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(price), expectedPrice);
        Assert.assertEquals(BrowserUtils.getText(description), expectedDescription);

    }

    public void clickAddToCartButton(WebDriver driver,String expectedAlewrtMessage) throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedAlewrtMessage);
        alert.accept();

    }


}
