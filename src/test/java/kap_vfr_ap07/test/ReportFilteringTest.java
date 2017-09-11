package kap_vfr_ap07.test;

import kap_vfr_ap07.business_object.Filter;
import kap_vfr_ap07.page.ReportPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import core.TestBase;

public class ReportFilteringTest extends TestBase {



    @DataProvider(name = "filterData")
    public Object[][] createStuctureData() {
        return new Object[][] {
                { new String("CompanyShortName"), new String("starts with"), new String("value")},
                { new String("CompanyName"), new String("empty"), new String("value") },


        };
    }

    @Test(dataProvider = "filterData")
    public void testFilter(String columnName, String filterType, String filterValue){

        ReportPage reportPage = new ReportPage(driver);


        Filter filter = new Filter();
        filter.setColumnName(columnName);
        filter.setFilterType(filterType);
        filter.setFilterValue(filterValue);

        reportPage.applyFilter(filter);

    }


}
