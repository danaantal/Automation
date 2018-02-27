package com.schooltas.dashboard.pages.books;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.collections.Pair;

import com.schooltas.dashboard.templates.entityDetails.EntityDetails;

public class BookDetailsPage {

	private final WebDriver driver;

	public BookDetailsPage(WebDriver driver){
		this.driver = driver;
	}

	public void assertBookDetails(String ean, boolean isCreateForm) {
		CreateBookPage createBookPage = PageFactory.initElements(driver, CreateBookPage.class);
		EditBookPage editBook = PageFactory.initElements(driver, EditBookPage.class);
		EntityDetails details = PageFactory.initElements(driver, EntityDetails.class);

		ArrayList<Pair<WebElement, String>> bookInputList;
		Map<String, String> bookDetailsMap;

		if(isCreateForm){
			bookInputList = createBookPage.createBookDetailsInputList(ean);
		}
		else{
			bookInputList = editBook.createBookDetailsInputList();
		}

		bookDetailsMap = details.createMapForDetailsPage();

		assertEquals(bookDetailsMap.get("Title"), bookInputList.get(0).second());
		assertEquals(bookDetailsMap.get("E-ISBN"), bookInputList.get(1).second());
		assertEquals(bookDetailsMap.get("Course"), bookInputList.get(2).second());
		assertEquals(bookDetailsMap.get("Book type"), bookInputList.get(3).second());
		assertEquals(bookDetailsMap.get("Year"), bookInputList.get(4).second());
		assertEquals(bookDetailsMap.get("Stream"), bookInputList.get(5).second());
		assertEquals(bookDetailsMap.get("Series"), bookInputList.get(6).second());
	}
}
