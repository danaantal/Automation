package com.schooltas.dashboard.pages.books;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.dashboard.utils.ActionUtils;

public class BooksOverviewPage {

	//	private final WebDriver driver;
	//
	//	public BooksOverviewPage(WebDriver driver){
	//		this.driver = driver;
	//	}

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/a[1]")
	public WebElement detailsBtn;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[2]/div/table/tbody/tr[2]/td[1]/a[2]")
	public WebElement editBtn;

	@FindBy(how = How.CSS, using = "ul.nav.nav-list")
	WebElement leftMenuList;

	public void clickMenuItemInBooksOverview(String menuItem){
		List<WebElement> children = leftMenuList.findElements(By.xpath(".//*"));
		ActionUtils.clickMenuItem(children, menuItem);

	}
}
