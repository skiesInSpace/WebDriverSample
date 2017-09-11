package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.PropertiesReader;


public class DriverContainer {

    private enum DriverType {
        CHROME
    }

    private static DriverType driverType = DriverType.CHROME;
    private static WebDriver driver = null;

    private final static String CHROME_PROPERTY_KEY = "webdriver.chrome.driver";
    private final static String CHROME_DRIVER_PATH = "resources/chromedriver.exe";


    public static WebDriver getDriver() {

        driverType = readDriverTypeFromProperty();

        if (driver == null) {

            switch (driverType) {
                case CHROME:
                    System.setProperty(CHROME_PROPERTY_KEY, CHROME_DRIVER_PATH);
                    return driver = new ChromeDriver();
            }
        }
        return driver;
    }

    private static DriverType readDriverTypeFromProperty() {

        String driverTypeString = PropertiesReader.getBrowserType().toUpperCase();
        DriverType type = DriverType.valueOf(driverTypeString);
        return type;
    }

}
