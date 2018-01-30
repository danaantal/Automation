package com.schooltas.dashboard.tests.subscriptionsTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.subscriptions.CreateSubscriptionPage;
import com.schooltas.dashboard.templates.menus.DashboardMenuTemplate;
import com.schooltas.dashboard.templates.menus.LeftMenuTemplate;
import com.schooltas.dashboard.tests.BaseClass;

public class SubscriptionTests extends BaseClass{

	@Test
	public void createSubscription()
	{
		CreateSubscriptionPage createSubscriptionPage = PageFactory.initElements(driver, CreateSubscriptionPage.class);
		LeftMenuTemplate leftMenuTemplate = PageFactory.initElements(driver, LeftMenuTemplate.class);
		DashboardMenuTemplate dashboardMenu = PageFactory.initElements(driver, DashboardMenuTemplate.class);

		dashboardMenu.clickMainMenuOption("Subscriptions");
		leftMenuTemplate.clickMenuItem("Create subscription");
		createSubscriptionPage.createSubscription();
	}
}
