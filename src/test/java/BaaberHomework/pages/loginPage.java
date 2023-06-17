package BaaberHomework.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginPage {
    @Test
    public void Homwork() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://codefish-io-qa.s3-website-ap-northeast-1.amazonaws.com/");

        WebElement userName= driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passWord= driver.findElement(By.xpath("//input[@name='password']"));
        WebElement register=driver.findElement(By.xpath("//button[@name='regbtn']"));
        userName.clear();
        userName.sendKeys("ulzii555");
        passWord.clear();
        passWord.sendKeys("12345");
        Thread.sleep(2000);
        register.click();

















    }
}
