package com.schooltas.dashboard.pages.readerlicenses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddReaderToLicensePage {
	
	@FindBy(how = How.XPATH, using = "(//button[@type='submit' and contains(.,'Add')])[1]" )
	public WebElement addReaderToLicenseBtn;
	
	@FindBy(id = "searchInput")
	public WebElement searchReaderField;
	
	@FindBy(id = "searchBtn")
	public WebElement searchReaderBtn;
	
	@FindBy(how = How.CSS, using = ".btn-primary.pull-right")
	public WebElement nextStepBtn;
	
	public void addReaderToLicense(){
		searchReaderField.sendKeys("Reader");
		searchReaderBtn.click();
		addReaderToLicenseBtn.click();;
		nextStepBtn.click();
	}
}
