package com.example.librarywebtest.testcase;

import com.example.librarywebtest.page.BasePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class SearchTestCase extends BaseTestCases{
    public BasePage basePage = new BasePage();
    @Test(priority = 1)
    public void searchValues(){
        WebElement webElementInput= basePage.getInput(driver,properties.getProperty("inputEnter"));
        webElementInput.sendKeys(propertiesTable.getProperty("searchValue"));
        WebElement webElementButton = basePage.getButton(driver, properties.getProperty("buttonClick"));
        webElementButton.click();
    }
    @Test(priority = 2)
    public void searchTableHeader() throws IOException {
        List<WebElement> webElements = basePage.getHeaderTable(driver, propertiesTable.getProperty("getHeaderRow"));
        comparison = commonUtilities.getCompareProperties("compareHeader");
        for(int i = 1; i<= webElements.size();i++){
            assertEquals(webElements.get(i-1).getText(), comparison[i-1]);
        }

    }

    @Test(priority = 3)
    public void searchTableRow() throws IOException {
        List<WebElement> webElements = basePage.getSearchTable(driver, propertiesTable.getProperty("getSearchRow"));
        comparison = commonUtilities.getCompareProperties("compareSearchTable");
        for(int i = 1; i<= webElements.size();i++){
            assertEquals(webElements.get(i-1).getText(), comparison[i-1]);
        }
    }

}
