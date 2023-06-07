package fileUpload;

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

public class FileUploadPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver();
        // WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("/Users/ulziiganbat/Desktop/usa.png");
        Thread.sleep(3000);
        // Assert.assertTrue(BrowserUtils.getText(chooseFile).contains("usa.png"));
        WebElement upLoadButton = driver.findElement(By.cssSelector("#file-submit"));
        upLoadButton.submit();
        //upLoadButton.click();
        // form tag and button and submit type bval you can use both click and submit
        WebElement fileUpLoaded = driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertTrue(BrowserUtils.getText(fileUpLoaded).contains("usa.png"));


    }

    @Test
    public void practice2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver();
        // WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");

        WebElement chooseFile = driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFile.sendKeys("/Users/ulziiganbat/Desktop/usa.png");
        WebElement uploadedMSG = driver.findElement(By.xpath("//b[.='Select file to send(max 196.45 MB)']"));
        Assert.assertEquals(uploadedMSG.getText(),"Select file to send(max 196.45 MB)");
        WebElement checkBox = driver.findElement(By.cssSelector("#terms"));
        checkBox.click();
        WebElement submitButton=driver.findElement(By.xpath("//button"));
        submitButton.click();
        Thread.sleep(3000);
        WebElement submitMSG=driver.findElement(By.tagName("h3"));
        //Assert.assertTrue(BrowserUtils.getText(submitMSG).contains("has been successfully uploaded"));
        String actualMsg=BrowserUtils.getText(submitMSG);
        String expectedMSG="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualMsg,expectedMSG);




    }
}
