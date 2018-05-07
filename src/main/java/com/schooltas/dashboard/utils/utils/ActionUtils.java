package com.schooltas.dashboard.utils.utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.schooltas.dashboard.pages.login.LoginPage;
import com.schooltas.dashboard.tests.BaseClass;

public class ActionUtils extends BaseClass {

    public static void pressEscKey(){
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

    public static void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementInvisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public static void rightClick(WebElement element) {
        try {
            Actions action = new Actions(driver).contextClick(element);
            action.build().perform();

            System.out.println("Sucessfully Right clicked on the element");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + element + " was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Element " + element + " was not clickable " + e.getStackTrace());
        }

    }

    public static void switchwindow() {
        try {

            // String winHandleBefore = driver.getWindowHandle();

            for (String winHandle : driver.getWindowHandles()) {
                driver = driver.switchTo().window(winHandle);
            }
        } catch (Exception e) {
            // return Constants.KEYWORD_FAIL+ "Unable to Switch Window" +
            // e.getMessage();
        }
        // return Constants.KEYWORD_PASS;
    }

    public static long generateIsbnRandom() {
        while (true) {
            long numb = (long) (Math.random() * 100000000 * 1000000);
            if (String.valueOf(numb).length() == 13) {
                return numb;
            }
        }
    }

    public static void loginAs(String organization) {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        if (organization == "publisher") {
            loginPage.loginDashboard(TEST_PUBLISHER_EMAIL, TEST_PUBLISHER_PASS);
        } else if (organization == "distributor") {
            loginPage.loginDashboard(TEST_DISTRIBUTOR_EMAIL, TEST_DISTRIBUTOR_PASS);
        } else if (organization == "school") {
            loginPage.loginDashboard(TEST_SCHOOL_EMAIL, TEST_SCHOOL_PASS);
        }
    }


}
