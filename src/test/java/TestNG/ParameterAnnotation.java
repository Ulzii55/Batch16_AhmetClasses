package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {
    @Parameters("firstName")

    @Test(priority = 1)
    public void test(String name) {

        System.out.println(name);
    }

    @Parameters({"city", "country", "zipCode"})

    @Test(priority = 2)
    public void multpleParameter(String city, String country, String zipCode) {
        System.out.println(city);
        System.out.println(country);
        System.out.println(zipCode);

    }
}
