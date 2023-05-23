package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsPractice {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Ulzii");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Ganbat");
        WebElement gender = driver.findElement(By.id("sex-0"));
        gender.click();
        WebElement experience = driver.findElement(By.id("exp-1"));
        experience.click();
        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("3/17/2023");
        WebElement profession =driver.findElement(By.id("profession-1"));
        profession.click();
        WebElement continent =driver.findElement(By.id("continents"));
        continent.sendKeys("North America");

        WebElement button = driver.findElement(By.id("submit"));
        button.click();

        //LOCATORS PARTIALLINKTEXT :

        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());





    }
}
