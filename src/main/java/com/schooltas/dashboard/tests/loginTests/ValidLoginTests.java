package com.schooltas.dashboard.tests.loginTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.login.LoginPage;
import com.schooltas.dashboard.tests.BaseClass;
import com.schooltas.dashboard.utils.constants.ILoginConstants;

public class ValidLoginTests extends BaseClass implements ILoginConstants{

	@Test
	public void dashboadLoginAsPublisher() {
		// Created Page Object using Page Factory
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginDashboard(TEST_PUBLISHER_EMAIL, TEST_PUBLISHER_PASS);
	}

	@Test
	public void dashboadLoginAsDistributor() {
		// Created Page Object using Page Factory
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginDashboard(TEST_DISTRIBUTOR_EMAIL, TEST_DISTRIBUTOR_PASS);
	}

	@Test
	public void dashboadLoginAsSchool() {
		// Created Page Object using Page Factory
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginDashboard(TEST_SCHOOL_EMAIL, TEST_SCHOOL_PASS);
	}

}
