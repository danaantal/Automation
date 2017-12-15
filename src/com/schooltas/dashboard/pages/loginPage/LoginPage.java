package com.schooltas.dashboard.pages.loginPage;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.schooltas.dashboard.pages.homePage.HomePage;

public class LoginPage {

	private final WebDriver driver;

	public LoginPage(WebDriver driver){
		this.driver = driver;
	}

	@FindBy(name="email")
	WebElement emailAddressField;

	@FindBy(name="password")
	WebElement passwordField;

	@FindBy(how = How.XPATH, using="/html/body/div[2]/form/button")
	WebElement signInbutton;


	public void loginDashboard(String email, String password){
		emailAddressField.sendKeys(email);
		passwordField.sendKeys(password);
		signInbutton.click();
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		assertTrue(homePage.organizationName.isDisplayed());
	}
}
