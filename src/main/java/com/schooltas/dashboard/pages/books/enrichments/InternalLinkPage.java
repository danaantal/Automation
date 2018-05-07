package com.schooltas.dashboard.pages.books.enrichments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InternalLinkPage extends Enrichment{


    @FindBy(id = "editLinkPageNr")
    private WebElement pageNr;

    @FindBy(id = "editLinkLineHeight")
    private WebElement lineHeight;

    @FindBy(id = "editLinkWidth")
    private WebElement linkWidth;

    @FindBy(id = "editLinkShowArrow")
    private WebElement showArrowCheckBox;

    @FindBy(how = How.CSS, using = "ul.radios.choices.colors.horizontal.list-plain")
    private WebElement colorPicker;

    @FindBy(id = "mouseoverTextField")
    private WebElement mouseoverSelector;

    public void fillInternalLinkDetails(String pageNo, String height, boolean showArrow, String mouseover){

        WebElement mouseoverField = getInputFieldFor(mouseoverSelector);

        pageNr.sendKeys(pageNo);
        lineHeight.sendKeys(height);
        showArrowCheckBox.click();
        mouseoverField.sendKeys(mouseover);
    }
}
