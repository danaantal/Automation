package com.schooltas.dashboard.pages.readerLicenses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddReaderToLicensePage {

	private final WebDriver driver;

	public AddReaderToLicensePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "(//button[@type='submit' and contains(.,'Add')])[1]" )
	private WebElement addReaderToLicenseBtn;

	@FindBy(id = "searchInput")
	private WebElement searchReaderField;

	@FindBy(id = "searchBtn")
	private WebElement searchReaderBtn;

	@FindBy(how = How.CSS, using = ".btn-primary.pull-right")
	private WebElement nextStepBtn;

	public void addReaderToLicense(){
		searchReaderField.sendKeys("Reader");
		searchReaderBtn.click();
		addReaderToLicenseBtn.click();;
		nextStepBtn.click();
	}
}
