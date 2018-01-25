package com.schooltas.dashboard.templates.menus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardMenuTemplate {

	@FindBy(how = How.CSS, using = "ul.nav")
	public WebElement dashboardMenu;

	@FindBy(how = How.CSS, using = "ul.dropdown-menu")
	public WebElement licenseDropdown;

	public void clickMainMenuOption(String menuItem){
		List<WebElement> children = dashboardMenu.findElements(By.xpath(".//*"));
		findMainMenuItemAndClickIt(children, menuItem);
	}

	public void findMainMenuItemAndClickIt(List<WebElement> children, String menuItem){

		for(WebElement element : children){
			if(element.getTagName().equals("li")) {
				if(element.getText().equals(menuItem)){
					element.click(); break;
				}
				else if(element.getClass().equals("dropdown")){
					List<WebElement> licenseChildren = licenseDropdown.findElements(By.xpath(".//*"));
					element.click();
					for(WebElement el : licenseChildren){
						if(el.getText().equals(menuItem)){
							el.click(); break;
						}
					}
				}
			}
		}
	}
}
