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

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPractice {
    @Test
    public void validateOrderMessage() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWay= driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();
        WebElement passenger = driver.findElement(By.xpath("//select[@name='passCount']"));
        passenger.click();
        Select passengerCount = new Select(passenger);
        passengerCount.selectByValue("4");
        WebElement departingFromBox = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departDefaultCity = new Select(departingFromBox);
        departDefaultCity.selectByVisibleText("Acapulco");
        String actualDefaultOption = departDefaultCity.getFirstSelectedOption().getText().trim();
        String expectedDefaultOptions = "Acapulco";
        Assert.assertEquals(actualDefaultOption, expectedDefaultOptions);
        Select departFrom = new Select(departingFromBox);
        departFrom.selectByVisibleText("Paris");
        WebElement monthBox = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select leavingDate = new Select(monthBox);
        leavingDate.selectByValue("8");
        WebElement dateBox = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select date = new Select(dateBox);
        date.selectByValue("15");
        WebElement arriveBox = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arriveCity = new Select(arriveBox);
        arriveCity.selectByValue("San Francisco");
        WebElement arriveMonthBox = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select arriveMonth = new Select(arriveMonthBox);
        arriveMonth.selectByValue("12");
        WebElement arriveDateBox = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select arriveDate = new Select(arriveDateBox);
        arriveDate.selectByValue("15");
        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();

        Select airlineDropdown = new Select(driver.findElement(By.name("airline")));
        List<WebElement> actualAirLineOptions = airlineDropdown.getOptions();  //4
        List<String> expectedOption = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i < actualAirLineOptions.size(); i++) {
            Assert.assertEquals(actualAirLineOptions.get(i).getText().trim(), expectedOption.get(i));
        }

        airlineDropdown.selectByVisibleText("Unified Airlines");
        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();

        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage = message.getText().trim();
        String expectedMessage = "After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage, expectedMessage);


    }

    @Test
    public void validateOrderMessageShortCut() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement passenger = driver.findElement(By.xpath("//select[@name='passCount']"));
        passenger.click();

        BrowserUtils.selectBy(passenger, "4", "value");


        WebElement departingFromBox = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departDefaultCity = new Select(departingFromBox);
        departDefaultCity.selectByVisibleText("Acapulco");
        String actualDefaultOption = departDefaultCity.getFirstSelectedOption().getText().trim();
        String expectedDefaultOptions = "Acapulco";
        Assert.assertEquals(actualDefaultOption, expectedDefaultOptions);
        Select departFrom = new Select(departingFromBox);

        BrowserUtils.selectBy(departingFromBox,"Paris","text");

        WebElement monthBox = driver.findElement(By.xpath("//select[@name='fromMonth']"));

        Select leavingDate = new Select(monthBox);
        leavingDate.selectByValue("8");
        WebElement dateBox = driver.findElement(By.xpath("//select[@name='fromDay']"));

        BrowserUtils.selectBy(dateBox,"15","value");
        WebElement arriveBox = driver.findElement(By.xpath("//select[@name='toPort']"));

        BrowserUtils.selectBy(arriveBox,"San Francisco","text");
        WebElement arriveMonthBox = driver.findElement(By.xpath("//select[@name='toMonth']"));

        BrowserUtils.selectBy(arriveMonthBox,"12","value");
        WebElement arriveDateBox = driver.findElement(By.xpath("//select[@name='toDay']"));

        BrowserUtils.selectBy(arriveDateBox,"15","value");

        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();

        Select airlineDropdown = new Select(driver.findElement(By.name("airline")));
        List<WebElement> airLineOptions = airlineDropdown.getOptions();  //4
        List<String> expectedOption = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        Thread.sleep(2000);
        for (int i = 0; i < airLineOptions.size(); i++) {
            Assert.assertEquals(airLineOptions.get(i).getText().trim(), expectedOption.get(i));
        }

        airlineDropdown.selectByVisibleText("Unified Airlines");
        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();

        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage =BrowserUtils.getText(message);
        String expectedMessage = "After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage, expectedMessage);


    }

}