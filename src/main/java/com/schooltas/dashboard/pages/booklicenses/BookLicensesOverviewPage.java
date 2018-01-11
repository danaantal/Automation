package com.schooltas.dashboard.pages.booklicenses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.dashboard.utils.ActionUtils;

public class BookLicensesOverviewPage {

	private final WebDriver driver;

	public BookLicensesOverviewPage(WebDriver driver){
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/a")
	public WebElement bookLicenseItem;

	@FindBy(how = How.CSS, using = "ul.nav.nav-list")
	WebElement leftMenuList;

	public void clickMenuItemInLicenseOverview(String menuItem){
		List<WebElement> children = leftMenuList.findElements(By.xpath(".//*"));
		ActionUtils.clickMenuItem(children, menuItem);
	}

	public void clickLicense(){
		bookLicenseItem.click();
	}

}
