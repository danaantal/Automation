package com.schooltas.dashboard.pages.books.enrichments;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.dashboard.utils.utils.ActionUtils;

public class YoutubePinPage extends Enrichment{

    @FindBy(how = How.CSS, using = "input.st-textinput.full")
    private List<WebElement> linkInputList;

    @FindBy(id = "mouseoverTextField")
    private WebElement mouseoverField;

    @FindBy(how = How.CSS, using = "fieldset.divided")
    private WebElement titleInputDiv;

    public void fillEnrichmentDetails(String url, String title, String mouseover) {

        WebElement linkInput = getInputField(linkInputList, "placeholder", "http://");
        WebElement titleInput = getInputFieldFor(titleInputDiv);
        WebElement mouseoverInput = getInputFieldFor(mouseoverField);

        ActionUtils.waitForElement(linkInput);
        linkInput.sendKeys(url);
        titleInput.sendKeys(title);
        mouseoverInput.sendKeys(mouseover);
    }
}
