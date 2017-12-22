package com.schooltas.dashboard.tests.licenseTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.booklicenses.BookLicenseDetailsPage;
import com.schooltas.dashboard.pages.booklicenses.BookLicensesOverviewPage;
import com.schooltas.dashboard.pages.booklicenses.CreateBookLicensePage;
import com.schooltas.dashboard.pages.homePage.HomePage;
import com.schooltas.dashboard.tests.BaseClass;

public class LicenseTests extends BaseClass{

	@Test
	public void createBookLicense(){
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		BookLicensesOverviewPage licensesPage = PageFactory.initElements(driver, BookLicensesOverviewPage.class);
		CreateBookLicensePage createLicensePage = PageFactory.initElements(driver, CreateBookLicensePage.class);
		BookLicenseDetailsPage licenseDetailsPage = PageFactory.initElements(driver, BookLicenseDetailsPage.class);

		homePage.goToBookLicencesPage();
		licensesPage.createBookLicenseBtn.click();
		createLicensePage.createBookLicense();
		licenseDetailsPage.assertBookLicenseDetails();
	}
}
