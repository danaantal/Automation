package com.schooltas.dashboard.pages.booklicenses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BookLicensesOverviewPage {

	//	private final WebDriver driver;
	//
	//	public BookLicensesOverviewPage(WebDriver driver){
	//		this.driver = driver;
	//	}

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/a")
	private WebElement bookLicenseItem;

	public void clickLicense(){
		bookLicenseItem.click();
	}

}
