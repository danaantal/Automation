package com.schooltas.dashboard.pages.readerLicenses;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.collections.Pair;

public class CreateReaderLicensePage {

	private final WebDriver driver;

	public CreateReaderLicensePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "licenseCode.name")
	private WebElement licenseNameField;

	@FindBy(id = "licenseCode.maxUsers")
	private WebElement maxUserField;

	@FindBy(how = How.CSS, using = "[type=\"submit\"]")
	private WebElement saveBtn;

	public void createReaderLicense(){

		AddReaderToLicensePage addReader = PageFactory.initElements(driver, AddReaderToLicensePage.class);
		addReader.addReaderToLicense();

		ArrayList<Pair<WebElement, String>> licenseDetailsList = createLicenseDetailsInputList();

		licenseDetailsList.forEach((element) -> {
			element.first().clear();
			element.first().sendKeys(element.second());
		});

		saveBtn.click();
	}

	public ArrayList<Pair<WebElement, String>> createLicenseDetailsInputList(){

		ArrayList<Pair<WebElement, String>> createLicenseFormPairs = new ArrayList<>();

		createLicenseFormPairs.add(new Pair<>(licenseNameField, "Automated Reader License"));
		createLicenseFormPairs.add(new Pair<>(maxUserField, "10"));

		return createLicenseFormPairs;
	}
}
