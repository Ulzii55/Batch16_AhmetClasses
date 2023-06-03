package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectPractice {
    @Test
    public  void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/ulziiganbat/Desktop/Techtorial.html");

        WebElement countryBox= driver.findElement(By.xpath("//select[@name='country']"));
        Select country= new Select(countryBox);

        String actualFirstOption=country.getFirstSelectedOption().getText().trim();
        String expectedFirstOption="UNITED STATES";
        Assert.assertEquals(actualFirstOption,expectedFirstOption);

        List<WebElement> allCountries = country.getOptions();
        int count =0;
        for (WebElement contry:allCountries){
            System.out.println(contry.getText().trim());
            count++;
        }
        System.out.println(count);

        country.selectByVisibleText("MONGOLIA ");
        Thread.sleep(2000);
        country.selectByValue("100");
        Thread.sleep(2000);
        country.selectByIndex(99);





    }
}
