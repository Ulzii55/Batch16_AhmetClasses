package com.test.SpruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SeafoodPage {
    public SeafoodPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@aria-label='Search Input']")
    WebElement searchBar;
    //@FindBy(xpath = "//button[@id='button_1-0']")
    //WebElement searchBTN;
    @FindBy(xpath = "//div[@id='facet_starRating_score']//li[1]")
    WebElement fourStarCheckBox;
    @FindBy(xpath = "//label[@for='pop_search_editor']")
    WebElement editorCheckBox;
    @FindBy(xpath = "//span[contains(text(),'6-Ingredient Roasted Salmon Fillets')]")
    WebElement text;

    public void validateFoodChoice(WebDriver driver, String foodName, String expectedText)
            throws InterruptedException {
        Thread.sleep(2000);
        BrowserUtils.scrollWithJS(driver, searchBar);
        Thread.sleep(2000);
        searchBar.sendKeys(foodName);
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        if (editorCheckBox.isDisplayed()&&editorCheckBox.isEnabled()&&!editorCheckBox.isSelected()){
            editorCheckBox.click();
        }
        Thread.sleep(3000);
        editorCheckBox.click();
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(text), expectedText);
        Thread.sleep(2000);
        driver.quit();
    }
}









