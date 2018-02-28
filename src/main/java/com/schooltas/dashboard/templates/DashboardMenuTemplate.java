package com.schooltas.dashboard.templates;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardMenuTemplate {

	@FindBy(how = How.CSS, using = "ul.nav")
	private List<WebElement> dashboardMenu;

	public void clickMainMenuOption(String menuItem){

		List<WebElement> children = dashboardMenu.get(1).findElements(By.xpath(".//*"));
		findMainMenuItem(children, menuItem);
	}

	private void findMainMenuItem(List<WebElement> children, String menuItem){

		for(WebElement element : children){
			boolean isLink = element.getTagName().equals("a");
			boolean isMenuItem = element.getText().equals(menuItem);
			boolean isListItem = element.getTagName().equals("li");
			boolean isLicenseBtn = element.getText().equals("Licenses");

			if(isLink && isMenuItem) {
				element.click();
				return;
			}
			else if(isListItem && isLicenseBtn){
				element.click();
				findSubmenuItem(element, menuItem);
				return;
			}
		}
	}

	private void findSubmenuItem(WebElement element, String menuItem){

		List<WebElement> licenseChildren = element.findElements(By.xpath(".//a"));
		for(WebElement el : licenseChildren){
			boolean isMenuItem = el.getText().equals(menuItem);

			if(isMenuItem){
				el.click(); break;
			}
		}
	}
}

