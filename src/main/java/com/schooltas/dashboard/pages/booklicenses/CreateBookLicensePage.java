package com.schooltas.dashboard.pages.booklicenses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateBookLicensePage {

	private final WebDriver driver;

	public CreateBookLicensePage(WebDriver driver){
		this.driver = driver;
	}

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


	public void createBookLicense(){

		AddBookToLicensePage addBook = PageFactory.initElements(driver, AddBookToLicensePage.class);
		addBook.addBookToLicense();

		licenseNameField.sendKeys("test license automate");
		licenseMaxUsersField.sendKeys("10");
		licenseDurationCmbBox.sendKeys("365");
		saveBtn.click();
	}
}
