package com.schooltas.dashboard.pages.books.bookEditor.bookViewer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.dashboard.templates.bookEditor.BookEditorTemplate;
import com.schooltas.dashboard.utils.ActionUtils;

public class BookViewerPage {
	//
	//	private static WebDriver driver;
	//
	//	public BookViewerPage(WebDriver driver) {
	//		BookViewerPage.driver = driver;
	//	}

	@FindBy(id = "book-settings-button")
	private WebElement bookPageSettingsBtn;

	@FindBy(how = How.CSS, using = "div.prev")
	private WebElement addPinsMainMenu;

	@FindBy(how = How.CSS, using = "div.prikker-container.show-markers")
	private List<WebElement> pageOverlay;
	//
	//	@FindBy(css = ".alert-popup.alert-text")
	//	// @FindBy(css=".alert.show")
	//	public WebElement loaderPercentage;
	//
	//	@FindBy(id = "booktitle-popup")
	//	private WebElement bookTitlePopup;

	public void rightClickOnThePage() throws InterruptedException{
		Thread.sleep(7000);
		ActionUtils.rightClick(pageOverlay.get(1));
	}

	public void clickAddNewEnrichmentButton(String buttonName){

		BookEditorTemplate bookEditor = new BookEditorTemplate();
		bookEditor.clickAddNewEnrichmentButton(addPinsMainMenu, buttonName);
	}
}
