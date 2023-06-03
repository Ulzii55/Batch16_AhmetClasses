package GetWindowHandle;

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
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPractice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        WebElement title = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(title));
        System.out.println(driver.getWindowHandle());

        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesId = driver.getWindowHandles();


        for (String id : allPagesId) {
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
                break;
            }
        }
        title = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(title));


    }

    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button2 = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        button2.click();

        String MnPageId = driver.getWindowHandle();       // this is my current driver page id
        Set<String> allPageId = driver.getWindowHandles();
        for (String id : allPageId) {
            if (!id.equals(MnPageId)) {
                driver.switchTo().window(id);
                break;
            }
        }
        String actualHeader = driver.getTitle();
        String expectedHeader = "AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(actualHeader, expectedHeader);

        WebElement alertText = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualText = BrowserUtils.getText(alertText);
        String expectedText = "AlertsDemo";
        Assert.assertEquals(actualText, expectedText);

        WebElement clickMe= driver.findElement(By.xpath("//button[@id='alertBox']"));
        clickMe.click();

    }
}
