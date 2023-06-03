package ActionClass;

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
import java.util.*;

public class HoverOverPractice {
    @Test
    public void practiceMoveToElement() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeoptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");

        Actions actions=new Actions(driver);
        actions.scrollByAmount(300,300);

        List<WebElement> AllImages = driver.findElements(By.xpath("//div[@class='product k-listview-item']//img[@src]"));
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='product-description']//p"));


        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < AllImages.size(); i++) {
            Thread.sleep(500);

            actions.moveToElement(AllImages.get(i)).perform();
            map.put(BrowserUtils.getText(items.get(i)),BrowserUtils.getText(prices.get(i)));
        }
        System.out.println(map);

    }
}