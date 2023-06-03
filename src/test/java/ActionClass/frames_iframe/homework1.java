package ActionClass.frames_iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class homework1 {
    @Test
    public void homework(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle= driver.getTitle();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement passWord= driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("test");
        WebElement login=driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        String actualTitle1=driver.getTitle();
        String expectedTitle1="Web Orders";
        Assert.assertEquals(actualTitle1,expectedTitle1);
        WebElement header=driver.findElement(By.tagName("h2"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="List of All Orders";
        Assert.assertEquals(actualHeader,expectedHeader);

    }
}
