package com.schooltas.dashboard.tests.enrichmentsTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.books.bookEditor.AddNewPinPage;
import com.schooltas.dashboard.pages.books.bookEditor.EditBookViewerPage;
import com.schooltas.dashboard.templates.menus.DashboardMenuTemplate;
import com.schooltas.dashboard.templates.overviewpage.BooksOverviewTemplate;
import com.schooltas.dashboard.tests.BaseClass;
import com.schooltas.dashboard.utils.constants.ILoginConstants;

public class AddNewPinTests extends BaseClass implements ILoginConstants {

	@Test
	public void addNewTextInPopupPinThenView() throws InterruptedException {
		// Created Page Object using Page Factory
		BooksOverviewTemplate overviewPage = PageFactory.initElements(driver, BooksOverviewTemplate.class);
		EditBookViewerPage editBookViewerPage = PageFactory.initElements(driver, EditBookViewerPage.class);
		AddNewPinPage addPinPage = PageFactory.initElements(driver, AddNewPinPage.class);
		DashboardMenuTemplate dashboardMenu = PageFactory.initElements(driver, DashboardMenuTemplate.class);

		dashboardMenu.clickMainMenuOption("Books");
		overviewPage.click("Edit");
		//ActionUtils.switchwindow();

		editBookViewerPage.WaitForText(editBookViewerPage.loaderPercentage, "One moment, please... (100%)");
		editBookViewerPage.WaitForElement(editBookViewerPage.pageOverlay);
		EditBookViewerPage.rightClick(editBookViewerPage.pageOverlay);

		editBookViewerPage.WaitForElement(editBookViewerPage.addNewPinBtn);
		editBookViewerPage.addNewPinBtn.click();
		addPinPage.textInPopupBtn.click();



	}
}
