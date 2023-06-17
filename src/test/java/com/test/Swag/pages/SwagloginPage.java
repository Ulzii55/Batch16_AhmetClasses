package com.test.Swag.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagloginPage {

    public SwagloginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "#user-name")
    WebElement userName;
    @FindBy(css = "#password")
    WebElement passWord;
    @FindBy (css = "#login-button")
    WebElement loginButton;
    @FindBy(tagName = "h3")
    WebElement errorMessage;


      public void LoginFunctionality(String name,String password){
          this.userName.sendKeys(name);
          this.passWord.sendKeys(password);
          loginButton.click();

      }
      public String errorMessage(){
          return BrowserUtils.getText(errorMessage);
      }


}

