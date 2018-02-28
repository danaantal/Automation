package com.schooltas.dashboard.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	//	private final WebDriver driver;
	//
	//	public LoginPage(WebDriver driver){
	//		this.driver = driver;
	//	}

	@FindBy(name="email")
	private WebElement emailAddressField;

	@FindBy(name="password")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using="/html/body/div[2]/form/button")
	private WebElement signInbutton;


	public void loginDashboard(String email, String password){
		emailAddressField.sendKeys(email);
		passwordField.sendKeys(password);
		signInbutton.click();
		//HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//assertTrue(homePage.organizationName.isDisplayed());
	}
}
