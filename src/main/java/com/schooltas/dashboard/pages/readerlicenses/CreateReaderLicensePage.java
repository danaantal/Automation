package com.schooltas.dashboard.pages.readerlicenses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateReaderLicensePage {
	
	@FindBy(id = "licenseCode.name")
	public WebElement licenseNameField;
	
	@FindBy(id = "licenseCode.maxUsers")
	public WebElement maxUserField;
	
	@FindBy(how = How.CSS, using = "[type=\"submit\"]")
	public WebElement saveBtn;
	
	public void createReaderLicense(){
		licenseNameField.clear();
		licenseNameField.sendKeys("Automated Reader License");
		maxUserField.clear();
		maxUserField.sendKeys("5");
		saveBtn.click();
	}
}
