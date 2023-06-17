package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLogic {


    @Test(dataProvider = "couples",dataProviderClass = allDataPractice.class)
    public void test1(String firstPerson,String secondPerson,String eyeColor) {
        System.out.println(firstPerson+secondPerson+eyeColor);
    }

}