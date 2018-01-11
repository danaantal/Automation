package com.schooltas.dashboard.pages.books;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.dashboard.utils.ActionUtils;

public class BookDetailsPage {

	@FindBy(how = How.CSS, using = "ul.nav.nav-list")
	WebElement leftMenuList;

	public void clickMenuItemInBookDetails(String menuItem){
		List<WebElement> children = leftMenuList.findElements(By.xpath(".//*"));
		ActionUtils.clickMenuItem(children, menuItem);

	}
}
