package com.schooltas.dashboard.pages.teacherlicenses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateTeacherLicensePage {
	
	private final WebDriver driver;

	public CreateTeacherLicensePage(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS, using = "[id$ = 'name']")
	public WebElement licenseNameField;
	
	@FindBy(how = How.CSS, using = "[id$ = 'maxUsers']")
	public WebElement licenseMaxUsersField;
	
	public void createTeacherLicense(){
		
		licenseNameField.sendKeys("Automated Teacher License");
		licenseMaxUsersField.clear();
		licenseMaxUsersField.sendKeys("5");
	}
}
