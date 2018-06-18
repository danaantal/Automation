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

    protected WebElement getElementByAttribute(List<WebElement> elements, String attribute, String value) {
        // System.out.println(attribute);
        Optional<WebElement> findFirst = elements.stream()
                .filter(element -> element.getAttribute(attribute).equals(value))
                .findFirst();

        return findFirst.orElse(null);

    }

    protected WebElement getElementByAttributeAndTagname(WebElement parent, String attribute, String value,
            String tagName) {
        List<WebElement> children = parent.findElements(By.xpath(".//*"));

        Optional<WebElement> findElement = children.stream()
                .filter(element -> (element.getAttribute(attribute).equals(value)
                        && (element.getTagName().equals(tagName))))
                .findFirst();

        return findElement.orElse(null);

    }

    protected WebElement getElementByTagName(WebElement parent, String tagName) {

        List<WebElement> children = parent.findElements(By.xpath(".//*"));

        Optional<WebElement> findField = children.stream()
                .filter(element -> (element.getTagName().equals(tagName)))
                .findFirst();

        return findField.orElse(null);
    }

}
