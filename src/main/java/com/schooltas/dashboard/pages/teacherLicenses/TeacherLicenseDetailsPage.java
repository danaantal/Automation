package com.schooltas.dashboard.pages.teacherLicenses;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.collections.Pair;

import com.schooltas.dashboard.templates.entityDetails.EntityDetails;

public class TeacherLicenseDetailsPage {
	private final WebDriver driver;

	public TeacherLicenseDetailsPage(WebDriver driver){
		this.driver = driver;
	}


	public void assertReaderLicenseDetails() {
		CreateTeacherLicensePage createLicense = PageFactory.initElements(driver, CreateTeacherLicensePage.class);
		EntityDetails details = PageFactory.initElements(driver, EntityDetails.class);

		ArrayList<Pair<WebElement, String>> licenseInputList = createLicense.createLicenseDetailsInputList();
		Map<String, String> licenseDetailsMap = details.createMapForDetailsPage();

		assertEquals(licenseDetailsMap.get("License name"), licenseInputList.get(0).second());
		assertEquals(licenseDetailsMap.get("Maximum users"), licenseInputList.get(1).second());
		assertNotNull(licenseDetailsMap.get("License code (bundle code)"));
	}
}
