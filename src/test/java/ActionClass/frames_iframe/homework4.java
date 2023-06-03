package ActionClass.frames_iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class homework4 {
    @Test
    public void homework4() {
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
        WebElement order=driver.findElement(By.linkText("Order"));
        order.click();
        WebElement selectProduct=driver.findElement(By.xpath("//select"));
        Select select=new Select(selectProduct);
        BrowserUtils.selectBy(selectProduct,"ScreenSaver","text");
        WebElement quantity=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("5");
        WebElement customerName=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");
        WebElement City=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        City.sendKeys("Des Plaines");
        WebElement state=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("illinois");
        WebElement zip=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys("60018");
        WebElement cardType=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
        cardType.click();
        WebElement cardNumber=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");
        WebElement expirationDate=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("03/24");
        WebElement processButton=driver.findElement(By.linkText("Process"));
        processButton.click();

        WebElement text=driver.findElement(By.tagName("strong"));
        Assert.assertTrue(text.isDisplayed(),"is displayed");
        WebElement viewAllOrders=driver.findElement(By.linkText("View all orders"));
        viewAllOrders.click();
        List<WebElement> allNewOrders =driver.findElements(By.xpath("//tr//td"));
        List<String> actual=new ArrayList<>();
        List<String> expected= Arrays.asList("CodeFish IT School","ScreenSaver","5","06/02/2023"
                ,"2200 E devon","Des Plaines","illinois","60018","MasterCard","444993876233","02/07");
        for ( WebElement newOrder:allNewOrders){
            actual.add(newOrder.getText());

        }
        Assert.assertEquals(actual,expected);

















    }
}