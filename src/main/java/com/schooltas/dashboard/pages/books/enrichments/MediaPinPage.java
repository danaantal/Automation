package com.schooltas.dashboard.pages.books.enrichments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.dashboard.utils.utils.ActionUtils;

public class MediaPinPage extends Enrichment {

    @FindBy(how = How.CSS, using = "button.button.blue")
    private List<WebElement> selectFileButton;

    @FindBy(how = How.CSS, using = "div.search-field")
    private WebElement searchContainer;

    @FindBy(how = How.CSS, using = "table.fixed-table")
    private WebElement availableMediaTable;

    @FindBy(how = How.CSS, using = "input.st-textinput.full")
    private List<WebElement> linkInputList;

    @FindBy(id = "mouseoverTextField")
    private WebElement mouseover;

    @FindBy(how = How.CSS, using = "ul.list-plain.choice-btns.form-step.slide-transition")
    private WebElement sideMenu;

    @FindBy(how = How.CSS, using = "div.isPremiumCheckbox")
    private WebElement checkboxDiv;

    public void searchForAudioFile(String fileId) {
        // 1177537
        WebElement searchInput = getElementByAttributeAndTagname(searchContainer, "placeholder",
                "Search on title, ID-number or filename", "input");
        WebElement searchButton = getElementByAttributeAndTagname(searchContainer, "type", "submit", "button");

        searchInput.sendKeys(fileId);
        searchButton.click();
    }

    public void chooseFile(String fileId) {

        ActionUtils.waitForElement(availableMediaTable);
        List<WebElement> files = availableMediaTable.findElements(By.xpath(".//td"));
        for (WebElement file : files) {

            if (file.getAttribute("class").equals("subdued")) {
                List<WebElement> children = file.findElements(By.xpath(".//*"));
                for (WebElement element : children) {
                    if (element.getText().equals(fileId)) {
                        // ActionUtils.waitForElement(file);
                        file.click();
                    }
                    return;
                }
            }
        }
    }

    public void fillEnrichmentDetails(String title, String mouseoverText, boolean isPremium) throws InterruptedException {

        WebElement titleField = getElementByAttribute(linkInputList, "type", "text");
        WebElement mouseOverField = getElementByAttributeAndTagname(mouseover, "class", "st-textinput full", "input");

        // ActionUtils.waitForElement(titleField);
        titleField.sendKeys(title);
        mouseOverField.sendKeys(mouseoverText);

        if (isPremium) {
            WebElement premiumCheckbox = getElementByTagName(checkboxDiv, "label");
            premiumCheckbox.click();
        }
    }

    public WebElement clickSelectFileButton() throws InterruptedException {

        List<WebElement> children = sideMenu.findElements(By.xpath(".//button"));
        for (WebElement child : children) {
            System.out.println(child.getLocation());
            ActionUtils.waitForElementToBeClickable(child);
            child.click();
            return child;
        }
        return null;
    }
}
