package com.schooltas.dashboard.templates.bookEditor;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.dashboard.utils.enums.EnrichmentTypes;
import com.schooltas.dashboard.utils.utils.ActionUtils;

public class BookEditorTemplate {

	private final WebDriver driver;

	public BookEditorTemplate(WebDriver driver){
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "button.submit-button.button.green")
	private WebElement saveBtn;

	@FindBy(how = How.CSS, using = "button.cancel-button.button.grey")
	private WebElement cancelBtn;

	@FindBy(how = How.CSS, using  = "div.loading-icon")
	private WebElement loadingIcon;

	@FindBy(how = How.CSS, using = "div.prikker-container.show-markers")
	private List<WebElement> pinOverlay;

	@FindBy(how = How.CSS, using = "button.delete-button.button.red")
	private WebElement deleteEnrichmentButton;

	@FindBy(how = How.CSS, using = "div.button.white.red")
	private WebElement confirmDeleteButton;

	@FindBy(how = How.CSS, using = "div.popover-canvas.inside-scroll")
	private WebElement viewPinCanvas;

	@FindBy(how = How.CSS, using = "h3.reset.image-title")
	private WebElement popupHeader;

	@FindBy(id = "book-settings-button")
	private WebElement bookPageSettingsBtn;

	@FindBy(how = How.CSS, using = "div.prev")
	private WebElement addPinsMainMenu;

	@FindBy(how = How.CSS, using = "div.prikker-container.show-markers")
	private List<WebElement> pageOverlay;

	@FindBy(how = How.CSS, using = "div.next")
	private WebElement addNewPinOptions;


	public void rightClickOnThePage() throws InterruptedException{
		Thread.sleep(7000);
		ActionUtils.rightClick(pageOverlay.get(1));
	}

	public void clickAddNewEnrichmentButton(String buttonName){

		clickAddNewEnrichmentButton(addPinsMainMenu, buttonName);
	}

	public void clickTextInPopupEnrichmentButton(String buttonName){

		clickAddNewEnrichmentButton(addNewPinOptions, buttonName);
	}

	public void saveEnrichment(){
		ActionUtils.waitForElementToBeClickable(saveBtn);
		saveBtn.click();
	}

	public void cancel(){
		ActionUtils.waitForElementToBeClickable(cancelBtn);
		cancelBtn.click();
	}

	public void viewEnrichment(EnrichmentTypes pinType){

		List<WebElement> pinsOnThePageList = getPinsOnThePage(pinType.getType());
		WebElement firstVisiblePin = pinsOnThePageList.get(1);

		firstVisiblePin.click();
		ActionUtils.waitForElement(getViewCanvasForEnrichmentType(pinType));//to do handle all cases
	}

	public void clickAddNewEnrichmentButton(WebElement webelement, String buttonName){

		ArrayList<WebElement> addPinButtonsList = getAddPinMenuButtonList(webelement);

		for(WebElement element : addPinButtonsList){

			boolean isButtonName = element.getText().equals(buttonName);
			if(isButtonName){
				element.click();
				return;
			}
		}
	}

	public void deleteEnrichment(EnrichmentTypes pinType) throws InterruptedException{

		ActionUtils.waitForElementInvisible(loadingIcon);
		List<WebElement> pinsOnThePageList = getPinsOnThePage(pinType.getType());
		WebElement firstVisiblePin = pinsOnThePageList.get(1);

		ActionUtils.rightClick(firstVisiblePin);
		deleteAction();
		ActionUtils.waitForElementInvisible(pinsOnThePageList.get(1));
	}

	private ArrayList<WebElement> getAddPinMenuButtonList(WebElement webelement){

		List<WebElement> mainMenuChildren = webelement.findElements(By.xpath(".//*"));
		ArrayList<WebElement> addPinButtonsList = new ArrayList<>();

		for(WebElement element : mainMenuChildren){

			boolean isButton = element.getTagName().equals("button");

			if(isButton)
			{
				addPinButtonsList.add(element);
			}
		}
		return addPinButtonsList;
	}

	private void deleteAction(){
		ActionUtils.waitForElement(deleteEnrichmentButton);
		deleteEnrichmentButton.click();
		confirmDeleteButton.click();
	}

	private WebElement getViewCanvasForEnrichmentType(EnrichmentTypes type){
		WebElement element;
		element = driver.findElement(By.cssSelector(type.getSelector()));

		return element;
	}

	private ArrayList<WebElement> getPinsOnThePage(String string){

		WebElement pageOverlay = pinOverlay.get(1);

		List<WebElement> pinsList = pageOverlay.findElements(By.xpath(".//*"));
		ArrayList<WebElement> pinsOnThePageList = new ArrayList<>();

		for(WebElement element : pinsList){

			boolean isClass = element.getTagName().equals("div");
			String nodeType = element.getAttribute("node-type");

			if(nodeType!=null && nodeType.equals(string)) {
				if(isClass){
					pinsOnThePageList.add(element);
				}
			}
		}
		return pinsOnThePageList;
	}

	public WebElement getLoadingIcon() {
		return loadingIcon;
	}

	public void setLoadingIcon(WebElement loadingIcon) {
		this.loadingIcon = loadingIcon;
	}

	public WebElement getViewPinCanvas() {
		return viewPinCanvas;
	}

	public void setViewPinCanvas(WebElement viewPinCanvas) {
		this.viewPinCanvas = viewPinCanvas;
	}

	public WebElement getPopupHeader() {
		return popupHeader;
	}

	public void setPopupHeader(WebElement popupHeader) {
		this.popupHeader = popupHeader;
	}

}
