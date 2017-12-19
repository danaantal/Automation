package com.schooltas.dashboard.tests.licenseTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.homePage.HomePage;
import com.schooltas.dashboard.pages.licenses.CreateLicensePage;
import com.schooltas.dashboard.pages.licenses.LicensesOverviewPage;
import com.schooltas.dashboard.tests.BaseClass;

public class LicenseTests extends BaseClass{

	@Test
	public void createBookLicense(){
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		LicensesOverviewPage licensesPage = PageFactory.initElements(driver, LicensesOverviewPage.class);
		CreateLicensePage createLicensePage = PageFactory.initElements(driver, CreateLicensePage.class);

		homePage.goToBookLicencesPage();
		licensesPage.createBookLicenseBtn.click();
		createLicensePage.createBookLicense();

	}
}
