package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class seleniumHomework2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();

        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test ='error']"));
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualMessage = errorMessage.getText().trim();
        System.out.println(actualMessage.equals(expectedMessage) ? "PASSED" : "FAILED");


    }
}
