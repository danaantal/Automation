package com.schooltas.dashboard.pages.books.bookEditor;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditBookViewerPage {

	private static WebDriver driver;

	public EditBookViewerPage(WebDriver driver) {
		EditBookViewerPage.driver = driver;
	}

	@FindBy(id = "book-settings-button")
	private WebElement bookPageSettingsBtn;

	@FindBy(how = How.CSS, using = "div.context-menu.popup.show")
	private WebElement addPinsMainMenu;

	@FindBy(how = How.CSS, using = "button[data-type='enrichment']")
	private WebElement addNewPinBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"editor-page\"]/div[16]/div[1]/button[2]")
	private WebElement addNewAnswerBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"editor-page\"]/div[16]/div[1]/button[3]")
	private WebElement addNewInternalLinkButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"editor-page\"]/div[16]/div[1]/button[4]")
	private WebElement addNewImageHotspotsBtn;

	@FindBy(how = How.CSS, using = "div.prikker-container.show-markers")
	private List<WebElement> pageOverlay;
	//
	//	@FindBy(css = ".alert-popup.alert-text")
	//	// @FindBy(css=".alert.show")
	//	public WebElement loaderPercentage;
	//
	//	@FindBy(id = "booktitle-popup")
	//	private WebElement bookTitlePopup;

	public void WaitForText(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public void WaitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void WaitForElementToFinish(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void WaitForElementCustom(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void rightClick(WebElement element) {
		try {
			Actions action = new Actions(driver).contextClick(element);
			action.build().perform();

			System.out.println("Sucessfully Right clicked on the element");
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element " + element + " was not clickable " + e.getStackTrace());
		}

	}

	public void rightClickOnThePage() throws InterruptedException{
		Thread.sleep(5000);
		rightClick(pageOverlay.get(0));
	}

	public void getAddPinMenuButtons(){

		List<WebElement> mainMenuChildren = addPinsMainMenu.findElements(By.xpath(".//*"));
		List<WebElement> addPinButtons = null;

		mainMenuChildren.forEach(element -> {
			if(element.getTagName().equals("button"))
			{
				addPinButtons.add(element);
			}

		});
	}
}
