package com.schooltas.dashboard.tests.enrichmentsTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.books.BooksOverviewPage;
import com.schooltas.dashboard.pages.books.bookEditor.AddNewPinPage;
import com.schooltas.dashboard.pages.books.bookEditor.EditBookViewerPage;
import com.schooltas.dashboard.templates.menus.DashboardMenuTemplate;
import com.schooltas.dashboard.tests.BaseClass;
import com.schooltas.dashboard.utils.ILoginConstants;

public class AddNewPinTests extends BaseClass implements ILoginConstants {



	@Test
	public void addNewTextInPopupPinThenView() throws InterruptedException {
		// Created Page Object using Page Factory
		BooksOverviewPage booksPage = PageFactory.initElements(driver, BooksOverviewPage.class);
		EditBookViewerPage editBookViewerPage = PageFactory.initElements(driver, EditBookViewerPage.class);
		AddNewPinPage addPinPage = PageFactory.initElements(driver, AddNewPinPage.class);
		DashboardMenuTemplate dashboardMenu = PageFactory.initElements(driver, DashboardMenuTemplate.class);

		dashboardMenu.clickMainMenuOption("Books");
		booksPage.editBtn.click();
		//ActionUtils.switchwindow();

		editBookViewerPage.WaitForText(editBookViewerPage.loaderPercentage, "One moment, please... (100%)");
		editBookViewerPage.WaitForElement(editBookViewerPage.pageOverlay);
		EditBookViewerPage.rightClick(editBookViewerPage.pageOverlay);

		editBookViewerPage.WaitForElement(editBookViewerPage.addNewPinBtn);
		editBookViewerPage.addNewPinBtn.click();
		addPinPage.textInPopupBtn.click();



	}
}
