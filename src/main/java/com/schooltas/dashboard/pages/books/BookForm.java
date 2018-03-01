package com.schooltas.dashboard.pages.books;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.internal.collections.Pair;

import com.google.common.collect.ImmutableList;

public abstract class BookForm{

    @FindBy(id = "book.title")
    protected WebElement bookTitleField;

    @FindBy(id = "book.electronicIsbn")
    protected WebElement bookEanField;

    @FindBy(id = "subjectId")
    protected WebElement bookSubjectField;

    @FindBy(id = "book.bookType")
    protected WebElement bookTypeField;

    @FindBy(id = "book.year")
    protected WebElement bookYearField;

    @FindBy(id = "book.stream")
    protected WebElement bookStreamField;

    @FindBy(id = "book.methode")
    protected WebElement bookMethodeField;

    @FindBy(id = "pdfFile")
    protected WebElement uploadPDfBtn;

    @FindBy(id = "coverFile")
    protected WebElement UploadCoverBtn;

    @FindBy(how = How.CSS, using = "input.btn.btn-primary")
    private WebElement saveBtn;


    private String ean;

    public BookForm() {
    }

    public BookForm(String ean) {
        this.ean = ean;
    }

    public abstract ArrayList<Pair<WebElement, String>> fillBookDetails() throws InterruptedException;

    protected void uploadFile(WebElement element, String filepath) throws InterruptedException {

        Thread.sleep(1000);
        element.sendKeys(filepath);
    }

    public void save(){
        saveBtn.click();
    }

    protected List<WebElement> createImmutableList(){
        List<WebElement> webelementList = ImmutableList.<WebElement> builder()
                .add(bookTitleField)
                .add(bookEanField)
                .add(bookMethodeField)
                .add(bookStreamField)
                .add(bookSubjectField)
                .add(bookTypeField)
                .add(bookYearField)
                .build();

        return webelementList;
    }

    protected void clearTextInputs(List<WebElement> webelementList){

        webelementList.stream()
        .filter(element ->
        /*!element.equals(bookEanField) && */!element.equals(bookTypeField) && !element.equals(bookSubjectField))
        .forEach(WebElement::clear);
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }
}
