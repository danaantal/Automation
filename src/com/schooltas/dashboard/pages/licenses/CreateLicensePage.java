package com.schooltas.dashboard.pages.licenses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateLicensePage {

	@FindBy(id = "licenseCode.name")
	WebElement licenseNameField;

	@FindBy(id = "licenseCode.maxUsers")
	WebElement licenseMaxUsersField;

	@FindBy(id = "licenseCode.licenseDuration")
	WebElement licenseDurationCmbBox;

	@FindBy(id = "licenseCode.expirationDate")
	WebElement licenseExpirationDatePicker;

	@FindBy(how = How.CSS, using = "input.btn.btn-primary")
	WebElement saveBtn;
}
