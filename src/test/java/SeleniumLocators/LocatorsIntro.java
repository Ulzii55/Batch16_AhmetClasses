package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {
    public static void main(String[] args) throws InterruptedException {

      //locators --> is a way to locate (find) element and manipulate on it
        // id locator :

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("file:///Users/ulziiganbat/Downloads/Techtorial.html");
        driver.manage().window().maximize();
        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualHeader = header.getText().trim();  // it gets the text from element
        String expectedHeader = "Techtorial Academy";
        System.out.println(header.getText());
        System.out.println(actualHeader.equals(expectedHeader) ? "CORRECT":"WRONG ");

        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        // NAME LOCATOR
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Ulzii");
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Ganbat");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("464-273-5647");
        WebElement email = driver.findElement(By.name("userName"));
        email.sendKeys("ogi789y@yahoo.com");

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("1328 bristol ");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("chicago ");
        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL ");


        WebElement postalCode = driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("60089");
        WebElement country = driver.findElement(By.name("country"));
        country.sendKeys("USA");

        // CLASS LOCATOR

        WebElement allTools =driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());
        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed()&& javaBox.isSelected()){
            javaBox.click();
        }
        System.out.println(javaBox.isDisplayed()?"SELECTED":"NOT SELECTED");

        WebElement TESTNG = driver.findElement(By.id("cond3"));
        if (TESTNG.isDisplayed()&& !TESTNG.isSelected()){
            TESTNG.click();
        }
        System.out.println(TESTNG.isDisplayed()?"SELECTED":"NOT SELECTED");

        WebElement CUCUMBER = driver.findElement(By.id("cond4"));
        if (CUCUMBER.isDisplayed()&& !CUCUMBER.isSelected()){
            CUCUMBER.click();
        }
        System.out.println(CUCUMBER.isDisplayed()?"SELECTED":"NOT SELECTED");


        // TAG NAME LOCATOR:
        WebElement header2 = driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());

        WebElement header3 = driver.findElement(By.tagName("u"));
        System.out.println(header3.getText());

        Thread.sleep(2000);
        driver.quit();

    }
}
