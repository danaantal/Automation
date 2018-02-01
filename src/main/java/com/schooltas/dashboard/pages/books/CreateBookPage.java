package com.schooltas.dashboard.pages.books;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.internal.collections.Pair;

public class CreateBookPage {

	@FindBy(id = "book.title")
	private WebElement bookTitleField;

	@FindBy(id = "book.electronicIsbn")
	private WebElement bookEanField;

	@FindBy(id = "subjectId")
	private WebElement bookSubjectField;

	@FindBy(id = "book.bookType")
	private WebElement bookTypeField;

	@FindBy(id = "book.year")
	private WebElement bookYearField;

	@FindBy(id = "book.stream")
	private WebElement bookStreamField;

	@FindBy(id = "book.methode")
	private WebElement bookMethodeField;

	@FindBy(id = "pdfFile")
	private WebElement uploadPDfBtn;

	@FindBy(id = "coverFile")
	private WebElement UploadCoverBtn;

	@FindBy(how = How.CSS, using = "input.btn.btn-primary")
	private WebElement saveBtn;

	public void createBook(String ean) throws InterruptedException {

		bookYearField.clear();

		ArrayList<Pair<WebElement, String>> bookDetails = createBookDetailsInputList(ean);

		bookDetails.forEach((element) -> {
			element.first().sendKeys(element.second());
		});

		uploadFile(uploadPDfBtn, "/Users/dantal/Downloads/PDFs/E-book.pdf");
		uploadFile(UploadCoverBtn, "/Users/dantal/Downloads/PDFs/test2.jpg");

		saveBtn.click();
	}

	public ArrayList<Pair<WebElement, String>> createBookDetailsInputList(String ean) {
		ArrayList<Pair<WebElement, String>> createBookFormPairs = new ArrayList<>();

		createBookFormPairs.add(new Pair<>(bookTitleField, "book title automate"));
		createBookFormPairs.add(new Pair<>(bookEanField, ean));
		createBookFormPairs.add(new Pair<>(bookSubjectField, "#Test"));
		createBookFormPairs.add(new Pair<>(bookTypeField, "Coursebook"));
		createBookFormPairs.add(new Pair<>(bookYearField, "1990"));
		createBookFormPairs.add(new Pair<>(bookStreamField, "book stream"));
		createBookFormPairs.add(new Pair<>(bookMethodeField, "book methode"));

		return createBookFormPairs;
	}

	private void uploadFile(WebElement element, String filepath) throws InterruptedException {

		Thread.sleep(1000);
		element.sendKeys(filepath);
	}
}
