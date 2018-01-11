package com.schooltas.dashboard.tests.bookTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.books.BooksOverviewPage;
import com.schooltas.dashboard.pages.books.CreateBookPage;
import com.schooltas.dashboard.tests.BaseClass;

public class BookTests extends BaseClass {

	@Test
	public void createBookFromBookOverviewPage() throws InterruptedException{
		BooksOverviewPage booksOverview = PageFactory.initElements(driver, BooksOverviewPage.class);
		CreateBookPage createBook = PageFactory.initElements(driver, CreateBookPage.class);

		homePage.goToBooksPage();
		booksOverview.clickMenuItemInBooksOverview("Create book");
		createBook.createBook();

	}
}