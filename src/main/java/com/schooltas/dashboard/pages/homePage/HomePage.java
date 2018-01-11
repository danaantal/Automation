package com.schooltas.dashboard.pages.homePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/ul[1]/li/a")
	public WebElement organizationName;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/ul[2]/li[2]/a")
	public WebElement booksBtn;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/ul[2]/li[3]/a")
	WebElement licensesBtn;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/ul[2]/li[3]/ul/li[1]/a")
	WebElement bookLicensesBtn;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/ul[2]/li[3]/ul/li[2]/a")
	public WebElement teacherLicensesBtn;


	public void goToBooksPage(){
		booksBtn.click();
	}

	public void goToBookLicencesPage(){
		licensesBtn.click();
		bookLicensesBtn.click();
	}

	public void goToTeacherLicensesPage(){
		licensesBtn.click();
		teacherLicensesBtn.click();
	}
}
