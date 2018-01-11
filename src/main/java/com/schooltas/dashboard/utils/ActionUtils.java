package com.schooltas.dashboard.utils;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.schooltas.dashboard.pages.loginPage.LoginPage;
import com.schooltas.dashboard.tests.BaseClass;

public class ActionUtils extends BaseClass {

	public static void switchwindow() {
		try {

			// String winHandleBefore = driver.getWindowHandle();

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
		} catch (Exception e) {
			// return Constants.KEYWORD_FAIL+ "Unable to Switch Window" +
			// e.getMessage();
		}
		// return Constants.KEYWORD_PASS;
	}

	public static void clickMenuItem(List<WebElement> children, String menuItem){

		for(WebElement element : children){
			if(element.getTagName().equals("li")) {
				if(element.getText().equals(menuItem)){
					element.click(); break;
				}
			}
		}
	}

	public static void loginAs(String organization) {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		if (organization == "publisher") {
			loginPage.loginDashboard(TEST_PUBLISHER_EMAIL, TEST_PUBLISHER_PASS);
		} else if (organization == "distributor") {
			loginPage.loginDashboard(TEST_DISTRIBUTOR_EMAIL, TEST_DISTRIBUTOR_PASS);
		} else if (organization == "school") {
			loginPage.loginDashboard(TEST_SCHOOL_EMAIL, TEST_SCHOOL_PASS);
		}
	}


}
