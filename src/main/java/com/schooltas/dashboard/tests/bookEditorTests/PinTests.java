package com.schooltas.dashboard.tests.bookEditorTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.books.bookEditor.addNewPin.ImageInPopupPage;
import com.schooltas.dashboard.pages.books.bookEditor.addNewPin.TextInPopupPage;
import com.schooltas.dashboard.templates.bookEditor.BookEditorTemplate;
import com.schooltas.dashboard.templates.overviewPage.BooksOverviewTemplate;
import com.schooltas.dashboard.tests.BaseClass;
import com.schooltas.dashboard.utils.enums.EnrichmentTypes;
import com.schooltas.dashboard.utils.utils.ActionUtils;

public class PinTests extends BaseClass{

	@Test
	public void addNewTexInPopupEnrichment() throws InterruptedException{

		BooksOverviewTemplate overviewTemplate = PageFactory.initElements(driver, BooksOverviewTemplate.class);
		TextInPopupPage textInPopupPage = PageFactory.initElements(driver, TextInPopupPage.class);
		BookEditorTemplate bookEditorTemplate = PageFactory.initElements(driver, BookEditorTemplate.class);
		String ean = "3711413071302";

		dashboardMenu.clickMainMenuOption("Books");
		overviewTemplate.searchForEntityByEan(ean);
		overviewTemplate.click("| Edit");
		ActionUtils.switchwindow();
		bookEditorTemplate.rightClickOnThePage();
		bookEditorTemplate.clickAddNewEnrichmentButton("Add new pin");
		bookEditorTemplate.clickTextInPopupEnrichmentButton("Text in popup");
		textInPopupPage.fillEnrichmentDetailsFields("Test title", "Body text test");
		bookEditorTemplate.saveEnrichment();
		ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());
		//view enrichment details
		bookEditorTemplate.viewEnrichment(EnrichmentTypes.Text);
		textInPopupPage.assertEnrichmentDetails("Test title\nBody text test");
		ActionUtils.pressEscKey();
		bookEditorTemplate.deleteEnrichment(EnrichmentTypes.Text);

		System.out.println("text in popup deleted!");
	}

	@Test
	public void addNewImageInPopupEnrichment() throws InterruptedException{
		BooksOverviewTemplate overviewTemplate = PageFactory.initElements(driver, BooksOverviewTemplate.class);
		ImageInPopupPage imageInPopupPage = PageFactory.initElements(driver, ImageInPopupPage.class);
		BookEditorTemplate bookEditorTemplate = PageFactory.initElements(driver, BookEditorTemplate.class);
		String ean = "3711413071302";

		dashboardMenu.clickMainMenuOption("Books");
		overviewTemplate.searchForEntityByEan(ean);
		overviewTemplate.click("| Edit");
		ActionUtils.switchwindow();
		bookEditorTemplate.rightClickOnThePage();
		bookEditorTemplate.clickAddNewEnrichmentButton("Add new pin");
		bookEditorTemplate.clickTextInPopupEnrichmentButton("Image in popup");
		imageInPopupPage.fillEnrichmentDetails("Test image in popup", "/Users/dantal/Downloads/PDFs/test2.jpg");
		bookEditorTemplate.saveEnrichment();
		ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());
		//view enrichment details
		bookEditorTemplate.viewEnrichment(EnrichmentTypes.Gallery);
		imageInPopupPage.assertEnrichmentDetails("Test image in popup");
		ActionUtils.pressEscKey();
		bookEditorTemplate.deleteEnrichment(EnrichmentTypes.Gallery);

	}
}
