package com.schooltas.dashboard.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.schooltas.dashboard.pages.home.HomePage;
import com.schooltas.dashboard.templates.DashboardMenuTemplate;
import com.schooltas.dashboard.templates.LeftMenuTemplate;
import com.schooltas.dashboard.utils.constants.ILoginConstants;
import com.schooltas.dashboard.utils.utils.ActionUtils;
import com.schooltas.dashboard.utils.utils.BrowserFactory;

public abstract class BaseClass implements ILoginConstants{

	protected static WebDriver driver;
	protected HomePage homePage;
	protected DashboardMenuTemplate dashboardMenu;
	protected LeftMenuTemplate leftMenu;

	@BeforeTest
	public final void beforeTest() {
		System.out.println("BeforeTest");
		System.setProperty("webdriver.chrome.driver", "/Users/dantal/Desktop/chromedriver");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ccostea\\Documents\\chromedriver.exe");
		driver = BrowserFactory.startBrowser("chrome", "https://backend-test.schooltas.net/dashboard");
		ActionUtils.loginAs("publisher");
		homePage = PageFactory.initElements(driver, HomePage.class);
		leftMenu = PageFactory.initElements(driver, LeftMenuTemplate.class);
		dashboardMenu = PageFactory.initElements(driver, DashboardMenuTemplate.class);
	}

	@AfterTest
	public final void afterTest() {
		// Close the instance of browser
		driver.quit();
	}

}
