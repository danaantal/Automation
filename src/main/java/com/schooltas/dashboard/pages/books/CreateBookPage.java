package com.schooltas.dashboard.pages.books;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.internal.collections.Pair;

import com.schooltas.dashboard.utils.constants.ICreateBookConstants;

public class CreateBookPage implements ICreateBookConstants{

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

		uploadFile(uploadPDfBtn, BOOK_PDF_PATH);
		uploadFile(UploadCoverBtn, BOOK_COVER_PATH);

		saveBtn.click();
	}

	public ArrayList<Pair<WebElement, String>> createBookDetailsInputList(String ean) {
		ArrayList<Pair<WebElement, String>> createBookFormPairs = new ArrayList<>();

		createBookFormPairs.add(new Pair<>(bookTitleField, BOOK_TITLE));
		createBookFormPairs.add(new Pair<>(bookEanField, ean));
		createBookFormPairs.add(new Pair<>(bookSubjectField, BOOK_SUBJECT));
		createBookFormPairs.add(new Pair<>(bookTypeField, BOOK_TYPE));
		createBookFormPairs.add(new Pair<>(bookYearField, BOOK_YEAR));
		createBookFormPairs.add(new Pair<>(bookStreamField, BOOK_STREAM));
		createBookFormPairs.add(new Pair<>(bookMethodeField, BOOK_METHOD));

		return createBookFormPairs;
	}

	private void uploadFile(WebElement element, String filepath) throws InterruptedException {

		Thread.sleep(1000);
		element.sendKeys(filepath);
	}
}
