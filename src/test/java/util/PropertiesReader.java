package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static final String PROPERTIES_FILE = "resources/driver.properties";
    private static final String IMPLICIT_PROPERTY_KEY = "defaultImplicitWaitTimeout";
    private static final String EXPLICIT_PROPERTY_KEY = "defaultExplicitWaitTimeout";
    private static final String URL_PROPERTY_KEY = "url";
    private static final String BROWSER_PROPERTY_KEY = "browser";


    private static String url;
    private static String browserType;

    private static int defaultImplicitWaitTimeOut;
    private static int defaultExplicitWaitTimeout;



    static {
        Properties properties = null;
        try (FileInputStream fileProperty = new FileInputStream(PROPERTIES_FILE)) {
            properties = new Properties();
            properties.load(fileProperty);

            defaultImplicitWaitTimeOut = Integer.parseInt(properties.getProperty(IMPLICIT_PROPERTY_KEY));
            defaultExplicitWaitTimeout = Integer.parseInt(properties.getProperty(EXPLICIT_PROPERTY_KEY));
            url = properties.getProperty(URL_PROPERTY_KEY);
            browserType = properties.getProperty(BROWSER_PROPERTY_KEY);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return url;
    }

    public static String getBrowserType() {
        return browserType;
    }

    public static int getImplicitTime() {
        return defaultImplicitWaitTimeOut;
    }

    public static int getExplicitTime() {
        return defaultExplicitWaitTimeout;
    }
}
