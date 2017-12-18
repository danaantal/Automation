package com.schooltas.dashboard.pages.books;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.internal.collections.Pair;

public class CreateBookPage {

	@FindBy(id = "book.title")
	WebElement bookTitleField;

	@FindBy(id = "book.electronicIsbn")
	WebElement bookEanField;

	@FindBy(id = "subjectId")
	WebElement bookSubjectField;

	@FindBy(id = "book.bookType")
	WebElement bookTypeField;

	@FindBy(id = "book.year")
	WebElement bookYearField;

	@FindBy(id = "book.stream")
	WebElement bookStreamField;

	@FindBy(id = "book.methode")
	WebElement bookMethodeField;

	@FindBy(id = "pdfFile")
	WebElement uploadPDfBtn;

	@FindBy(id = "coverFile")
	WebElement UploadCoverBtn;

	@FindBy(how = How.CSS, using = "input.btn.btn-primary")
	WebElement saveBtn;

	public void createBook() throws InterruptedException {

		ArrayList<Pair<WebElement, String>> bookDetails = createPairOfWebElementsAndValues();

		bookDetails.forEach((element) -> {
			element.first().sendKeys(element.second());
		});

		uploadFile(uploadPDfBtn, "/Users/dantal/Downloads/PDFs/E-book.pdf");
		uploadFile(UploadCoverBtn, "/Users/dantal/Downloads/PDFs/test2.jpg");

		saveBtn.click();

	}

	public ArrayList<Pair<WebElement, String>> createPairOfWebElementsAndValues() {
		ArrayList<Pair<WebElement, String>> createBookFormPairs = new ArrayList<>();

		createBookFormPairs.add(new Pair<>(bookTitleField, "book title automate"));
		createBookFormPairs.add(new Pair<>(bookEanField, String.valueOf(generateIsbnRandom())));
		createBookFormPairs.add(new Pair<>(bookSubjectField, "#Test"));
		createBookFormPairs.add(new Pair<>(bookTypeField, "Coursebook"));
		createBookFormPairs.add(new Pair<>(bookYearField, "1990"));
		createBookFormPairs.add(new Pair<>(bookStreamField, "book stream"));
		createBookFormPairs.add(new Pair<>(bookMethodeField, "book methode"));

		return createBookFormPairs;

	}

	public void uploadFile(WebElement element, String filepath) throws InterruptedException {

		Thread.sleep(1000);
		element.sendKeys(filepath);
	}

	public static long generateIsbnRandom() {
		while (true) {
			long numb = (long) (Math.random() * 100000000 * 1000000);
			if (String.valueOf(numb).length() == 13) {
				return numb;
			}
		}
	}
}
