package com.schooltas.dashboard.tests.licenseTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.homePage.HomePage;
import com.schooltas.dashboard.pages.teacherlicenses.CreateTeacherLicensePage;
import com.schooltas.dashboard.pages.teacherlicenses.TeacherLicensesOverviewPage;
import com.schooltas.dashboard.tests.BaseClass;

public class TeacherLicenseTests extends BaseClass{

	@Test
	public void createTeacherLicense() throws InterruptedException{

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TeacherLicensesOverviewPage teacherLicensesPage = PageFactory.initElements(driver, TeacherLicensesOverviewPage.class);
		CreateTeacherLicensePage createTeacherLicensePage = PageFactory.initElements(driver, CreateTeacherLicensePage.class);

		homePage.goToTeacherLicensesPage();
		teacherLicensesPage.createTeacherLicenseBtn.click();
		createTeacherLicensePage.createTeacherLicense();

	}
}
