package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import util.PropertiesReader;


import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver driver;


    @BeforeClass
    public static void setup() {
        driver = DriverContainer.getDriver();
        driver.manage().timeouts().implicitlyWait(PropertiesReader.getImplicitTime(), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(PropertiesReader.getExplicitTime(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(PropertiesReader.getUrl());

    }

    @AfterClass
    public static void tearDown(){
    	driver.quit();
    	
    	
    }
}
