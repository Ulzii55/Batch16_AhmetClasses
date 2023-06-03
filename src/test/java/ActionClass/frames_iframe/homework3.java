package ActionClass.frames_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class homework3 {
    @Test
    public void homework3() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement passWord= driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("test");
        WebElement login=driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        WebElement viewAllOrders=driver.findElement(By.linkText("View all orders"));
        WebElement viewAllProducts=driver.findElement(By.linkText("View all products"));
        WebElement orders=driver.findElement(By.linkText("Order"));
        Assert.assertEquals(viewAllOrders.getAttribute("href"),"Default.aspx");
        Assert.assertEquals(viewAllProducts.getAttribute("href"),"Products.aspx");
        Assert.assertEquals(orders.getAttribute("href"),"Process.aspx");











    }
}