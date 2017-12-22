package com.schooltas.dashboard.pages.teacherlicenses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TeacherLicensesOverviewPage {

	//	private final WebDriver driver;
	//
	//	public TeacherLicensesOverviewPage (WebDriver driver) {
	//		this.driver = driver;
	//	}

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[1]/div/ul/li[4]/a")
	public WebElement createTeacherLicenseBtn;
}
