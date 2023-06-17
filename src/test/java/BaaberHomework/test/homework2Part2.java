package BaaberHomework.test;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class homework2Part2 {
    @Test
    public void Homwork2Part2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://codefish.ninja/openmrs/login.htm");
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
        userName.sendKeys("admin");
        passWord.sendKeys("Admin123");
        WebElement labLocation = driver.findElement(By.cssSelector("#Laboratory"));
        WebElement loginButton = driver.findElement(By.cssSelector("#loginButton"));
        labLocation.click();
        loginButton.click();
        WebElement registerPatient = driver.findElement(By.xpath("//i[@class='icon-user']"));
        registerPatient.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@name='givenName']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@name='familyName']"));
        firstName.sendKeys("ulzii");
        lastName.sendKeys("ganbat", Keys.ENTER);
        WebElement gender = driver.findElement(By.xpath("//span[.='Gender']"));
        gender.click();
        WebElement chooseGender = driver.findElement(By.xpath("//option[.='Male']"));
        WebElement birthDayButton = driver.findElement(By.xpath("//span[.='Birthdate']"));
        WebElement birthDay = driver.findElement(By.xpath("//input[@name='birthdateDay']"));
        WebElement birthMonth = driver.findElement(By.xpath("//select[@name='birthdateMonth']"));
        chooseGender.click();
        birthDayButton.click();
        birthDay.sendKeys("20");
        Select birthMonths = new Select(birthMonth);
        BrowserUtils.selectBy(birthMonth, "December", "text");
        WebElement birthYear = driver.findElement(By.xpath("//input[@name='birthdateYear']"));
        birthYear.sendKeys("1988");
        WebElement address = driver.findElement(By.xpath("//span[.='Address']"));
        address.click();
        WebElement street = driver.findElement(By.cssSelector("#address1"));
        street.sendKeys("2200 E Devon ave");
        WebElement city = driver.findElement(By.cssSelector("#cityVillage"));
        city.sendKeys("Des Plains");
        WebElement state = driver.findElement(By.cssSelector("#stateProvince"));
        state.sendKeys("IL");
        WebElement county = driver.findElement(By.cssSelector("#country"));
        county.sendKeys("Cook");
        WebElement zipCode = driver.findElement(By.cssSelector("#postalCode"));
        zipCode.sendKeys("60018");
        WebElement phoneNumber = driver.findElement(By.xpath("//span[.='Phone Number']"));
        phoneNumber.click();
        WebElement enterPhoneNumber = driver.findElement(By.xpath("//input[@name='phoneNumber']"));
        enterPhoneNumber.sendKeys("996 52 18 0592");
        String actualFirstName = BrowserUtils.getText(firstName);
        String actualLastName = BrowserUtils.getText(lastName);
        String actualBirthDay = BrowserUtils.getText(birthDay);
        String actualBirthMonth = BrowserUtils.getText(birthMonth);
        String actualBirthYear = BrowserUtils.getText(birthYear);
        String actualStreet = BrowserUtils.getText(street);
        String actualCity = BrowserUtils.getText(city);
        String actualState = BrowserUtils.getText(state);
        String actualCounty = BrowserUtils.getText(county);
        String actualZipCode = BrowserUtils.getText(zipCode);
        String actualPhoneNumber = BrowserUtils.getText(enterPhoneNumber);
        Thread.sleep(2000);
        Assert.assertEquals(actualFirstName,"ulzii");
        Assert.assertEquals(actualLastName,"ganbat");
        Assert.assertEquals(actualBirthDay,"20");
        Assert.assertEquals(actualBirthMonth,"December");
        Assert.assertEquals(actualBirthYear,"1988");
        Assert.assertEquals(actualStreet,"2200 E Devon ave");
        Assert.assertEquals(actualCity,"Des Plains");
        Assert.assertEquals(actualState,"IL");
        Assert.assertEquals(actualCounty,"Cook");
        Assert.assertEquals(actualZipCode,"60018");
        Assert.assertEquals(actualPhoneNumber,"996 52 18 0592");
        WebElement confirmButton = driver.findElement(By.xpath("//span[.='Confirm']"));
        confirmButton.click();
        WebElement clickConfirmButton = driver.findElement(By.xpath("//input[@value='Confirm']"));
        clickConfirmButton.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText().trim();
        String expectedAlertText = "Created Patient Record Ulzii Ganbat";
        Assert.assertEquals(actualAlertText, expectedAlertText);
        WebElement patientID = driver.findElement(By.xpath("//span[.='101LDE']"));
        String actualID = BrowserUtils.getText(patientID);
        String expectedID = "101LDE";
        Assert.assertEquals(actualID, expectedID);
        WebElement homeButton = driver.findElement(By.xpath("//i[@class='icon-home small']"));
        homeButton.click();
        WebElement patientRecord = driver.findElement(By.xpath("//i[@class='icon-search']"));
        patientRecord.click();
        List<WebElement> allPatients = driver.findElements(By.xpath("//tbody//tr[@class='odd']"));

        for (WebElement patient : allPatients) {
            Assert.assertEquals(BrowserUtils.getText(patient).contains("Ulzii Ganbat"),"Ulzii Ganbat");
            Assert.assertEquals(BrowserUtils.getText(patient).contains("101LDE"),"101LDE");
        }
         WebElement customer=driver.findElement(By.xpath("//td[contains(text(),'ulzii')]"));
        customer.click();
        WebElement deleteCustomer=driver.findElement(By.xpath("//li//i[@class='icon-remove']"));
        deleteCustomer.click();
        WebElement ConfirmButton=driver.findElement(By.xpath(""));
        ConfirmButton.click();
        WebElement errorMSG=driver.findElement(By.cssSelector("#delete-reason-empty"));
        String actualMSG=BrowserUtils.getText(errorMSG);
        String expectedMSG="Reason cannot be empty";
        Assert.assertEquals(actualMSG,expectedMSG);
        WebElement deleteReason=driver.findElement(By.cssSelector("#delete-reason"));
        deleteReason.sendKeys("Moved");
        Alert alert2 = driver.switchTo().alert();
        String actualAlertMSG=alert2.getText().trim();
        String expectedAlertMSG="Patient has been deleted Successfully";
        Assert.assertEquals(actualAlertMSG,expectedAlertMSG);



    }
}
