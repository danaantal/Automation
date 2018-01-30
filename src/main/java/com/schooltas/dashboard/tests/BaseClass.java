package com.schooltas.dashboard.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.schooltas.dashboard.pages.homePage.HomePage;
import com.schooltas.dashboard.utils.ActionUtils;
import com.schooltas.dashboard.utils.BrowserFactory;
import com.schooltas.dashboard.utils.ILoginConstants;

public abstract class BaseClass implements ILoginConstants{

	protected static WebDriver driver;
	protected HomePage homePage;

	@BeforeTest
	public final void beforeTest() {
		System.out.println("BeforeTest");
		//System.setProperty("webdriver.chrome.driver", "/Users/dantal/Desktop/chromedriver");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ccostea\\Documents\\chromedriver.exe");
		driver = BrowserFactory.startBrowser("chrome", "https://backend-test.schooltas.net/dashboard");
		ActionUtils.loginAs("school");
		homePage = PageFactory.initElements(driver, HomePage.class);
	}

	@AfterTest
	public final void afterTest() {
		// Close the instance of browser
		driver.quit();
	}

}
