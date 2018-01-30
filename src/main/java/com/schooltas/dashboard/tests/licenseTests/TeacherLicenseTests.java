package com.schooltas.dashboard.tests.licenseTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.teacherlicenses.CreateTeacherLicensePage;
import com.schooltas.dashboard.pages.teacherlicenses.TeacherLicenseDetailsPage;
import com.schooltas.dashboard.templates.menus.DashboardMenuTemplate;
import com.schooltas.dashboard.templates.menus.LeftMenuTemplate;
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
