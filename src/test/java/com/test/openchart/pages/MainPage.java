package com.test.openchart.pages;

import com.test.openchart.tests.OpenChartTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-bs-dismiss='modal']")
    WebElement closeButton;
    @FindBy(css = "#menu-customer")
    WebElement customerMenuButton;
    @FindBy(xpath = "//a[.='Customers']")
    WebElement customerButton;



    public void clickCloseButton() throws InterruptedException {
        closeButton.click();
        Thread.sleep(2000);

    }

    public void clickCustomerMenuButton() {
        customerMenuButton.click();
    }

    public void clickCustomerButton() {
        customerButton.click();
    }
}



