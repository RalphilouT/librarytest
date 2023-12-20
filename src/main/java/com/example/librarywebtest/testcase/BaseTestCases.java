package com.example.librarywebtest.testcase;

import com.example.librarywebtest.page.BasePage;
import com.example.librarywebtest.utilities.CommonUtilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTestCases {
    public WebDriver driver;
    public BasePage basePage = new BasePage();
    public CommonUtilities commonUtilities = new CommonUtilities();
    public JavascriptExecutor jse;
    String[] comparison = {};
    public Properties properties, propertiesTable = new Properties();
    @BeforeTest
    public void startTest() throws IOException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        jse = (JavascriptExecutor)driver;
        properties = commonUtilities.getPropBase();
        propertiesTable = commonUtilities.getPropSearch();
        comparison = commonUtilities.getCompareProperties("compareHeader");

    }
    @Test
    public void seleniumStart(){
        driver.get(properties.getProperty("baseUrl"));

    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }


}
