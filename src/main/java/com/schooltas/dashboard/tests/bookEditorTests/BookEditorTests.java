package com.schooltas.dashboard.tests.bookEditorTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.books.bookEditor.addNewPin.TextInPopupPage;
import com.schooltas.dashboard.pages.books.bookEditor.bookViewer.BookViewerPage;
import com.schooltas.dashboard.templates.overviewPage.BooksOverviewTemplate;
import com.schooltas.dashboard.tests.BaseClass;
import com.schooltas.dashboard.utils.ActionUtils;

public class BookEditorTests extends BaseClass{

	@Test
	public void addNewPinOnBookTexInPopup() throws InterruptedException{

		BooksOverviewTemplate overviewTemplate = PageFactory.initElements(driver, BooksOverviewTemplate.class);
		BookViewerPage bookViewerPage = PageFactory.initElements(driver, BookViewerPage.class);
		TextInPopupPage textInPopupPage = PageFactory.initElements(driver, TextInPopupPage.class);
		String ean = "3711413071302";

		dashboardMenu.clickMainMenuOption("Books");
		overviewTemplate.searchForEntityByEan(ean);
		overviewTemplate.click("| Edit");
		ActionUtils.switchwindow();
		bookViewerPage.rightClickOnThePage();
		bookViewerPage.clickAddNewEnrichmentButton("Add new pin");
		textInPopupPage.clickTextInPopupEnrichmentButton("Text in popup");
		textInPopupPage.fillEnrichmentDetailsFields("Test title", "Body text test");
		textInPopupPage.verifyTitleAndText("Test title\nBody text test");
		textInPopupPage.deleteEnrichment();


		System.out.println("text in popup deleted!");
	}
}
