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

public class PracticeActions {
    @Test
    public void practiceDragAndDrop() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        WebElement dropBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualText = BrowserUtils.getText(dropBox);
        String expectedText = "Drop here";
        Assert.assertEquals(actualText, expectedText);
        actions.dragAndDrop(draggable, dropBox).perform();

        WebElement dropped = driver.findElement(By.xpath("//p[.='Dropped!']"));

        String actualColor = dropBox.getCssValue("background-color").trim();
        String expectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor, expectedColor);


    }

    @Test
    public void practiceClickAndHold() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");

        WebElement accept= driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        accept.click();
        WebElement notAcceptable=driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        String actualString=BrowserUtils.getText(notAcceptable);
        String expectedString="Not  Acceptable";
        Assert.assertEquals(actualString,expectedString);

        WebElement dragMe= driver.findElement(By.xpath("//div[@id='draggable']"));
        String actualMSG=BrowserUtils.getText(dragMe);
        String expectedMSG="Drag me";
        Assert.assertEquals(actualMSG,expectedMSG);

        WebElement dropHere =driver.findElement(By.xpath("//p[.='Drop here']"));
        String actualDropMeText=BrowserUtils.getText(dropHere);
        String expectedDropMeText="Drop here";
        Assert.assertEquals(actualDropMeText,expectedDropMeText);

        Actions actions=new Actions(driver);
       // WebElement notAcceptable=driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        actions.clickAndHold(notAcceptable).moveToElement(dropHere).release().perform();















    }
}