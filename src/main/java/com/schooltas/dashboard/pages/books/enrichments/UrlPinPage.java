package com.schooltas.dashboard.pages.books.enrichments;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.dashboard.utils.utils.ActionUtils;

public class UrlPinPage extends Enrichment {

    @FindBy(how = How.CSS, using = "input.st-textinput.full")
    private List<WebElement> linkInputList;

    public void fillEnrichmentDetails(String url) {

        WebElement input = getInputField(linkInputList, "placeholder", "http://");

        ActionUtils.waitForElement(input);
        input.sendKeys(url);
    }



}
