package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import driver.Driver;

public class BaseTest {

    protected BaseTest(){}

    @BeforeClass
    public void startUp(){
        Driver.initDriver();
    }

    @AfterClass
    public void tearDown(){
        Driver.quitDriver();
    }

}
