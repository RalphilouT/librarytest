package com.example.librarywebtest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    public WebElement getInput(WebDriver driver, String input){
        return driver.findElement(By.xpath(input));
    }

    public WebElement getButton(WebDriver driver, String button){
        return driver.findElement(By.xpath(button));
    }
    public List<WebElement> getHeaderTable(WebDriver driver, String headerTable){
        return driver.findElements(By.xpath(headerTable));
    }
    public List<WebElement> getSearchTable(WebDriver driver, String searchTable){
        return driver.findElements(By.xpath(searchTable));
    }
}
