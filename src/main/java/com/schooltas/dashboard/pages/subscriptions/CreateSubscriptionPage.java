package com.schooltas.dashboard.pages.subscriptions;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.internal.collections.Pair;

public class CreateSubscriptionPage {

	@FindBy(id = "userLimit")
	private WebElement numberOfUsersField;

	@FindBy(id = "expirationDate")
	private WebElement expirationDateField;

	@FindBy(how = How.CSS, using = "[type=\"submit\"]")
	private WebElement saveBtn;

	public void createSubscription()
	{
		numberOfUsersField.clear();
		numberOfUsersField.sendKeys("10");
		expirationDateField.sendKeys("01/01/2021");
		saveBtn.click();
	}

	public ArrayList<Pair<WebElement,String>> createSubscriptionInputList()
	{
		ArrayList<Pair<WebElement, String>> createSubscriptionFormPairs = new ArrayList<>();
		createSubscriptionFormPairs.add(new Pair<>(numberOfUsersField,"10"));
		createSubscriptionFormPairs.add(new Pair<>(expirationDateField,"05/01/2020"));

		return createSubscriptionFormPairs;
	}
}
