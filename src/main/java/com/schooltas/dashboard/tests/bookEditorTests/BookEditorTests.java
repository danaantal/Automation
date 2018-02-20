package com.schooltas.dashboard.tests.bookEditorTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.books.bookEditor.EditBookViewerPage;
import com.schooltas.dashboard.templates.overviewPage.BooksOverviewTemplate;
import com.schooltas.dashboard.tests.BaseClass;
import com.schooltas.dashboard.utils.ActionUtils;

public class BookEditorTests extends BaseClass{

	@Test
	public void addNewEnrichmentOnBook() throws InterruptedException{

		BooksOverviewTemplate overviewTemplate = PageFactory.initElements(driver, BooksOverviewTemplate.class);
		EditBookViewerPage bookViewerPage = PageFactory.initElements(driver, EditBookViewerPage.class);
		String ean = "3711413071302";

		dashboardMenu.clickMainMenuOption("Books");
		overviewTemplate.searchForEntityByEan(ean);
		overviewTemplate.click("| Edit");
		ActionUtils.switchwindow();
		bookViewerPage.rightClickOnThePage();
		bookViewerPage.getAddPinMenuButtons();

	}
}
