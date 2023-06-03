package AlertInterface;

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

import java.time.Duration;

public class practice {
    @Test
    public void Practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement alertBox= driver.findElement(By.cssSelector("#alertBox"));
        alertBox.click();
        Alert alert = driver.switchTo().alert();
        String actualMSG= alert.getText().trim();
        String expectedMSG="I am an alert box!";
        Assert.assertEquals(actualMSG,expectedMSG);
        alert.accept();
        WebElement confimBox= driver.findElement(By.cssSelector("#confirmBox"));
        confimBox.click();
        String actual=alert.getText().trim();
        String expected="Press a button!";
        Assert.assertEquals(actual,expected);
        alert.dismiss();

        WebElement promptBox= driver.findElement(By.cssSelector("#promptBox"));
        promptBox.click();
        alert.sendKeys("Ulzii");
        alert.accept();
        WebElement output= driver.findElement(By.cssSelector("#output"));
        String actualText= BrowserUtils.getText(output);
        String expectedtext="You entered text Ulzii in propmt popup";
        Assert.assertEquals(actualText,expectedtext);












    }
}