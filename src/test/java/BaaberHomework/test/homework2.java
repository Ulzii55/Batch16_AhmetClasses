package BaaberHomework.test;

import Utils.BrowserUtils;
import com.test.bank.tests.BankLoginTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class homework2 {
    @Test
    public void Homwork2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://codefish.ninja/openmrs/login.htm");

        WebElement userName= driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passWord= driver.findElement(By.xpath("//input[@name='password']"));
        userName.sendKeys("admin");
        passWord.sendKeys("Admin123");
        WebElement labLocation=driver.findElement(By.cssSelector("#Laboratory"));
        WebElement loginButton=driver.findElement(By.cssSelector("#loginButton"));
        labLocation.click();
        loginButton.click();
        WebElement location=driver.findElement(By.xpath("//span[@id='selected-location']"));
        String actualLocation=BrowserUtils.getText(location);
        Assert.assertTrue(actualLocation.contains("Laboratory"));
        WebElement title=driver.findElement(By.tagName("h4"));
        String actualText= BrowserUtils.getText(title);
        String expectedText="Logged in as Super User (admin) at Laboratory.";
        Assert.assertEquals(actualText,expectedText);
        Actions actions=new Actions(driver);
        WebElement dropDown=driver.findElement(By.xpath("//li[@class='change-location']"));
        dropDown.click();
        WebElement pharmacy=driver.findElement(By.xpath("//li[.='Pharmacy']"));
        actions.click(dropDown).perform();
        actions.moveToElement(pharmacy).click().perform();
        WebElement openMRSLogo=driver.findElement(By.xpath("//a//img"));
        openMRSLogo.click();
        WebElement header=driver.findElement(By.xpath("//a//img"));
        String actualHeader= BrowserUtils.getText(header);
        String expectedHeader="Logged in as Super User (admin) at Pharmacy.";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement newLocation=driver.findElement(By.xpath("//span[.='Pharmacy']"));
        Assert.assertTrue(BrowserUtils.getText(newLocation).contains("Pharmacy"));
        WebElement findPatientsRecord=driver.findElement(By.xpath("//i[@class='icon-search']"));
        findPatientsRecord.click();
        List<WebElement> allPatients=driver.findElements(By.tagName("td"));

        for (WebElement patient:allPatients){
            Assert.assertTrue(BrowserUtils.getText(patient).contains("John johns"));
            Assert.assertTrue(BrowserUtils.getText(patient).contains("1015N8 "));
        }






    }
}