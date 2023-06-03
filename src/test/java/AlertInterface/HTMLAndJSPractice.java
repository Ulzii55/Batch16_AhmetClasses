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

public class HTMLAndJSPractice {
    @Test
    public void practiceBoth() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");

        WebElement preview1 = driver.findElement(By.xpath("//button[contains(@onclick,'something went wrong')]"));
        preview1.click();
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText().trim();
        String expectedText = "Oops, something went wrong!";
        alert.accept();

        WebElement preview2 = driver.findElement(By.xpath("//button[contains(@onclick,'Something went wrong')]"));
        preview2.click();

        WebElement alertBox = driver.findElement(By.xpath("//div[@class='swal-modal']"));
        System.out.println(BrowserUtils.getText(alertBox));
        String actual = BrowserUtils.getText(alertBox);
        String expected = "Something went wrong!";
        Assert.assertTrue(actual.contains(expected));
        WebElement okButton = driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();


    }
}
