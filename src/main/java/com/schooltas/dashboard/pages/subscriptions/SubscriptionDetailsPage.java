package com.schooltas.dashboard.pages.subscriptions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.collections.Pair;

import com.schooltas.dashboard.templates.entitydetails.EntityDetails;

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
