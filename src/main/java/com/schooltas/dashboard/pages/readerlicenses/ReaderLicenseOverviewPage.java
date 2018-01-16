package com.schooltas.dashboard.pages.readerlicenses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ReaderLicenseOverviewPage {
	
	@FindBy(how = How.XPATH, using = "//a[@href='/dashboard/licenses/edit-books?isNewLicenseFlow=true']")
	public WebElement createReaderLicenseBtn;
}
