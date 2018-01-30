package com.schooltas.dashboard.templates.menus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardMenuTemplate {

	@FindBy(how = How.CSS, using = "ul.nav")
	public List<WebElement> dashboardMenu;

	@FindBy(how = How.CSS, using = "ul.dropdown-menu")
	public WebElement licenseDropdown;

	public void clickMainMenuOption(String menuItem){
		System.out.println(dashboardMenu.size());

		List<WebElement> children = dashboardMenu.get(1).findElements(By.xpath(".//*"));
		//		children.forEach(el -> {
		//			System.out.println(el.getTagName());
		//			System.out.println(el.getText());
		//		});
		findMainMenuItemAndClickIt(children, menuItem);
	}

	public void findMainMenuItemAndClickIt(List<WebElement> children, String menuItem){

		for(WebElement element : children){
			if(element.getTagName().equals("a")) {
				if(element.getText().equals(menuItem)){
					element.click();
					return;
				}
			}
			else if(element.getTagName().equals("li") && element.getText().equals("Licenses")){
				element.click();
				List<WebElement> licenseChildren = element.findElements(By.xpath(".//a"));
				for(WebElement el : licenseChildren){
					//System.out.println(el.getTagName() + el.getText());
					if(el.getText().equals(menuItem)){
						el.click();
						return;
					}
				}
			}
		}
	}
}
