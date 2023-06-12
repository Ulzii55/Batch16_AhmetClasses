package com.test.SpruceEats.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    public Homepage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredients;
    @FindBy(xpath = "//a[contains(text(),'Fish & Seafood')]")
    WebElement fishAndSeaFood;


    public void chooseOption(WebDriver driver){
        Actions actions=new Actions(driver);
        actions.moveToElement(ingredients).perform();
        actions.click(fishAndSeaFood).perform();

    }
}
