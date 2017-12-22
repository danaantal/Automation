package com.schooltas.dashboard.pages.booklicenses;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.collections.Pair;

public class CreateBookLicensePage {

	private final WebDriver driver;

	public CreateBookLicensePage(WebDriver driver) {
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



	public void createBookLicense() {

		AddBookToLicensePage addBook = PageFactory.initElements(driver, AddBookToLicensePage.class);
		addBook.addBookToLicense();

		ArrayList<Pair<WebElement, String>> licenseDetailsList = createLicenseDetailsInputList();

		licenseDetailsList.forEach((element) -> {
			//			if(!element.first().getText().equals(null)){
			//				element.first().clear();
			//				element.first().sendKeys(element.second());
			//			}
			//			else{
			element.first().sendKeys(element.second());
			//			}
		});

		saveBtn.click();
	}

	public ArrayList<Pair<WebElement, String>> createLicenseDetailsInputList(){

		ArrayList<Pair<WebElement, String>> createLicenseFormPairs = new ArrayList<>();

		createLicenseFormPairs.add(new Pair<>(licenseNameField, "license title automate"));
		createLicenseFormPairs.add(new Pair<>(licenseMaxUsersField, "10"));
		createLicenseFormPairs.add(new Pair<>(licenseDurationCmbBox, "365"));

		return createLicenseFormPairs;
	}
}
