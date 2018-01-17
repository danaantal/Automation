package com.schooltas.dashboard.pages.books;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.collections.Pair;

import com.schooltas.dashboard.templates.entitydetails.EntityDetails;

public class BookDetailsPage {

	private final WebDriver driver;

	public BookDetailsPage(WebDriver driver){
		this.driver = driver;
	}

	public void assertBookDetails(String ean) {
		CreateBookPage createBookPage = PageFactory.initElements(driver, CreateBookPage.class);
		EntityDetails details = PageFactory.initElements(driver, EntityDetails.class);

		ArrayList<Pair<WebElement, String>> bookInputList = createBookPage.createBookDetailsInputList(ean);
		Map<String, String> bookDetailsMap = details.createEntityDetailsMap();

		assertEquals(bookDetailsMap.get("Title"), bookInputList.get(0).second());
		assertEquals(bookDetailsMap.get("E-ISBN"), bookInputList.get(1).second());
		assertEquals(bookDetailsMap.get("Course"), bookInputList.get(2).second());
		assertEquals(bookDetailsMap.get("Book type"), bookInputList.get(3).second());
		assertEquals(bookDetailsMap.get("Year"), bookInputList.get(4).second());
		assertEquals(bookDetailsMap.get("Stream"), bookInputList.get(5).second());
		assertEquals(bookDetailsMap.get("Series"), bookInputList.get(6).second());
	}
}
