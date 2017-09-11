package util;

import core.DriverContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Waiter {
    public static void waitForTitleContains(WebDriver driver, String title) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void waitForElementPresentById(WebDriver driver, String selector) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(selector)));
    }

    public static void waitForElementPresentByCss(WebDriver driver, String selector) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }

    public static void waitForElementIsClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean isElementPresent(WebDriver driver, By element){
        boolean result = driver.findElements(element).size() > 0;
        return result;
    }

    // -----------

    public static void assertElementNotPresentByCss(WebDriver driver, String selector) {
        try {
            driver.navigate().refresh();
            driver.findElement(By.cssSelector(selector));
            Assert.fail("Element with selector <" + selector + "> is present");
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
    }
}
