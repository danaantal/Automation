package com.schooltas.dashboard.pages.teacherlicenses;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.internal.collections.Pair;

public class CreateTeacherLicensePage {

	public WebDriver driver;

	public CreateTeacherLicensePage(WebDriver driver){
		this.driver = driver;
	}

	@FindBy(id = "licenseCode.name")
	WebElement teacherlicenseNameField;

	@FindBy(id = "licenseCode.maxUsers")
	WebElement licenseMaxUsersField;

	@FindBy(how = How.CSS, using = "input.btn.btn-primary")
	WebElement saveBtn;


	public void createTeacherLicense() throws InterruptedException{

		ArrayList<Pair<WebElement, String>> licenseDetailsList = createLicenseDetailsInputList();

		licenseDetailsList.forEach((element) -> {
			element.first().clear();
			element.first().sendKeys(element.second());
		});

		saveBtn.click();
	}

	public ArrayList<Pair<WebElement, String>> createLicenseDetailsInputList(){

		ArrayList<Pair<WebElement, String>> createLicenseFormPairs = new ArrayList<>();

		createLicenseFormPairs.add(new Pair<>(teacherlicenseNameField, "Automated Teacher License"));
		createLicenseFormPairs.add(new Pair<>(licenseMaxUsersField, "10"));
		//createLicenseFormPairs.add(new Pair<>(licenseDurationCmbBox, "365"));

		return createLicenseFormPairs;
	}
}
