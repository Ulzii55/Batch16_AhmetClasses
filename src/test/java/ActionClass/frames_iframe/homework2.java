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

public class homework2 {
    @Test
    public void homework2() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement passWord = driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        WebElement viewAllProducts = driver.findElement(By.linkText("View all products"));
        viewAllProducts.click();
        WebElement viewAllProductsSelected = driver.findElement(By.xpath("//li[@class='selected']"));
        System.out.println(viewAllProductsSelected.isSelected() ? "Selected" : "not selected");

        String actualHeader= driver.getTitle();
        String expectedHeader="List of Products";
        Assert.assertEquals(actualHeader,expectedHeader);
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("Products"), "URL contains 'Products' keyword.");




    }
}
