package com.schooltas.dashboard.templates.bookEditor;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookEditorTemplate {


	private ArrayList<WebElement> getAddPinMenuButtonList(WebElement webelement){

		List<WebElement> mainMenuChildren = webelement.findElements(By.xpath(".//*"));
		ArrayList<WebElement> addPinButtonsList = new ArrayList<>();

		for(WebElement element : mainMenuChildren){

			boolean isButton = element.getTagName().equals("button");

			if(isButton)
			{
				addPinButtonsList.add(element);
			}
		}
		return addPinButtonsList;
	}

	public void clickAddNewEnrichmentButton(WebElement webelement, String buttonName){

		ArrayList<WebElement> addPinButtonsList = getAddPinMenuButtonList(webelement);

		for(WebElement element : addPinButtonsList){

			boolean isButtonName = element.getText().equals(buttonName);
			if(isButtonName){
				element.click();
				return;
			}
		}
	}
}
