package com.schooltas.dashboard.pages.booklicenses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddBookToLicensePage {

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/form/button")
	WebElement addBookToLicenseBtn;

	@FindBy(id = "searchInput")
	WebElement searchBookField;

	@FindBy(id = "searchBtn")
	WebElement searchBtn;

	@FindBy(how = How.CSS, using = "a.btn.btn-primary.pull-right")
	WebElement nextBtn;

	@FindBy(how = How.CSS, using = "div.alert.alert-success")
	WebElement alertMessage;

	public void addBookToLicense(){

		searchBookField.sendKeys("test");
		searchBtn.click();

		addBookToLicenseBtn.click();
		nextBtn.click();
	}
}