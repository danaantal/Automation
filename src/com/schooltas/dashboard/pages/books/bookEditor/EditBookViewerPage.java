package com.schooltas.dashboard.pages.books.bookEditor;

import java.util.NoSuchElementException;

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
	WebElement bookPageSettingsBtn;

	@FindBy(how = How.CSS, using = "button[data-type='enrichment']")
	public WebElement addNewPinBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"editor-page\"]/div[16]/div[1]/button[2]")
	WebElement addNewAnswerBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"editor-page\"]/div[16]/div[1]/button[3]")
	WebElement addNewInternalLinkButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"editor-page\"]/div[16]/div[1]/button[4]")
	WebElement addNewImageHotspotsBtn;

	@FindBy(how = How.CSS, using = ".prikker-container.show-markers")
	public WebElement pageOverlay;

	@FindBy(css = ".alert-popup.alert-text")
	// @FindBy(css=".alert.show")
	public WebElement loaderPercentage;

	@FindBy(id = "booktitle-popup")
	public WebElement bookTitlePopup;

	public void WaitForText(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}


	// public void switchwindow() {
	// try {
	//
	// // String winHandleBefore = driver.getWindowHandle();
	//
	// for (String winHandle : driver.getWindowHandles()) {
	// driver.switchTo().window(winHandle);
	// }
	// } catch (Exception e) {
	// // return Constants.KEYWORD_FAIL+ "Unable to Switch Window" +
	// // e.getMessage();
	// }
	// // return Constants.KEYWORD_PASS;
	// }

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
}
