package com.schooltas.dashboard.pages.licenses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LicenseOverviewPage {

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[1]/div/ul/li[4]/a")
	WebElement createBookLicenseBtn;

	
}
