package com.schooltas.dashboard.pages.books.bookEditor.addNewPin;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.dashboard.templates.bookEditor.BookEditorTemplate;
import com.schooltas.dashboard.utils.ActionUtils;

public class TextInPopupPage {

	@FindBy(how = How.CSS, using = "div.next")
	private WebElement addNewPinOptions;

	@FindBy(id = "editTextPopupHeading")
	private WebElement textInPopupPinTitleField;

	@FindBy(id = "wmd-button-bar")
	private WebElement fontStyleButtonBar;

	@FindBy(id = "wmd-input")
	private WebElement bodyTextArea;

	@FindBy(how = How.CSS, using = "button.submit-button.button.green")
	private WebElement saveBtn;

	@FindBy(how = How.CSS, using = "button.cancel-button.button.grey")
	private WebElement cancelBtn;

	@FindBy(how = How.CSS, using = "div.prikker")
	private WebElement enrichmentPin;

	@FindBy(how = How.CSS, using = "div.popover-canvas.inside-scroll")
	private WebElement viewPinCanvas;

	@FindBy(how = How.CSS, using = "button.delete-button.button.red")
	private WebElement deleteEnrichmentButton;

	@FindBy(how = How.CSS, using = "div.button.white.red")
	private WebElement confirmDeleteButton;

	@FindBy(how = How.CSS, using  = "div.loading-icon")
	private WebElement loadingIcon;

	@FindBy(how = How.CSS, using = "div.prikker-container.show-markers")
	private List<WebElement> pinOverlay;

	public void clickTextInPopupEnrichmentButton(String buttonName){

		BookEditorTemplate bookEditor = new BookEditorTemplate();
		bookEditor.clickAddNewEnrichmentButton(addNewPinOptions, buttonName);
	}

	private ArrayList<WebElement> getPinsOnThePage(){
		WebElement pageOverlay = pinOverlay.get(1);

		List<WebElement> pinsList = pageOverlay.findElements(By.xpath(".//*"));
		ArrayList<WebElement> pinsOnThePageList = new ArrayList<>();

		for(WebElement element : pinsList){

			boolean isClass = element.getTagName().equals("div");
			String nodeType = element.getAttribute("node-type");

			if(nodeType!=null && nodeType.equals("Text")) {
				if(isClass){
					pinsOnThePageList.add(element);
				}
			}
		}
		return pinsOnThePageList;
	}

	public void fillEnrichmentDetailsFields(){

		ActionUtils.waitForElement(textInPopupPinTitleField);
		textInPopupPinTitleField.sendKeys("Test title");
		bodyTextArea.sendKeys("Body text test");
		saveBtn.click();
	}

	public void deleteEnrichment() throws InterruptedException{

		ActionUtils.waitForElementInvisible(loadingIcon);
		List<WebElement> pinsOnThePageList = getPinsOnThePage();

		ActionUtils.rightClick(pinsOnThePageList.get(1));
		deleteAction();
		ActionUtils.waitForElementInvisible(pinsOnThePageList.get(1));
	}

	private void deleteAction(){
		ActionUtils.waitForElement(deleteEnrichmentButton);

		deleteEnrichmentButton.click();
		confirmDeleteButton.click();
	}

	public void verifyTitleAndText(String text){
		enrichmentPin.click();
		//assertEquals(viewPinCanvas.getText(), text);
	}
}
