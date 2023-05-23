package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPathRealHealthProject {
    /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

 */
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com");

        WebElement makeAppointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointment.click();

        WebElement userName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        userName.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys(" Seoul");

        WebElement Apply = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if (Apply.isDisplayed() && !Apply.isSelected()) {
            Apply.click();
        }

        WebElement healthCareProgram = driver.findElement(By.xpath("//input[@value='Medicaid']"));
        healthCareProgram.click();

        WebElement visitDate = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        visitDate.sendKeys("5/17/2023");

        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("I would like to make appointment");

        WebElement bookAppointment = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookAppointment.click();

        WebElement actualHeader = driver.findElement(By.xpath("//h2[contains(text(),'Appointment')]"));
        String expectedHeader = "Appointment confirmation";
        if (actualHeader.getText().equals(expectedHeader)) {
            System.out.println("Appoinment confirmed");
        } else {
            System.out.println("Appointment Not Corfirmed");
        }

        WebElement header1 = driver.findElement(By.xpath("//p[contains(text(),'CURA')]"));
        System.out.println(header1.getText());

        WebElement header2 = driver.findElement(By.xpath("//p[.='Yes']"));
        System.out.println(header2.getText());

        WebElement header3 = driver.findElement(By.xpath("//p[@id='program']"));
        System.out.println(header3.getText());

        WebElement header4 = driver.findElement(By.xpath("//p[@id='visit_date']"));
        System.out.println(header4.getText());

        WebElement header5 = driver.findElement(By.xpath("//p[@id='comment']"));
        System.out.println(header5.getText());

        WebElement goToHomePage = driver.findElement(By.xpath("//a[@class='btn btn-default']"));
        goToHomePage.click();

        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.quit();


    }


}
