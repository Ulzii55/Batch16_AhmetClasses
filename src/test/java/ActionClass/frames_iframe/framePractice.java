package ActionClass.frames_iframe;

import Utils.BrowserUtils;
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

public class framePractice {
    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement title = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(title));
        driver.switchTo().frame("mce_0_ifr");
        WebElement yourContent = driver.findElement(By.xpath("//body[@id='tinymce']"));
        yourContent.clear();
        yourContent.sendKeys("i love Selenium");
        driver.switchTo().parentFrame();
        title = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(title));


    }

    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

        WebElement pavillion = driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavillion.click();
        BrowserUtils.switchByTitle(driver, "SeleniumTesting");
        Actions actions = new Actions(driver);
        WebElement selenium = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        actions.moveToElement(selenium).perform();
        WebElement seleniumPhyton = driver.findElement(By.linkText("Selenium-Python"));
        actions.click(seleniumPhyton).perform();
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.tagName("h1"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "Selenium-Python Tutorial";
        Assert.assertEquals(actualHeader, expectedHeader);

        List<WebElement> allLinks = driver.findElements(By.xpath("//p//a"));

        for (WebElement link : allLinks) {
            System.out.println(BrowserUtils.getText(link));
        }

        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Frame1");
        WebElement categoryOne = driver.findElement(By.xpath("//a[.='Category1']"));
        actions.click(categoryOne).perform();
        BrowserUtils.switchByTitle(driver, "SeleniumTesting");
        WebElement Header = driver.findElement(By.xpath("//h1"));
        String actualheader = BrowserUtils.getText(Header);
        String expectedheader = "Category Archives: SeleniumTesting";
        Assert.assertEquals(actualheader, expectedheader);

        List<WebElement> allHeaders = driver.findElements(By.xpath("//h3//a"));
        for (WebElement HEADER : allHeaders) {
            System.out.println(BrowserUtils.getText(HEADER));
        }

        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Frame1");
        WebElement text=driver.findElement(By.xpath("//p[@id='frametext']"));
        System.out.println(BrowserUtils.getText(text));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"Archives");
        WebElement Header1= driver.findElement(By.xpath("//h1"));
        System.out.println(BrowserUtils.getText(Header1));









    }
}
