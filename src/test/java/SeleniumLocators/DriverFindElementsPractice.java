package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementsPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //WAIT TIMES
        driver.get("https://the-internet.herokuapp.com"); //URL
        List<WebElement> AllLink = driver.findElements(By.xpath("//li"));
        int count = 0;
        for (WebElement link : AllLink) {
            System.out.println(link.getText());


            if (link.getText().length() >= 12) {
                System.out.println(link.getText());
                count++;
            }
        }
        System.out.println("total number is " + count);


    }

}
