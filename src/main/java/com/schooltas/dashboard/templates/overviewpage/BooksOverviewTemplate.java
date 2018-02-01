package com.schooltas.dashboard.templates.overviewpage;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BooksOverviewTemplate {

	@FindBy(how = How.CLASS_NAME, using = ".table.table-striped.table-bordered")
	private WebElement booksTable;

	@FindBy(id = "searchInput")
	private WebElement searchInput;

	@FindBy(id = "searchButton")
	private WebElement searchButton;

	@FindBy(how = How.CSS, using = "tr.link")
	private WebElement links;

	public void searchForEntityByEan(String ean){
		searchInput.sendKeys(ean);
		searchButton.click();
		//assert ean
	}

	public void click(String button){
		List<WebElement> linksList = links.findElements(By.xpath(".//a"));
		for(WebElement element : linksList){
			boolean isMenuItem = element.getText().equals(button);
			if(isMenuItem){
				element.click();
				return;
			}
		}
	}

}
