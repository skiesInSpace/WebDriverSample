package kap_vfr_ap07.business_object;

public class Filter {

    private String columnName;
    private String filterType;
    private String filterValue;


    public String getColumnName() {
        return columnName;
    }

    public String getFilterType() {
        return filterType;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }
}
