package com.schooltas.dashboard.pages.books.enrichments;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.dashboard.utils.utils.ActionUtils;

public class YoutubePinPage extends Enrichment {

    @FindBy(how = How.CSS, using = "input.st-textinput.full")
    private List<WebElement> linkInputList;

    @FindBy(id = "mouseoverTextField")
    private WebElement mouseoverField;

    @FindBy(how = How.CSS, using = "fieldset.divided")
    private WebElement titleInputDiv;

    @FindBy(how = How.CSS, using = "div.isPremiumCheckbox")
    private WebElement checkboxDiv;

    public void fillEnrichmentDetails(String url, String title, String mouseover, boolean isPremium) {

        WebElement linkInput = getElementByAttribute(linkInputList, "placeholder", "http://");
        WebElement titleField = getElementByAttributeAndTagname(titleInputDiv, "class", "st-textinput full", "input");
        WebElement mouseoverInput = getElementByAttributeAndTagname(mouseoverField, "class", "st-textinput full",
                "input");

        ActionUtils.waitForElement(linkInput);
        linkInput.sendKeys(url);
        titleField.sendKeys(title);
        mouseoverInput.sendKeys(mouseover);

        if (isPremium) {
            WebElement premiumCheckbox = getElementByTagName(checkboxDiv, "label");
            premiumCheckbox.click();
        }
    }

    public void clearEnrichmentDetails(){
        WebElement linkInput = getElementByAttribute(linkInputList, "placeholder", "http://");
        WebElement titleField = getElementByAttributeAndTagname(titleInputDiv, "class", "st-textinput full", "input");
        WebElement mouseoverInput = getElementByAttributeAndTagname(mouseoverField, "class", "st-textinput full",
                "input");

        linkInput.clear();
        titleField.clear();
        mouseoverInput.clear();
    }
}
