package com.schooltas.dashboard.pages.books;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.collections.Pair;

import com.schooltas.dashboard.templates.EntityDetails;

public class BookDetailsPage{

    private final WebDriver driver;

    public BookDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    public void assertBookDetails(ArrayList<Pair<WebElement, String>> bookInput) {

        EntityDetails details = PageFactory.initElements(driver, EntityDetails.class);

        Map<String, String> bookDetails = details.createMapForDetailsPage();

        assertEquals(bookDetails.get("Title"), bookInput.get(0).second());
        assertEquals(bookDetails.get("E-ISBN"), bookInput.get(1).second());
        assertEquals(bookDetails.get("Course"), bookInput.get(2).second());
        assertEquals(bookDetails.get("Book type"), bookInput.get(3).second());
        assertEquals(bookDetails.get("Year"), bookInput.get(4).second());
        assertEquals(bookDetails.get("Stream"), bookInput.get(5).second());
        assertEquals(bookDetails.get("Series"), bookInput.get(6).second());
    }
}
