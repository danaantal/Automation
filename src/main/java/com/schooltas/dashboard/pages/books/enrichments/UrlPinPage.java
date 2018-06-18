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

    public void fillEnrichmentDetails(String url, boolean isPremium) {

        WebElement input = getElementByAttribute(linkInputList, "placeholder", "http://");

        ActionUtils.waitForElement(input);
        input.sendKeys(url);

        if (isPremium) {
            WebElement premiumCheckbox = getElementByTagName(checkboxDiv, "label");
            premiumCheckbox.click();
        }
    }

}
