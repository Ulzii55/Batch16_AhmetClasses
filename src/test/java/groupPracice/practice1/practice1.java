package groupPracice.practice1;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class practice1 {
    @Test
    public void groupPractice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");

        WebElement tiles = driver.findElement(By.xpath("//a[.='Tile']"));
        tiles.click();

        List<WebElement> icons = driver.findElements(By.xpath("//div[@id='chessboard']//div"));
        Actions actions = new Actions(driver);
        List<String> expected = Arrays.asList("Black King", "Black Queen", "Black Rook", "Black Bishop", "Black Knight", "Black Pawn");

        for (int i = 0; i < icons.size(); i++) {
            actions.moveToElement(icons.get(i)).perform();
            Thread.sleep(2000);
            Assert.assertEquals(BrowserUtils.getText(icons.get(i)),expected.get(i));

        }


    }
}