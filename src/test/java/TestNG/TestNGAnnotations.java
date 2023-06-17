package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite // clear the caches --> delete cookies
    public void beforeSuite(){
        System.out.println("I am beforeSuite Annotation");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am beforeTest Annotation");
    }
    @BeforeClass
    public void beforClass(){
        System.out.println("I am beforeClass Annotation");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I am beforeMethod Annotation");
    }

    @Test
    public void test1() {
        System.out.println("I am test1 Annotation");
    }

    @Test
    public void test2() {
        System.out.println("I am test2 Annotation");
    }
    @AfterMethod
    public void afterMethod(){ // tear down your driver  screenshot
        System.out.println("I am afterMethod Annotation");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am afterClass Annotation");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am afterTest Annotation");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("I am afterSuite Annotation");
    }
}
