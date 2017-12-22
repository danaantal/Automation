package com.schooltas.dashboard.pages.teacherlicenses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

		//waitForElement(teacherlicenseNameField);
		teacherlicenseNameField.sendKeys("Automated Teacher License");
		licenseMaxUsersField.clear();
		licenseMaxUsersField.sendKeys("5");
		saveBtn.click();
	}

	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
