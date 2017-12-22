package com.schooltas.dashboard.pages.booklicenses;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.collections.Pair;

public class BookLicenseDetailsPage {

	private final WebDriver driver;

	public BookLicenseDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CLASS_NAME, using = "dl-horizontal")
	WebElement licenseDetails;


	public Map<String, String> createBookLicenseDetailsMap(){

		Map<String, String> bookLicenseDetails = new HashMap<>();

		List<WebElement> childs = licenseDetails.findElements(By.xpath(".//*"));

		String detailName = null;
		for(WebElement element : childs){
			if(element.getTagName().equals("dt")){
				detailName = element.getText();
			}
			else{
				if(element.getTagName().equals("dd")){
					bookLicenseDetails.put(detailName, element.getText());
				}
			}
		}
		return bookLicenseDetails;
	}

	public void assertBookLicenseDetails() {
		CreateBookLicensePage createLicense = PageFactory.initElements(driver, CreateBookLicensePage.class);

		ArrayList<Pair<WebElement, String>> licenseDetailsList = createLicense.createLicenseDetailsInputList();
		Map<String, String> licenseDetailsMap = createBookLicenseDetailsMap();

		assertEquals(licenseDetailsMap.get("License name"), licenseDetailsList.get(0).second());

		//		for(String licenseDetail : licenseDetailsMap.values()){
		//			String elementName = licenseDetail.first().getText();
		//			assertEquals(licenseDetail.second(), licenseDetailsMap.get(elementName));
		//
		//		}
		//
		//		for(String licenseDetail : licenseDetailsMap.values()){
		//			assertEquals(licenseDetail.second(), licenseDetailsMap.get(elementName));
		//		}
	}
}
