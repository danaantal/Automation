package com.schooltas.dashboard.pages.books.bookEditor.addNewPin;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.schooltas.dashboard.pages.books.enrichments.Enrichment;
import com.schooltas.dashboard.templates.bookEditor.BookEditorTemplate;
import com.schooltas.dashboard.utils.utils.ActionUtils;

public class ImageInPopupPage extends Enrichment{

	private final WebDriver driver;

	public ImageInPopupPage(WebDriver driver){
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "input.st-textinput.full")
	private List<WebElement> imagePopupTitleField;

	@FindBy(how = How.XPATH, using = "//input[@type='file']")
	private WebElement uploadImageButton;

	@FindBy(how = How.CSS, using = "h3.reset.image-title")
	private WebElement popupHeader;

	@FindBy(how = How.CSS, using  = "div.image-popup-viewer.shown")
	private WebElement imageViewer;


	public void fillEnrichmentDetails(String title, String path){

		ActionUtils.waitForElement(imagePopupTitleField.get(0));

		imagePopupTitleField.get(0).sendKeys(title);
		uploadImageButton.sendKeys(path);
	}

	public void assertEnrichmentDetails(String text) {

		BookEditorTemplate bookEditorTemplate = PageFactory.initElements(driver, BookEditorTemplate.class);
		ActionUtils.waitForElement(bookEditorTemplate.getPopupHeader());
		assertEquals(bookEditorTemplate.getPopupHeader().getText(), text);
	}
}
