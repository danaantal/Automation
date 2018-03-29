package com.schooltas.dashboard.pages.books.enrichments;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.schooltas.dashboard.utils.utils.ActionUtils;

public class TextInPopupPage extends Enrichment {

    @FindBy(id = "editTextPopupHeading")
    private WebElement textInPopupPinTitleField;

    @FindBy(id = "wmd-button-bar")
    private WebElement fontStyleButtonBar;

    @FindBy(id = "wmd-input")
    private WebElement bodyTextArea;

    public void fillEnrichmentDetailsFields(String title, String body) {

        ActionUtils.waitForElement(textInPopupPinTitleField);
        textInPopupPinTitleField.sendKeys(title);
        bodyTextArea.sendKeys(body);
    }

    public void assertEnrichmentDetails(String text) {
        ActionUtils.waitForElement(bookEditorTemplate.getViewPinCanvas());
        assertEquals(bookEditorTemplate.getViewPinCanvas().getText(), text);
    }

    public WebElement getTextInPopupPinTitleField() {
        return textInPopupPinTitleField;
    }

    public void setTextInPopupPinTitleField(WebElement textInPopupPinTitleField) {
        this.textInPopupPinTitleField = textInPopupPinTitleField;
    }

    public WebElement getFontStyleButtonBar() {
        return fontStyleButtonBar;
    }

    public void setFontStyleButtonBar(WebElement fontStyleButtonBar) {
        this.fontStyleButtonBar = fontStyleButtonBar;
    }

    public WebElement getBodyTextArea() {
        return bodyTextArea;
    }

    public void setBodyTextArea(WebElement bodyTextArea) {
        this.bodyTextArea = bodyTextArea;
    }
}
