package com.schooltas.dashboard.pages.books.enrichments;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.dashboard.utils.utils.ActionUtils;

public class UrlPinPage extends Enrichment {

    @FindBy(how = How.CSS, using = "input.st-textinput.full")
    private List<WebElement> linkInputList;

    @FindBy(how = How.CSS, using = "div.isPremiumCheckbox")
    private WebElement checkboxDiv;

    @FindBy(id = "mouseoverTextField")
    private WebElement mouseoverSelector;

    public void fillEnrichmentDetails(String url, String mouseover, boolean isPremium) {

        WebElement input = getElementByAttribute(linkInputList, "placeholder", "http://");
        WebElement mouseoverField = getElementByAttributeAndTagname(mouseoverSelector, "class", "st-textinput full",
                "input");

        ActionUtils.waitForElement(input);
        input.sendKeys(url);
        mouseoverField.sendKeys(mouseover);

        if (isPremium) {
            WebElement premiumCheckbox = getElementByTagName(checkboxDiv, "label");
            premiumCheckbox.click();
        }
    }

    public void clearEnrichmentDetails(){
        WebElement input = getElementByAttribute(linkInputList, "placeholder", "http://");
        WebElement mouseoverField = getElementByAttributeAndTagname(mouseoverSelector, "class", "st-textinput full",
                "input");

        input.clear();
        mouseoverField.clear();
    }

}
