package JavaScriptExecutorClass;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSPractice {
    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/radio-button");

        WebElement yes = driver.findElement(By.xpath("//label[.='Yes']"));
        yes.click();
        WebElement header = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "You have selected Yes";
        Assert.assertEquals(actualHeader, expectedHeader);

        WebElement impressive = driver.findElement(By.xpath("//label[@class='custom-control-label']"));
        Assert.assertTrue(!impressive.isSelected());
        impressive.click();

        WebElement header2 = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actualHeader2 = BrowserUtils.getText(header2);
        String expectedHeader2 = "You have selected Impressive";
        Assert.assertEquals(actualHeader2, expectedHeader2);


    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement findOutCourse = driver.findElement(By.xpath("//span[contains(text(),'which course')]//.."));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", findOutCourse);
        Thread.sleep(2000);
        findOutCourse.click();


    }

    @Test
    public void practice3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement copyRight = driver.findElement(By.xpath("//div[@id='el_1666192783854_462']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", copyRight);
        Thread.sleep(2000);

        String actualMSG = BrowserUtils.getText(copyRight);
        String expectedMSG = "Copyright © 2023";

        WebElement applyNow = driver.findElement(By.xpath("//span[contains(text(),'Apply Now')]"));
        js.executeScript("arguments[0].scrollIntoView(true)", applyNow);
        js.executeScript("arguments[0].click(true)", applyNow);

        String actualText = BrowserUtils.getText(applyNow);
        String expectedText = "Apply Now";
        Assert.assertEquals(actualText, expectedText);

        List<WebElement> elements = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));

        //List<String> actualList = new ArrayList<>();
        List<String> expectedList = Arrays.asList("info@techtorialacademy.com", "+ 1 (224) 570 91 91", "Chicago & Houston");

        for (int i = 0; i < elements.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(elements.get(i)), expectedList.get(i));

        }


    }
}