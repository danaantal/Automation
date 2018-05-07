package com.schooltas.dashboard.pages.books.enrichments;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ImageInPopupPage extends Enrichment{

    @FindBy(how = How.CSS, using = "input.st-textinput.full")
    private List<WebElement> imagePopupTitleField;

    @FindBy(how = How.XPATH, using = "//input[@type='file']")
    private WebElement uploadImageButton;

    @FindBy(how = How.CSS, using = "h3.reset.image-title")
    private WebElement popupHeader;

    @FindBy(how = How.CSS, using  = "div.image-popup-viewer.shown")
    private WebElement imageViewer;


    public void fillEnrichmentDetails(String title, String path){

        //ActionUtils.waitForElement(imagePopupTitleField.get(0));

        imagePopupTitleField.get(0).sendKeys(title);
        uploadImageButton.sendKeys(path);
    }


}
