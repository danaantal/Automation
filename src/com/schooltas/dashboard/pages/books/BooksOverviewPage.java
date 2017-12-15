package com.schooltas.dashboard.pages.books;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[1]/div/ul/li[4]/a")
	public WebElement createBookBtn;
}
