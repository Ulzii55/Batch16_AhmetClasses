package TestNG;

import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.readProperty("QA_url"));

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys(ConfigReader.readProperty("QA_opencart_username"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys(ConfigReader.readProperty("QA_opencart_password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);


    }

    @Test
    public void negativeLoginTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("Demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement AlertMsg = driver.findElement(By.cssSelector("#alert"));
        String actualMsg = AlertMsg.getText().trim();
        String expectedMsg = "No match for Username and/or Password.";
        Assert.assertEquals(actualMsg, expectedMsg);


    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement XButton = driver.findElement(By.cssSelector(".btn-close"));
        XButton.click();
        Thread.sleep(2000);
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productButton.isDisplayed());
        Assert.assertTrue(productButton.isEnabled());
    }

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement XButton = driver.findElement(By.cssSelector(".btn-close"));
        XButton.click();
        Thread.sleep(2000);
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i = 1; i < allBoxes.size(); i++) {
            Thread.sleep(2000);
            Assert.assertTrue(allBoxes.get(i).isDisplayed());
            Assert.assertTrue(allBoxes.get(i).isEnabled());

            Assert.assertFalse(allBoxes.get(i).isSelected());
            allBoxes.get(i).click();
            Assert.assertTrue(allBoxes.get(i).isSelected());
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);

        }


    }

    @Test
    public void validateProductNameDescending() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement XButton = driver.findElement(By.cssSelector(".btn-close"));
        XButton.click();
        Thread.sleep(2000);
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();


        WebElement productName = driver.findElement(By.xpath("//a[@class='asc']"));
        productName.click();

        List<WebElement> elements = driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualData = new ArrayList<String>();
        List<String> expectedData = new ArrayList<String>();

        for (int i = 1; i < elements.size(); i++) {
            //actualdata.add(elements.get(i).getText().toLowerCase().trim());
            //expecdetData.add(elements.get(i).geText().ToLowerCase().trim());
            WebElement element = elements.get(i);
            String Name = element.getText().toLowerCase();
            actualData.add(Name);
            expectedData.add(Name);

        }
        Collections.sort(expectedData);
        Collections.reverse(expectedData);
        Assert.assertEquals(actualData, expectedData);

    }
}
