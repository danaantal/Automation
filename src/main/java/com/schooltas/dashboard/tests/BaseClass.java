package com.schooltas.dashboard.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.schooltas.dashboard.utils.ActionUtils;
import com.schooltas.dashboard.utils.BrowserFactory;
import com.schooltas.dashboard.utils.ILoginConstants;

public abstract class BaseClass implements ILoginConstants{

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// //This creates an dynamic firefox object (an instance of firefox)
	// System.setProperty("webdriver.chrome.driver","/Users/dantal/Desktop/chromedriver");
	// WebDriver driver = new ChromeDriver();
	//
	// //Close the instance of browser
	// driver.close();
	// }

	protected static WebDriver driver;

	@BeforeTest
	public final void beforeTest() {
		System.out.println("BeforeTest");
		System.setProperty("webdriver.chrome.driver", "/Users/dantal/Desktop/chromedriver");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ccostea\\Documents\\chromedriver.exe");
		driver = BrowserFactory.startBrowser("chrome", "https://backend-test.schooltas.net/dashboard");
		ActionUtils.loginAs("publisher");
	}

	@AfterTest
	public final void afterTest() {
		// Close the instance of browser
		driver.quit();
	}

}
