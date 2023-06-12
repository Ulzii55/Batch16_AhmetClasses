package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@id='itemc']")
    List<WebElement> lists;

    public void clickLaptop(String option) {
        for (WebElement list : lists) {
            if (list.getText().contains(option)) {
                list.click();
                break;

            }
        }
    }


}
