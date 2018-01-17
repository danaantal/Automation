package com.schooltas.dashboard.tests.licenseTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.booklicenses.BookLicenseDetailsPage;
import com.schooltas.dashboard.pages.booklicenses.BookLicensesOverviewPage;
import com.schooltas.dashboard.pages.booklicenses.CreateBookLicensePage;
import com.schooltas.dashboard.templates.leftmenu.LeftMenuTemplate;
import com.schooltas.dashboard.tests.BaseClass;

public class LicenseTests extends BaseClass{

	@Test
	public void createBookLicense(){
		//BookLicensesOverviewPage licensesPage = PageFactory.initElements(driver, BookLicensesOverviewPage.class);
		CreateBookLicensePage createLicensePage = PageFactory.initElements(driver, CreateBookLicensePage.class);
		BookLicenseDetailsPage licenseDetailsPage = PageFactory.initElements(driver, BookLicenseDetailsPage.class);
		LeftMenuTemplate leftMenu = PageFactory.initElements(driver, LeftMenuTemplate.class);

		homePage.goToBookLicencesPage();
		leftMenu.clickMenuItem("Create Books license");
		createLicensePage.createBookLicense();
		licenseDetailsPage.assertBookLicenseDetails();
	}

	@Test
	public void editBookLicense(){
		BookLicensesOverviewPage licensesPage = PageFactory.initElements(driver, BookLicensesOverviewPage.class);
		//CreateBookLicensePage createLicensePage = PageFactory.initElements(driver, CreateBookLicensePage.class);
		//BookLicenseDetailsPage licenseDetailsPage = PageFactory.initElements(driver, BookLicenseDetailsPage.class);
		LeftMenuTemplate leftMenu = PageFactory.initElements(driver, LeftMenuTemplate.class);

		homePage.goToBookLicencesPage();
		licensesPage.clickLicense();
		leftMenu.clickMenuItem("Create Books license");
	}
}
