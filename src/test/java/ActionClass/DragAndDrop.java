package ActionClass;

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

public class DragAndDrop {
    @Test

    public void DragAndDrop() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Actions actions = new Actions(driver);
        actions.scrollByAmount(200, 200).perform();

        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        // Actions actions=new Actions(driver);
        String actualText = BrowserUtils.getText(orangeBox);
        String expectedText = "... Or here.";
        Assert.assertEquals(actualText, expectedText);

        String actualBackgroundColor = orangeBox.getCssValue("background-color");
        String expectedBackGroundColor = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualBackgroundColor, expectedBackGroundColor);

        WebElement circle = driver.findElement(By.xpath("//div[@id='draggable']"));
        Thread.sleep(3000);
        actions.dragAndDrop(circle, orangeBox).perform();
        Thread.sleep(3000);
        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualDragAndDrop = BrowserUtils.getText(orangeBox);
        String expectedDragAndDrop = "You did great!";
        Assert.assertEquals(actualDragAndDrop, expectedBackGroundColor);


    }

    @Test
    public void DragAndDropPractice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String ActualMsg = BrowserUtils.getText(blueBox);
        String expectedMsg = "Drag the small circle here ...";
        Assert.assertEquals(ActualMsg, expectedMsg);
        String actualColor = blueBox.getCssValue("background-color").trim();
        String expectedColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColor, expectedColor);

        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();

        String actualAfterAction = BrowserUtils.getText(blueBox);
        String expectedAfterAction = "You did great!";
        Assert.assertEquals(actualAfterAction, expectedAfterAction);




    }
}
