package com.schooltas.dashboard.pages.teacherlicenses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.dashboard.utils.ActionUtils;

public class TeacherLicensesOverviewPage {

	//	private final WebDriver driver;
	//
	//	public TeacherLicensesOverviewPage (WebDriver driver) {
	//		this.driver = driver;
	//	}

	@FindBy(how = How.CSS, using = "ul.nav.nav-list")
	WebElement leftMenuList;

	public void clickMenuItemInTeacherLicenseOverview(String menuItem){
		List<WebElement> children = leftMenuList.findElements(By.xpath(".//*"));
		ActionUtils.clickMenuItem(children, menuItem);

	}



}
