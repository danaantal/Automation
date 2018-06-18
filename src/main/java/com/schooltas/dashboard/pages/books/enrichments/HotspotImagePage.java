package com.schooltas.dashboard.pages.books.enrichments;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.dashboard.utils.utils.ActionUtils;

public class HotspotImagePage extends Enrichment {

    @FindBy(how = How.CSS, using = "label.button.black")
    private List<WebElement> blackColor;

    @FindBy(how = How.CSS, using = "label.button.white")
    private List<WebElement> whiteColor;

    @FindBy(how = How.CSS, using = "input.st-textinput.full")
    private List<WebElement> linkInputList;

    @FindBy(id = "mouseoverTextField")
    private WebElement mouseover;

    @FindBy(how = How.CSS, using = "li.step1.done")
    private WebElement step2;

    @FindBy(how = How.CSS, using = "li.step3.active")
    private WebElement step3;

    @FindBy(how = How.CSS, using = "button.button.iconic.help-button.compact")
    private List<WebElement> helpBtn;

    public void completeStepOne() {

        ActionUtils.waitForElement(blackColor.get(0));
        blackColor.get(0).click();
    }

    public void completeStepTwo(String objectNumber) {
        // SK-A-5
        // assertTrue(step2.isDisplayed());
        ActionUtils.waitForElement(helpBtn.get(0));
        WebElement objectNumberInput = getElementByAttribute(linkInputList, "placeholder", "e.g. SK-A-2963");
        objectNumberInput.sendKeys(objectNumber);
    }

    public void completeStepThree(String title, String mouseoverText, String url) {

        ActionUtils.waitForElement(helpBtn.get(1));

        WebElement titleField = getElementByAttribute(linkInputList, "type", "text");
        WebElement mouseOverField = getElementByAttributeAndTagname(mouseover, "class", "st-textinput full", "input");
        WebElement urlField = getElementByAttribute(linkInputList, "placeholder",
                "e.g. http://hdl.handle.net/10934/RM0001.COLLECT.8891");

        ActionUtils.waitForElement(titleField);
        titleField.sendKeys(title);
        mouseOverField.sendKeys(mouseoverText);
        urlField.sendKeys(url);

    }
}
