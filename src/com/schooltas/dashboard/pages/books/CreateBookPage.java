package com.schooltas.dashboard.pages.books;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.internal.collections.Pair;

public class CreateBookPage {

	@FindBy(id = "book.title")
	WebElement bookTitleField;

	@FindBy(id = "book.electronicIsbn")
	WebElement bookEanField;

	@FindBy(id = "subjectId")
	Select bookSubjectField;

	@FindBy(id = "book.bookType")
	Select bookTypeField;

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

	public void createBook(ArrayList<Pair<WebElement, String>> bookDetails) {

	}

	public ArrayList<Pair<WebElement, String>>  createPairOfWebElementsAndValues(){
		ArrayList<Pair<WebElement, String>> createBookFormPairs = new ArrayList<>();

		createBookFormPairs.add(new Pair<> (bookTitleField, "book title automate"));
		createBookFormPairs.add(new Pair<> (bookEanField, "1234567893475"));
		//createBookFormPairs.add(bookSubjectField);
		//createBookFormPairs.add(bookTypeField);
		createBookFormPairs.add(new Pair<> (bookYearField, "1990"));
		createBookFormPairs.add(new Pair<> (bookStreamField, "book stream"));
		createBookFormPairs.add(new Pair<> (bookMethodeField, "book methode"));
		//createBookFormPairs.add(uploadPDfBtn);
		//createBookFormPairs.add(UploadCoverBtn);

		return createBookFormPairs;

	}

	public ArrayList<String> createListOfBookDetails() {
		ArrayList<String> bookDetails = new ArrayList<>();
		bookDetails.add("book title automate");
		bookDetails.add("1234567893475");
		// bookDetails.add("Test");
		// bookDetails.add("book type");
		bookDetails.add("1990");
		bookDetails.add("book stream");
		bookDetails.add("book methode");
		// upload pdf

		// upload cover

		return bookDetails;
	}

	public void uploadFile() throws InterruptedException {

		String workingDir = System.getProperty("/Users/dantal/Downloads/PDFs");
		String filepath = workingDir + "/E-book.pdf";
		driver.get(filepath);

		// Added a wait to make you notice the difference.
		Thread.sleep(1000);

		uploadPDfBtn.sendKeys(filepath);
	}
}
