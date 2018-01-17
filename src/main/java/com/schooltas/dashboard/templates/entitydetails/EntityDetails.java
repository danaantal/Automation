package com.schooltas.dashboard.templates.entitydetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EntityDetails {

	@FindBy(how = How.CLASS_NAME, using = "dl-horizontal")
	WebElement entityDetails;

	public Map<String, String> createEntityDetailsMap(){

		Map<String, String> detailsMap = new HashMap<>();

		List<WebElement> childs = entityDetails.findElements(By.xpath(".//*"));

		String detailName = null;
		for(WebElement element : childs){
			if(element.getTagName().equals("dt")){
				detailName = element.getText();
			}
			else{
				if(element.getTagName().equals("dd")){
					detailsMap.put(detailName, element.getText());
				}
			}
		}
		return detailsMap;
	}
}
