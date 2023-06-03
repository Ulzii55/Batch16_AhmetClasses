package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    @Test
    public void HeadersOfTheCar() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");

        WebElement stockType = driver.findElement(By.xpath("//select[@name='stock_type']"));
        BrowserUtils.selectBy(stockType, "new", "value");

        WebElement makes = driver.findElement(By.xpath("//select[@name='makes[]']"));
        BrowserUtils.selectBy(makes, "lexus", "value");

        WebElement models = driver.findElement(By.xpath("//select[@name='models[]']"));
        BrowserUtils.selectBy(models, "lexus-rx_350", "value");

        WebElement noMaxPrice = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select price = new Select(noMaxPrice);
        String actualText = BrowserUtils.getText(price.getFirstSelectedOption());
        String ExpectedText = "No max price";
        Assert.assertEquals(actualText, ExpectedText);

        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance, "40", "value");

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60056");

        WebElement searchButton = driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        searchButton.click();

        WebElement header = driver.findElement(By.xpath("//h1[@data-qa='page_h1']"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader, expectedHeader);

        Thread.sleep(2000);
        WebElement Sort1 = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        BrowserUtils.selectBy(Sort1, "list_price", "value");
        Thread.sleep(2000);

        WebElement Sort2 = driver.findElement(By.xpath("//select[@name='sort']"));
        BrowserUtils.selectBy(Sort2, "list_price", "value");

        List<WebElement> headers = driver.findElements(By.xpath("//h2[@class='title']"));

        for (WebElement head : headers) {
            Assert.assertTrue(BrowserUtils.getText(head).contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(head));

        }
        List<WebElement> allPrices = driver.findElements(By.xpath("//span[@class='primary-price']"));

        List<Integer> actualPrice = new ArrayList<>();
        List<Integer> expectedPrice = new ArrayList<>();
        for (int i = 0; i < allPrices.size(); i++) {
            String priceNumber= BrowserUtils.getText(allPrices.get(i)).replace("$","")
                    .replace(",","");
            actualPrice.add(Integer.parseInt(priceNumber));
            expectedPrice.add(Integer.parseInt(priceNumber));
            // DO NOT USE YOUR ACTUAL LIST
        }
        Collections.sort(expectedPrice);
        Assert.assertEquals(actualPrice,expectedPrice);
        System.out.println(actualPrice);
        System.out.println(expectedPrice);

    }
}
