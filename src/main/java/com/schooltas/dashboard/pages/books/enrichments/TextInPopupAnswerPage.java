package com.schooltas.dashboard.pages.books.enrichments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.schooltas.dashboard.utils.utils.ActionUtils;

public class TextInPopupAnswerPage extends Enrichment{


    @FindBy(id = "editTextPopupHeading")
    private WebElement titleInput;

    @FindBy(id = "wmd-input")
    private WebElement bodyInput;

    @FindBy(id = "mouseoverTextField")
    private WebElement mouseoverField;

    public void fillEnrichmentDetails(String title, String body, String mouseover){

        WebElement mouseoverInput = getElementByAttributeAndTagname(mouseoverField, "class", "st-textinput full", "input");

        ActionUtils.waitForElement(titleInput);
        titleInput.sendKeys(title);
        bodyInput.sendKeys(body);
        mouseoverInput.sendKeys(mouseover);

    }
}
