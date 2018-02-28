package com.schooltas.dashboard.tests.licenseTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.bookLicenses.BookLicenseDetailsPage;
import com.schooltas.dashboard.pages.bookLicenses.BookLicensesOverviewPage;
import com.schooltas.dashboard.pages.bookLicenses.CreateBookLicensePage;
import com.schooltas.dashboard.templates.DashboardMenuTemplate;
import com.schooltas.dashboard.templates.LeftMenuTemplate;
import com.schooltas.dashboard.tests.BaseClass;

public class LicenseTests extends BaseClass{

	@Test
	public void createBookLicense(){
		CreateBookLicensePage createLicensePage = PageFactory.initElements(driver, CreateBookLicensePage.class);
		BookLicenseDetailsPage licenseDetailsPage = PageFactory.initElements(driver, BookLicenseDetailsPage.class);
		LeftMenuTemplate leftMenu = PageFactory.initElements(driver, LeftMenuTemplate.class);
		DashboardMenuTemplate dashboardMenu = PageFactory.initElements(driver, DashboardMenuTemplate.class);

		dashboardMenu.clickMainMenuOption("Book licenses");
		leftMenu.clickMenuItem("Create Books license");
		createLicensePage.createBookLicense();
		licenseDetailsPage.assertBookLicenseDetails();
	}

	@Test
	public void editBookLicense(){
		BookLicensesOverviewPage licensesPage = PageFactory.initElements(driver, BookLicensesOverviewPage.class);
		LeftMenuTemplate leftMenu = PageFactory.initElements(driver, LeftMenuTemplate.class);
		DashboardMenuTemplate dashboardMenu = PageFactory.initElements(driver, DashboardMenuTemplate.class);

		dashboardMenu.clickMainMenuOption("Book licenses");
		licensesPage.clickLicense();
		leftMenu.clickMenuItem("Create Books license");
	}
}
