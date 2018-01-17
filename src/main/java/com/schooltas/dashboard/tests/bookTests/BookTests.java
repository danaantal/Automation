package com.schooltas.dashboard.tests.bookTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.books.BookDetailsPage;
import com.schooltas.dashboard.pages.books.CreateBookPage;
import com.schooltas.dashboard.templates.leftmenu.LeftMenuTemplate;
import com.schooltas.dashboard.tests.BaseClass;
import com.schooltas.dashboard.utils.ActionUtils;

public class BookTests extends BaseClass {

	@Test
	public void createBookFromBookOverviewPage() throws InterruptedException{

		CreateBookPage createBook = PageFactory.initElements(driver, CreateBookPage.class);
		LeftMenuTemplate leftMenu = PageFactory.initElements(driver, LeftMenuTemplate.class);
		BookDetailsPage bookDetails = PageFactory.initElements(driver, BookDetailsPage.class);
		String ean = String.valueOf(ActionUtils.generateIsbnRandom());

		homePage.goToBooksPage();
		leftMenu.clickMenuItem("Create book");
		createBook.createBook(ean);
		bookDetails.assertBookDetails(ean);

	}
}
