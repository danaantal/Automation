package com.schooltas.dashboard.tests.readerTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.readers.CreateReaderPage;
import com.schooltas.dashboard.pages.readers.ReaderDetailsPage;
import com.schooltas.dashboard.templates.DashboardMenuTemplate;
import com.schooltas.dashboard.templates.LeftMenuTemplate;
import com.schooltas.dashboard.tests.BaseClass;

public class ReaderTests extends BaseClass {

	@Test

	public void createReader(){

		LeftMenuTemplate leftMenu = PageFactory.initElements(driver, LeftMenuTemplate.class);
		CreateReaderPage createReaderPage = PageFactory.initElements(driver, CreateReaderPage.class);
		ReaderDetailsPage readerDetailsPage = PageFactory.initElements(driver, ReaderDetailsPage.class);
		DashboardMenuTemplate dashboardMenu = PageFactory.initElements(driver, DashboardMenuTemplate.class);

		dashboardMenu.clickMainMenuOption("Readers");
		leftMenu.clickMenuItem("Create reader");
		createReaderPage.createReader();
		readerDetailsPage.assertReaderDetails();

	}
}
