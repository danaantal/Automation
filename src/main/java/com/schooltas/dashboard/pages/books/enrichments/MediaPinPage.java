package com.schooltas.dashboard.pages.books.enrichments;

import java.util.List;
import java.util.Optional;

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

    @FindBy(how = How.CSS, using = "header.title.green")
    private WebElement titleGreen;

    public void waitForSideMenu() {

        ActionUtils.waitForElement(titleGreen);
    }

    public void searchForAudioFile(String fileId) {
        // 1177537
        WebElement searchInput = getSearchField();
        WebElement searchButton = getSearchButton();

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
                        file.click();
                    }
                    return;
                }
            }
        }
    }

    public void fillEnrichmentDetails(String title, String mouseoverText) {

        WebElement titleField = getInputField(linkInputList, "type", "text");
        WebElement mouseOverField = getInputFieldFor(mouseover);

        titleField.sendKeys(title);
        mouseOverField.sendKeys(mouseoverText);
    }

    public WebElement clickSelectFileButton() throws InterruptedException {

        List<WebElement> children = sideMenu.findElements(By.xpath(".//button"));
        for (WebElement child : children) {
            System.out.println(child.getLocation());
            ActionUtils.waitForElementToBeClickable(child);
            // Thread.sleep(500);
            child.click();
            return child;
        }
        return null;
    }

    private WebElement getSearchField() {

        List<WebElement> children = searchContainer.findElements(By.xpath(".//*"));

        Optional<WebElement> findSearchField = children.stream()
                .filter(element -> (element.getAttribute("placeholder").equals("Search on title, ID-number or filename")
                        && (element.getTagName().equals("input"))))
                .findFirst();

        return findSearchField.orElse(null);
    }

    private WebElement getSearchButton() {
        List<WebElement> children = searchContainer.findElements(By.xpath(".//*"));

        Optional<WebElement> findSearchButton = children.stream()
                .filter(element -> (element.getAttribute("type").equals("submit")
                        && (element.getTagName().equals("button"))))
                .findFirst();

        return findSearchButton.orElse(null);
    }
}
