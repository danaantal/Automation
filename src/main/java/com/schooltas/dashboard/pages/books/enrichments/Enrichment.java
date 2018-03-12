package com.schooltas.dashboard.pages.books.enrichments;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.schooltas.dashboard.templates.BookEditorTemplate;

public abstract class Enrichment {

    protected BookEditorTemplate bookEditorTemplate;

    public void setBookEditorTemplate(BookEditorTemplate bookEditorTemplate) {
        this.bookEditorTemplate = bookEditorTemplate;
    }

    protected WebElement getInputField(List<WebElement> elements, String attribute, String value) {
        Optional<WebElement> findFirst = elements.stream()
                .filter(element -> element.getAttribute(attribute).equals(value))
                .findFirst();

        return findFirst.orElse(null);

    }

    protected WebElement getMouseOverField(WebElement mouseover) {
        List<WebElement> children = mouseover.findElements(By.xpath(".//*"));

        Optional<WebElement> findMouseOverField = children.stream()
                .filter(element -> (element.getAttribute("class").equals("st-textinput full")
                        && (element.getTagName().equals("input"))))
                .findFirst();

        return findMouseOverField.orElse(null);
    }

}

