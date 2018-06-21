package com.schooltas.dashboard.pages.books.enrichments;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ImageInPopupPage extends Enrichment {

    @FindBy(how = How.CSS, using = "input.st-textinput.full")
    private List<WebElement> imagePopupTitleField;

    @FindBy(how = How.XPATH, using = "//input[@type='file']")
    private WebElement uploadImageButton;

    @FindBy(how = How.CSS, using = "h3.reset.image-title")
    private WebElement popupHeader;

    @FindBy(how = How.CSS, using = "div.image-popup-viewer.shown")
    private WebElement imageViewer;

    @FindBy(how = How.CSS, using = "div.isPremiumCheckbox")
    private WebElement checkboxDiv;

    @FindBy(id = "mouseoverTextField")
    private WebElement mouseoverSelector;

    public void fillEnrichmentDetails(String title, String mouseover, String path, boolean isPremium) {

        WebElement mouseoverField = getElementByAttributeAndTagname(mouseoverSelector, "class", "st-textinput full",
                "input");

        imagePopupTitleField.get(0).sendKeys(title);
        mouseoverField.sendKeys(mouseover);

        if (isPremium) {
            WebElement premiumCheckbox = getElementByTagName(checkboxDiv, "label");
            premiumCheckbox.click();
        }

        if(!path.equals("")) {
            uploadImageButton.sendKeys(path);
        }
    }

    public void clearEnrichmentDetails(){

        WebElement mouseoverField = getElementByAttributeAndTagname(mouseoverSelector, "class", "st-textinput full",
                "input");
        imagePopupTitleField.get(0).clear();
        mouseoverField.clear();
    }
}
