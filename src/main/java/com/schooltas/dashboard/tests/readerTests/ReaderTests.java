package com.schooltas.dashboard.tests.readerTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.readers.CreateReaderPage;
import com.schooltas.dashboard.pages.readers.ReaderDetailsPage;
import com.schooltas.dashboard.templates.menus.LeftMenuTemplate;
import com.schooltas.dashboard.tests.BaseClass;

public class ReaderTests extends BaseClass {
	
	@Test
	
	public void createReader(){
		
		LeftMenuTemplate leftMenu = PageFactory.initElements(driver, LeftMenuTemplate.class);
		CreateReaderPage createReaderPage = PageFactory.initElements(driver, CreateReaderPage.class);
		ReaderDetailsPage readerDetailsPage = PageFactory.initElements(driver, ReaderDetailsPage.class);
		
		homePage.goToReadersPage();
		leftMenu.clickMenuItem("Create reader");
		createReaderPage.createReader();
		readerDetailsPage.assertReaderDetails();
				
	}
}
