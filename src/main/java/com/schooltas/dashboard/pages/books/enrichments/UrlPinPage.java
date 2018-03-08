package com.schooltas.dashboard.pages.books.enrichments;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.dashboard.utils.utils.ActionUtils;

public class UrlPinPage extends Enrichment {

    @FindBy(how = How.CSS, using = "input.st-textinput.full")
    private List<WebElement> linkInputList;

    public void fillEnrichmentDetails(String url) {

        WebElement input = getInputField(linkInputList);

        ActionUtils.waitForElement(input);
        input.sendKeys(url);
    }

    private WebElement getInputField(List<WebElement> elements) {
        Optional<WebElement> findFirst = elements.stream()
                .filter(element -> element.getAttribute("placeholder").equals("http://"))
                .findFirst();

        return findFirst.orElse(null);

    }

}
