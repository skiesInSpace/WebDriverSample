package kap_vfr_ap07.page;

import kap_vfr_ap07.business_object.Filter;
import util.XLSParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class ReportPage {

    private static final String FILTER_PATTERN = ".//tr[@id='z4UAD']/td[%d]/descendant::div";
    private static final String FILTER_TYPE_PATTERN = ".//div[@class='dropdown_menu open']/ul/li[%d]";
    private static final String FILTER_INPUT_PATTERN = ".//tr[@id='z4UAD']/td[%d]/descendant::input";

    //----------------------------------------
    private static final String PATH_TO_XLS = "resources/data.xlsx";
    public static String ADMIN_CENTER_FRAME = "ADMIN_CENTER";

    private static Map<String, Integer> columnMap;
    private static Map<String, Integer> typeMap;

    private final WebDriver driver;


    // maps initialization
    static {
        XLSParser xlsParser = new XLSParser();
        final int filterColumnSheetNumber = 0;
        columnMap = xlsParser.parse(new File(PATH_TO_XLS), filterColumnSheetNumber);

        final int filterTypeSheetNumber = 1;
        typeMap = xlsParser.parse(new File(PATH_TO_XLS), filterTypeSheetNumber);
    }


    public ReportPage(WebDriver driver) {
        this.driver = driver;

    }


    public ReportPage applyFilter(Filter... filter) {

        driver.switchTo().frame(ADMIN_CENTER_FRAME);

        ArrayList<Filter> filterList = new ArrayList<>(Arrays.asList(filter));
        for (Filter f : filterList) {
            applyFilter(f.getColumnName(), f.getFilterType(), f.getFilterValue());
        }

        driver.switchTo().defaultContent();

        return this;
    }

    public void applyFilter(String column, String filterType, String filterValue) {

        clickFilterDropdown(column);
        clickFilterType(filterType);
        typeFilterValue(column, filterValue);


    }

    private void clickFilterDropdown(String column) {
        int columnNumber = columnMap.get(column);
        By filterlocator = By.xpath(String.format(FILTER_PATTERN, columnNumber));
        WebElement filterElement = driver.findElement(filterlocator);
        filterElement.click();
    }

    private void clickFilterType(String filterType) {
        int typeNumber = typeMap.get(filterType);
        By typeLocator = By.xpath(String.format(FILTER_TYPE_PATTERN, typeNumber));
        WebElement filterTypeElement = driver.findElement(typeLocator);
        filterTypeElement.click();
    }

    private void typeFilterValue(String column, String filterValue) {
        int columnNumber = columnMap.get(column);
        By valueLocator = By.xpath(String.format(FILTER_INPUT_PATTERN, columnNumber));
        WebElement filterValueElement = driver.findElement(valueLocator);
        filterValueElement.sendKeys(filterValue);
    }


}
