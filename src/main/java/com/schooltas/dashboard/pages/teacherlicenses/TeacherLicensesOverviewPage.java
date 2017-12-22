package com.schooltas.dashboard.pages.teacherlicenses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TeacherLicensesOverviewPage {
	
	private final WebDriver driver;
	
	public TeacherLicensesOverviewPage (WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS, using = ".nav-list [href=\"#\"]")
	public WebElement createTeacherLicenseBtn;
}
