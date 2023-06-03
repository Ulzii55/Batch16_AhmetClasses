package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {
    @Test
    public void practiceMultipleWindows() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

        String mainPage = driver.getWindowHandle();
        Set<String> allPages = driver.getWindowHandles();
        for (String id : allPages) {
            if (!id.equals(mainPage)) {
                driver.switchTo().window(id);
                break;
            }
        }
        BrowserUtils.switchByTitle(driver, "Contact us");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver,"Kickstart");
        System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver,"Courses");
        System.out.println(driver.getTitle());


    }
    @Test
    public void RealTask(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button4= driver.findElement(By.xpath("//button[@id='newTabsBtn']"));
        BrowserUtils.scrollWithJS(driver,button4);
        button4.click();
        BrowserUtils.switchByTitle(driver,"Basic");
        WebElement firstName= driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.sendKeys("Ulzii");
        WebElement lastName= driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.sendKeys("Ganbat");
        WebElement gender= driver.findElement(By.xpath("//input[@id='malerb']"));
        gender.click();
        WebElement language=driver.findElement(By.xpath("//input[@id='englishchbx']"));
        language.click();
        WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("Ulzii@gmail.com");
        WebElement passWord=driver.findElement(By.xpath("//input[@id='password']"));
        passWord.sendKeys("Ulzii1234");

        WebElement register=driver.findElement(By.xpath("//button[@id='registerbtn']"));
        BrowserUtils.scrollWithJS(driver,register);
        register.click();
        WebElement registrationSuccessfulMSG=driver.findElement(By.xpath("//label[@id='msg']"));
        String actualText=BrowserUtils.getText(registrationSuccessfulMSG);
        String expectedText="Registration is Successful";
        Assert.assertEquals(actualText,expectedText);

        BrowserUtils.switchByTitle(driver,"Window Handles");
        WebElement firstHeader=driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualHeader=BrowserUtils.getText(firstHeader);
        String expectedHeader="Window Handles Practice";
        Assert.assertEquals(actualHeader,expectedHeader);
        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        WebElement promptBox=driver.findElement(By.cssSelector("#promptBox"));
        promptBox.click();
        driver.quit();















    }

}
