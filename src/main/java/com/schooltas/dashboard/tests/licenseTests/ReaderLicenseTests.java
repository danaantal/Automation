package com.schooltas.dashboard.tests.licenseTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.readerlicenses.CreateReaderLicensePage;
import com.schooltas.dashboard.pages.readerlicenses.ReaderLicenseDetailsPage;
import com.schooltas.dashboard.templates.menus.DashboardMenuTemplate;
import com.schooltas.dashboard.templates.menus.LeftMenuTemplate;
import com.schooltas.dashboard.tests.BaseClass;

public class ReaderLicenseTests extends BaseClass{

	@Test
	public void createReaderLicense(){
		CreateReaderLicensePage createReaderLicensePage = PageFactory.initElements(driver, CreateReaderLicensePage.class);
		LeftMenuTemplate leftMenu = PageFactory.initElements(driver, LeftMenuTemplate.class);
		ReaderLicenseDetailsPage readerLicenseDetails = PageFactory.initElements(driver, ReaderLicenseDetailsPage.class);
		DashboardMenuTemplate dashboardMenu = PageFactory.initElements(driver, DashboardMenuTemplate.class);

		dashboardMenu.clickMainMenuOption("Reader licenses");
		leftMenu.clickMenuItem("Create Readers license");
		createReaderLicensePage.createReaderLicense();
		readerLicenseDetails.assertReaderLicenseDetails();
	}
}
