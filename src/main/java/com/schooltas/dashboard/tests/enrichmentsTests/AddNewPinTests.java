package com.schooltas.dashboard.tests.enrichmentsTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.books.BooksOverviewPage;
import com.schooltas.dashboard.pages.books.bookEditor.AddNewPinPage;
import com.schooltas.dashboard.pages.books.bookEditor.EditBookViewerPage;
import com.schooltas.dashboard.pages.homePage.HomePage;
import com.schooltas.dashboard.tests.BaseClass;
import com.schooltas.dashboard.utils.ILoginConstants;

public class AddNewPinTests extends BaseClass implements ILoginConstants {



	@Test
	public void addNewTextInPopupPinThenView() throws InterruptedException {
		// Created Page Object using Page Factory

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		BooksOverviewPage booksPage = PageFactory.initElements(driver, BooksOverviewPage.class);
		EditBookViewerPage editBookViewerPage = PageFactory.initElements(driver, EditBookViewerPage.class);
		AddNewPinPage addPinPage = PageFactory.initElements(driver, AddNewPinPage.class);

		homePage.booksBtn.click();
		booksPage.editBtn.click();
		//ActionUtils.switchwindow();

		//editBookViewerPage.WaitForElementToFinish(editBookViewerPage.loaderPercentage);
		editBookViewerPage.WaitForText(editBookViewerPage.loaderPercentage, "One moment, please... (100%)");
		//Thread.sleep(10000);
		editBookViewerPage.WaitForElement(editBookViewerPage.pageOverlay);
		EditBookViewerPage.rightClick(editBookViewerPage.pageOverlay);
		//editBookViewerPage.bla();

		editBookViewerPage.WaitForElement(editBookViewerPage.addNewPinBtn);
		editBookViewerPage.addNewPinBtn.click();
		addPinPage.textInPopupBtn.click();



	}
}
