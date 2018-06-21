package com.schooltas.dashboard.templates;

import static org.testng.Assert.assertEquals;

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

    @FindBy(how = How.CSS, using = "button.submit-button.button.green")
    private WebElement saveBtn;

    @FindBy(id = "poi-next")
    private WebElement nextBtn;

    @FindBy(how = How.CSS, using = "button.cancel-button.button.grey")
    private WebElement cancelBtn;

    @FindBy(how = How.CSS, using = "div.loading-icon")
    private WebElement loadingIcon;

    @FindBy(how = How.CSS, using = "div.prikker-container.show-markers")
    private List<WebElement> pinOverlay;

    @FindBy(id = "menu-button-delete")
    private WebElement deleteEnrichmentButton;

    @FindBy(id = "menu-button-edit")
    private WebElement editButton;

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

    @FindBy(id = "percentageLoader")
    private List<WebElement> alertOverlay;

    @FindBy(id = "booktitle-popup")
    private WebElement bookTitlePopup;

    @FindBy(how = How.CSS, using = "label.button.blue")
    private List<WebElement> answerType;

    @FindBy(how = How.CSS, using = "header.title.green")
    private WebElement titleGreen;

    @FindBy(id = "next-page")
    private WebElement nextPage;

    @FindBy(how = How.CSS, using = "div.prikker")
    private List<WebElement> pinsArray;

    public final static String EAN_CREATE = "3711413071302";
    public final static String EAN_EDIT = "2154535963702";
    public final static String EDIT_AUDIO_FILE_ID = "1177809";
    public final static String AUDIO_FILE_ID = "1177537";
    public final static String VIDEO_FILE_ID = "1177536";

    public BookEditorTemplate(WebDriver driver) {
        this.driver = driver;
    }

    public void rightClickOnThePage() throws InterruptedException {
        // ActionUtils.waitForElement(alertOverlay.get(0));

        // ActionUtils.waitForElement(bookTitlePopup);

        ActionUtils.waitForElement(pageOverlay.get(1));
        ActionUtils.rightClick(pageOverlay.get(1));
    }

    public void clickOnThePage() {

        pageOverlay.get(1).click();
    }

    public void navigateTotheNextPage() {

        ActionUtils.waitForElementToBeVisible(alertOverlay.get(0), 5);

        ActionUtils.waitForElement(bookTitlePopup);

        if (pageOverlay.get(0).isDisplayed()) {
            ActionUtils.waitForElement(pageOverlay.get(0));
            nextPage.click();
        }
    }

    public void goToNextStep() {
        ActionUtils.waitForElementToBeClickable(nextBtn);
        nextBtn.click();
    }

    public void clickAddNewEnrichmentButton(String buttonName) {

        ActionUtils.waitForElement(addPinsMainMenu);
        clickAddNewEnrichmentButton(addPinsMainMenu, buttonName);
    }

    public void clickNewTypeEnrichmentButton(String buttonName) {

        clickAddNewEnrichmentButton(addNewPinOptions, buttonName);
    }

    public void clickAddNewEnrichmentButton(WebElement webelement, String buttonName) {

        ArrayList<WebElement> addPinButtonsList = getAddPinMenuButtonList(webelement);

        for (WebElement element : addPinButtonsList) {

            boolean isButtonName = element.getText().equals(buttonName);
            if (isButtonName) {
                element.click();
                return;
            }
        }
    }

    public void saveEnrichment() {
        ActionUtils.waitForElementToBeClickable(saveBtn);
        saveBtn.click();
    }

    public void cancel() {
        ActionUtils.waitForElementToBeClickable(cancelBtn);
        cancelBtn.click();
    }

    public void viewEnrichment(EnrichmentTypes pinType) {

        List<WebElement> pinsOnThePageList = getPinsOnThePage(pinType.getType());
        WebElement firstVisiblePin = pinsOnThePageList.get(1);

        firstVisiblePin.click();
        ActionUtils.waitForElement(getViewCanvasForEnrichmentType(pinType));// to do handle all cases
    }

    public void editEnrichment(EnrichmentTypes pinType) throws InterruptedException {


        ActionUtils.waitForElementInvisible(loadingIcon);
        List<WebElement> pinsOnThePageList = getPinsOnThePage(pinType.getType());
        WebElement firstVisiblePin = pinsOnThePageList.get(1);

        ActionUtils.rightClick(firstVisiblePin);
        editAction();
    }

    public void deleteEnrichment(EnrichmentTypes pinType) throws InterruptedException {

        ActionUtils.waitForElementInvisible(loadingIcon);
        List<WebElement> pinsOnThePageList = getPinsOnThePage(pinType.getType());
        WebElement firstVisiblePin = pinsOnThePageList.get(1);

        ActionUtils.rightClick(firstVisiblePin);

        deleteAction();
        ActionUtils.waitForElementInvisible(pinsOnThePageList.get(1));
    }

    public void chooseTextAnswerType(String textAnswerType) {
        if (textAnswerType.equals("On page")) {
            ActionUtils.waitForElementToBeClickable(answerType.get(0));
            answerType.get(0).click();
        }
        else if (textAnswerType.equals("In popup")) {
            ActionUtils.waitForElementToBeClickable(answerType.get(1));
            answerType.get(1).click();
        }
    }

    public void waitForSideMenu() {

        ActionUtils.waitForElement(titleGreen);
    }

    public void clickSideMenu() {
        titleGreen.click();
    }

    public void assertEnrichmentDetails(String text) {

        ActionUtils.waitForElement(getPopupHeader());
        assertEquals(getPopupHeader().getText(), text);
    }

    private ArrayList<WebElement> getAddPinMenuButtonList(WebElement webelement) {

        List<WebElement> mainMenuChildren = webelement.findElements(By.xpath(".//*"));
        ArrayList<WebElement> addPinButtonsList = new ArrayList<>();

        for (WebElement element : mainMenuChildren) {

            boolean isButton = element.getTagName().equals("button");

            if (isButton) {
                addPinButtonsList.add(element);
            }
        }
        return addPinButtonsList;
    }

    private void deleteAction() {
        ActionUtils.waitForElement(deleteEnrichmentButton);
        deleteEnrichmentButton.click();
        confirmDeleteButton.click();
    }

    private void editAction() {
        ActionUtils.waitForElementToBeVisible(editButton, 5);
        editButton.click();
    }

    private WebElement getViewCanvasForEnrichmentType(EnrichmentTypes type) {
        WebElement element;
        element = driver.findElement(By.cssSelector(type.getSelector()));

        return element;
    }

    private ArrayList<WebElement> getPinsOnThePage(String string) {

        WebElement pageOverlay = pinOverlay.get(1);

        List<WebElement> pinsList = pageOverlay.findElements(By.xpath(".//*"));
        ArrayList<WebElement> pinsOnThePageList = new ArrayList<>();

        for (WebElement element : pinsList) {
            // ActionUtils.waitForElement(element);

            boolean isClass = element.getTagName().equals("div");
            String nodeType = element.getAttribute("node-type");

            if (nodeType != null && nodeType.equals(string)) {
                if (isClass) {
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

    public WebDriver getDriver() {
        return driver;
    }
}
