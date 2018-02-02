package com.schooltas.dashboard.tests.bookTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.books.BookDetailsPage;
import com.schooltas.dashboard.pages.books.CreateBookPage;
import com.schooltas.dashboard.pages.books.EditBookPage;
import com.schooltas.dashboard.templates.overviewpage.BooksOverviewTemplate;
import com.schooltas.dashboard.tests.BaseClass;
import com.schooltas.dashboard.utils.ActionUtils;

public class BookTests extends BaseClass {

	@Test
	public void createBookFromBookOverviewPage() throws InterruptedException{

		CreateBookPage createBook = PageFactory.initElements(driver, CreateBookPage.class);
		BookDetailsPage bookDetails = PageFactory.initElements(driver, BookDetailsPage.class);
		String ean = String.valueOf(ActionUtils.generateIsbnRandom());

		dashboardMenu.clickMainMenuOption("Books");
		leftMenu.clickMenuItem("Create book");
		createBook.createBook(ean);
		bookDetails.assertBookDetails(ean, true);
	}

	@Test
	public void editBookFromOverviewPage(){

		BooksOverviewTemplate overviewTemplate = PageFactory.initElements(driver, BooksOverviewTemplate.class);
		EditBookPage editBook = PageFactory.initElements(driver, EditBookPage.class);
		BookDetailsPage bookDetails = PageFactory.initElements(driver, BookDetailsPage.class);
		String ean = "3711413071302";

		dashboardMenu.clickMainMenuOption("Books");
		overviewTemplate.searchForEntityByEan(ean);
		overviewTemplate.click("Details");
		leftMenu.clickMenuItem("Edit book");
		editBook.editBook();
		bookDetails.assertBookDetails(ean, false);
	}
}
