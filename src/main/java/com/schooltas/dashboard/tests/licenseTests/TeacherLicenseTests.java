package com.schooltas.dashboard.tests.licenseTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.teacherlicenses.CreateTeacherLicensePage;
import com.schooltas.dashboard.pages.teacherlicenses.TeacherLicensesOverviewPage;
import com.schooltas.dashboard.tests.BaseClass;

public class TeacherLicenseTests extends BaseClass{

	@Test
	public void createTeacherLicense() throws InterruptedException{
		TeacherLicensesOverviewPage teacherLicensesPage = PageFactory.initElements(driver, TeacherLicensesOverviewPage.class);
		CreateTeacherLicensePage createTeacherLicensePage = PageFactory.initElements(driver, CreateTeacherLicensePage.class);

		homePage.goToTeacherLicensesPage();
		teacherLicensesPage.clickMenuItemInTeacherLicenseOverview("Create teacher license");
		createTeacherLicensePage.createTeacherLicense();

	}
}
