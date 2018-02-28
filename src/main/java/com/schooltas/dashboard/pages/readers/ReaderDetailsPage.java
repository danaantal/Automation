package com.schooltas.dashboard.pages.readers;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.collections.Pair;

import com.schooltas.dashboard.templates.EntityDetails;

public class ReaderDetailsPage {
	private final WebDriver driver;

	public ReaderDetailsPage(WebDriver driver){
		this.driver = driver;
	}

	public void assertReaderDetails(){
		CreateReaderPage createReaderPage = PageFactory.initElements(driver, CreateReaderPage.class);
		EntityDetails details = PageFactory.initElements(driver, EntityDetails.class);

		ArrayList<Pair<WebElement,String>> readerInputList = createReaderPage.createReaderDetailsInputList();
		Map<String,String> readerDetailsMap = details.createMapForDetailsPage();

		assertEquals(readerDetailsMap.get("Title"), readerInputList.get(0).second());
		assertEquals(readerDetailsMap.get("Course"), readerInputList.get(1).second());
	}
}
