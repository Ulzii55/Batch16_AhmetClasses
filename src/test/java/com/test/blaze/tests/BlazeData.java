package com.test.blaze.tests;

import org.testng.annotations.DataProvider;

public class BlazeData {
    @DataProvider(name="orderData")
    public Object[][]getData(){
        return new Object[][]{
                {"Phones","Nokia lumia 1520","Product added","Ahmet","Turkiye","Ankara","1234234123","05","2025", "Thank you for your purchase!","http://www.demoblaze.com/index.html"},
                {"Phones","Samsung galaxy s6","Product added","Mehmet","england","london","1234234123","05","2025", "Thank you for your purchase!","http://www.demoblaze.com/index.html"},
                {"laptop","Sony vaio i5","Product added","Ayse","Japan","Tokyo","1234234123","05","2025", "Thank you for your purchase!","http://www.demoblaze.com/index.html"},
                {"laptop","2017 Dell 15.6 Inch","Product added","John","USA","Chicago","1234234123","05","2025", "Thank you for your purchase!","http://www.demoblaze.com/index.html"},
                {"Monitor","Apple monitor 24","Product added","David","Germany","Berlin","1234234123","05","2025", "Thank you for your purchase!","http://www.demoblaze.com/index.html"},
                {"Monitor","ASUS Full HD","Product added","Gearge","France","Paris","1234234123","05","2025", "Thank you for your purchase!","http://www.demoblaze.com/index.html"},


        };
    }
}
