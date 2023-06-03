package ActionClass.frames_iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class newFramePractice {
    @Test
    public void practiceFrame() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

        Actions actions = new Actions(driver);
        WebElement pavilion = driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavilion.click();
        BrowserUtils.switchByTitle(driver, "Home - qavalidation");
        WebElement javaForQa = driver.findElement(By.linkText("JavaForQA"));
        actions.moveToElement(javaForQa).perform();
        WebElement testNG = driver.findElement(By.linkText("JavaForQA"));
        actions.click(testNG).perform();
        List<WebElement> allLinks = driver.findElements(By.xpath("//div//h3"));
        for (WebElement link : allLinks){
            System.out.println(BrowserUtils.getText(link));
        }
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement category2= driver.findElement(By.linkText("Category2"));
        category2.click();
        WebElement search= driver.findElement(By.xpath("//i[@class=' mw-icon the7-mw-icon-search-bold']"));
        actions.click(search).perform();


    }
}
