package com.schooltas.dashboard.pages.books.bookEditor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddNewPinPage {

	//	private final WebDriver driver;
	//
	//	public AddNewPinPage(WebDriver driver) {
	//		this.driver = driver;
	//	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"editor-page\"]/div[16]/div[2]/button[1]")
	public WebElement textInPopupBtn;

	@FindBy(id = "editTextPopupHeading")
	private WebElement textInPopupPinTitleField;

	@FindBy(how = How.XPATH, using = "//*[@id=\"wmd-button-bar\"]/span[1]/svg/path")
	private WebElement boldTextBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"wmd-button-bar\"]/span[2]/svg")
	private WebElement italicTextBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"wmd-button-bar\"]/span[3]/svg/g/path")
	private WebElement bulletsTextBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"wmd-button-bar\"]/span[4]/svg")
	private WebElement numberingTextBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"wmd-button-bar\"]/span[5]/svg")
	private WebElement hyperlinkTextBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"painting-controls\"]/div/section/fieldset/button[1]")
	private WebElement saveBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"painting-controls\"]/div/section/fieldset/button[3]")
	private WebElement cancelBtn;
}
