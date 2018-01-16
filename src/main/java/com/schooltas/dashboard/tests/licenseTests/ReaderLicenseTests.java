package com.schooltas.dashboard.tests.licenseTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.homePage.HomePage;
import com.schooltas.dashboard.pages.readerlicenses.AddReaderToLicensePage;
import com.schooltas.dashboard.pages.readerlicenses.CreateReaderLicensePage;
import com.schooltas.dashboard.pages.readerlicenses.ReaderLicenseOverviewPage;
import com.schooltas.dashboard.pages.teacherlicenses.CreateTeacherLicensePage;
import com.schooltas.dashboard.tests.BaseClass;

public class ReaderLicenseTests extends BaseClass{
	
	@Test
	public void createReaderLicense(){
		ReaderLicenseOverviewPage readerLicenseOverview = PageFactory.initElements(driver, ReaderLicenseOverviewPage.class);
		AddReaderToLicensePage addReaderToLicensePage = PageFactory.initElements(driver, AddReaderToLicensePage.class);
		CreateReaderLicensePage createReaderLicensePage = PageFactory.initElements(driver, CreateReaderLicensePage.class);
		
		homePage.goToBookLicencesPage();
		readerLicenseOverview.createReaderLicenseBtn.click();
		addReaderToLicensePage.addReaderToLicense();
		createReaderLicensePage.createReaderLicense();
	}
}
