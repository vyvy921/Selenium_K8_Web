package api_learning.testng;

import org.testng.annotations.*;

public class TestNGHook02 {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("---> before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("\t---> before Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("\t\t---> before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\t\t\t---> before Method");
    }

    @Test
    public void testSth() {
        System.out.println("\t\t\t\t---> Test");
    }

    @Test
    public void testSthEls() {
        System.out.println("\t\t\t\t---> Test sth else");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("\t\t\t---> after Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("\t\t---> after Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("\t---> after Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("---> after Suite");
    }
}
