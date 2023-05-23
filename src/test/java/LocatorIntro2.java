import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorIntro2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///Users/ulziiganbat/Desktop/Techtorial.html");

        //LINKTEXT LOCATOR :
        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String actualHeader = javaHeader.getText();
        String expectedHeader = "Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "CORRECT " : "FALSE");
        driver.navigate().back();

        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement SeleniumText =driver.findElement(By.tagName("h1"));
        String actualText =SeleniumText.getText().trim();
        String expectedText="Selenium automates browsers. That's it!";
        System.out.println(actualText.equals(expectedText) ? "selenium CORRECT" : " selenium FALSE");

        driver.navigate().back();
        WebElement cucumberLink = driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement cucumberText =driver.findElement(By.tagName("h1"));
        String actualText1 =cucumberText.getText();
        String expectedText1="Tools & techniques that elevate teams to greatness";
        System.out.println(actualText1.equals(expectedText1) ? "CORRECT" : "FALSE");
        driver.navigate().back();


        WebElement TESTNGLink = driver.findElement(By.linkText("TestNG"));
        TESTNGLink.click();
        WebElement testngText =driver.findElement(By.tagName("h2"));
        String actualTestNgtext =testngText.getText();
        String expectedTestngText="TestNG";
        System.out.println(actualTestNgtext.equals(expectedTestngText) ? "CORRECT" : "FALSE");
        driver.navigate().back();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "file:///Users/ulziiganbat/Desktop/Techtorial.html";
        System.out.println(actualURL.equals(expectedURL) ? "PASSED URL " : " FAILED URL");





    }

}
