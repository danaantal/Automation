package com.schooltas.dashboard.pages.subscriptions;

import org.openqa.selenium.WebDriver;

public class SubscriptionDetailsPage {

	private final WebDriver driver;
	public SubscriptionDetailsPage(WebDriver driver){
		this.driver = driver;
	}

	//	public void assertSubscriptionDetails()
	//	{
	//		CreateSubscriptionPage createSubscriptionPage = PageFactory.initElements(driver, CreateSubscriptionPage.class);
	//		EntityDetails entityDetails = PageFactory.initElements(driver, EntityDetails.class);
	//
	//		ArrayList<Pair<WebElement, String>> subscriptionsInputList = createSubscriptionPage.createSubscriptionInputList();
	//		Map<String,String> subscriptionDetailsMap = entityDetails.createEntityDetailsMap();
	//
	//		assertEquals(subscriptionDetailsMap.get("Maximum users"), subscriptionsInputList.get());
	//	}
}
