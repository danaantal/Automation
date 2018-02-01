package com.schooltas.dashboard.pages.booklicenses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddBookToLicensePage {

	@FindBy(how = How.XPATH, using = "//*[@id='mainContent']/table/tbody/tr[1]/td[1]/form/button")
	private WebElement addBookToLicenseBtn;

	@FindBy(id = "searchInput")
	private WebElement searchBookField;

	@FindBy(id = "searchBtn")
	private WebElement searchBtn;

	@FindBy(how = How.CSS, using = "a.btn.btn-primary.pull-right")
	private WebElement nextBtn;

	@FindBy(how = How.CSS, using = "div.alert.alert-success")
	private WebElement alertMessage;

	public void addBookToLicense(){

		searchBookField.sendKeys("test");
		searchBtn.click();

		addBookToLicenseBtn.click();
		nextBtn.click();
	}
}
