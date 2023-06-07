package SoftAssertClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Practice {
    @Test
    public void practice1(){


        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");
        WebElement alertBox=driver.findElement(By.xpath("//button[contains(@onclick,'alertFunction')]"));
        alertBox.click();
        Alert alert=driver.switchTo().alert();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(alert.getText().trim(),"I am alert box!");
       // System.out.println(alert.getText());
        alert.accept();
        WebElement messageAlertBox=driver.findElement(By.cssSelector("#output"));
        System.out.println(BrowserUtils.getText(messageAlertBox));
        WebElement confirmBox=driver.findElement(By.cssSelector("#confirmBox"));
        confirmBox.click();


        alert.dismiss();
        System.out.println(BrowserUtils.getText(messageAlertBox));
        WebElement promptBox=driver.findElement(By.cssSelector("#promptBox"));
        promptBox.click();
        alert.sendKeys("Ahmet");
        alert.accept();
        String actualTextPrompt=BrowserUtils.getText(messageAlertBox);
        String expectedTextPrompt="You entered text Ahmet in propmt popup";//there is a bug here
        Assert.assertEquals(actualTextPrompt,expectedTextPrompt);
        softAssert.assertAll();
    }
}
