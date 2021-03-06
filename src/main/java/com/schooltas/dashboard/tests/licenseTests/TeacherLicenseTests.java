package com.schooltas.dashboard.tests.licenseTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.teacherLicenses.CreateTeacherLicensePage;
import com.schooltas.dashboard.pages.teacherLicenses.TeacherLicenseDetailsPage;
import com.schooltas.dashboard.templates.DashboardMenuTemplate;
import com.schooltas.dashboard.templates.LeftMenuTemplate;
import com.schooltas.dashboard.tests.BaseClass;

public class TeacherLicenseTests extends BaseClass{

	@Test
	public void createTeacherLicense(){

		CreateTeacherLicensePage createTeacherLicensePage = PageFactory.initElements(driver, CreateTeacherLicensePage.class);
		LeftMenuTemplate leftMenu = PageFactory.initElements(driver, LeftMenuTemplate.class);
		TeacherLicenseDetailsPage teacherLicenseDetails =  PageFactory.initElements(driver, TeacherLicenseDetailsPage.class);
		DashboardMenuTemplate dashboardMenu = PageFactory.initElements(driver, DashboardMenuTemplate.class);

		dashboardMenu.clickMainMenuOption("Teacher licenses");
		leftMenu.clickMenuItem("Create teacher license");
		createTeacherLicensePage.createTeacherLicense();
		teacherLicenseDetails.assertReaderLicenseDetails();
	}
}
