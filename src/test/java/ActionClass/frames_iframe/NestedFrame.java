package ActionClass.frames_iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;

public class NestedFrame {
    @Test
    public void NestedFramePractice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");

        //name or id   //nested frame
        driver.switchTo().frame("frame-top");
        WebElement iframeLeft = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(iframeLeft);
        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(left));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middleFrame= driver.findElement(By.cssSelector("#content"));
        System.out.println(BrowserUtils.getText(middleFrame));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(right));
        //bottom frame
//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottom=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottom));










    }


}