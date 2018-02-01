package com.schooltas.dashboard.pages.books;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.internal.collections.Pair;

import com.google.common.collect.ImmutableList;

public class EditBookPage {

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

	@FindBy(how = How.CSS, using = "input.btn.btn-primary")
	private WebElement saveBtn;

	public void editBook(){

		clearFieldsButEanField(createImmutableList());
		ArrayList<Pair<WebElement, String>> bookDetails = createBookDetailsInputList();

		bookDetails.forEach((element) -> {
			element.first().sendKeys(element.second());
		});
		saveBtn.click();
	}

	public ArrayList<Pair<WebElement, String>> createBookDetailsInputList() {
		ArrayList<Pair<WebElement, String>> createBookFormPairs = new ArrayList<>();

		createBookFormPairs.add(new Pair<>(bookTitleField, "Edit book title automate"));
		//createBookFormPairs.add(new Pair<>(bookEanField, ean));
		createBookFormPairs.add(new Pair<>(bookSubjectField, "#Test"));
		createBookFormPairs.add(new Pair<>(bookTypeField, "Workbook"));
		createBookFormPairs.add(new Pair<>(bookYearField, "1"));
		createBookFormPairs.add(new Pair<>(bookStreamField, "edit book stream"));
		createBookFormPairs.add(new Pair<>(bookMethodeField, "edit book methode"));

		return createBookFormPairs;
	}

	private List<WebElement> createImmutableList(){
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

	private void clearFieldsButEanField(List<WebElement> webelementList){

		webelementList.stream()
		.filter(element ->
		!element.equals(bookEanField) && !element.equals(bookTypeField) && !element.equals(bookSubjectField))
		.forEach(WebElement::clear);
	}
}
