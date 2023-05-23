package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Ulzii");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Ganbat");
        Thread.sleep(3000);

        WebElement Email = driver.findElement(By.xpath("//input[@id='input-email']"));
        Email.sendKeys("ulzii123456789@gmail.com");
        Thread.sleep(3000);

        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        telephone.sendKeys("847-273-1234");
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("Ulzii12345");
        Thread.sleep(3000);

        WebElement passwordConfirm = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passwordConfirm.sendKeys("Ulzii12345");
        Thread.sleep(3000);

        WebElement privacyPolicy = driver.findElement(By.xpath("//input[@type='checkbox']"));
        privacyPolicy.click();
        Thread.sleep(3000);

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
        Thread.sleep(3000);

        WebElement Header = driver.findElement(By.xpath("//h1[contains(text(),'Been Created!')]"));
        String expectedHeader = "Your Account Has Been Created!";
        System.out.println(Header.getText().trim().equals(expectedHeader) ? "PASSES" : "FAILED");
        Thread.sleep(3000);

        WebElement continueButton2 = driver.findElement(By.xpath("//a[.='Continue']"));
        continueButton2.click();
        Thread.sleep(3000);

        String currentUrl = "https://tutorialsninja.com/demo/index.php?route=account/register";
        System.out.println(driver.getCurrentUrl().equals(currentUrl) ? "PASSES" : "FAILED");
        driver.quit();


    }
}
