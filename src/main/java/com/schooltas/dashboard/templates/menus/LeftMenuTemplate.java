package com.schooltas.dashboard.templates.menus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftMenuTemplate {

	@FindBy(how = How.CSS, using = "ul.nav.nav-list")
	public WebElement leftMenuList;

	public void clickMenuItem(String menuItem){
		List<WebElement> children = leftMenuList.findElements(By.xpath(".//*"));
		findMenuItemAndClickIt(children, menuItem);
	}

	public void findMenuItemAndClickIt(List<WebElement> children, String menuItem){

		for(WebElement element : children){
			if(element.getTagName().equals("li")) {
				if(element.getText().equals(menuItem)){
					element.click(); break;
				}
			}
		}
	}
}
