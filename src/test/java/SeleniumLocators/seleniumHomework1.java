package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class seleniumHomework1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        fullName.sendKeys("Ulzii Ganbat");

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
        email.sendKeys("UlziiGanbat12345@gmail.com");

        WebElement currentAddresse = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        currentAddresse.sendKeys("1234567 bristol st Buffalo Grove,Il 60089");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("1234 bristol st Buffalo Grove,Il 60089");

        WebElement submit = driver.findElement(By.xpath("//button[.='Submit']"));
        submit.sendKeys(Keys.ARROW_DOWN);
        submit.sendKeys(Keys.ARROW_DOWN);
        submit.sendKeys(Keys.ARROW_DOWN);
        submit.sendKeys(Keys.ARROW_DOWN);
        submit.sendKeys(Keys.ARROW_DOWN);
        submit.sendKeys(Keys.ARROW_DOWN);
        submit.sendKeys(Keys.ARROW_DOWN);

        submit.click();
        Thread.sleep(2000);
        WebElement outputName = driver.findElement(By.id("name"));
        WebElement outputEmail = driver.findElement(By.id("email"));
        WebElement outputCurrentAddress = driver.findElement(By.id("currentAddress"));
        System.out.println(outputCurrentAddress.getText());

        WebElement outputPermanentAddress = driver.findElement(By.id("permanentAddress"));

        String actualName = outputName.getText();
        String expectedName = "Ulzii Ganbat";
        String actualEmail = outputEmail.getText();
        String expectedEmail = "UlziiGanbat12345@gmail.com";
        String actualCurrentAddress = outputCurrentAddress.getText();
        String expectedCurrentAddress = "1234567 bristol st Buffalo Grove,Il 60089";
        String actualPermanentAddress = outputPermanentAddress.getText();
        String expectedPermanentAddress = "1234 bristol st Buffalo Grove,Il 60089";
        System.out.println(outputCurrentAddress.getText());

        if (actualName.contains(expectedName) && (actualEmail.contains(expectedEmail)) &&
                (actualCurrentAddress.contains(expectedCurrentAddress))) {
            System.out.println("Information matches!");
        } else {
            System.out.println("Information does not match!");
        }
      //  driver.quit();
    }

}

