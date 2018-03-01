package com.schooltas.dashboard.pages.books;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.internal.collections.Pair;

import com.schooltas.dashboard.utils.enums.BookInputs;

public class EditBookPage extends BookForm{

    public EditBookPage() {
        super(BookInputs.EAN.getEditInput());
    }

    @Override
    public ArrayList<Pair<WebElement, String>> fillBookDetails(){

        clearTextInputs(createImmutableList());
        ArrayList<Pair<WebElement, String>> bookDetails = editBookInputs();

        bookDetails.forEach((element) -> {
            element.first().sendKeys(element.second());
        });

        return bookDetails;
    }

    private ArrayList<Pair<WebElement, String>> editBookInputs() {
        ArrayList<Pair<WebElement, String>> bookInputs = new ArrayList<>();

        bookInputs.add(new Pair<>(bookTitleField, BookInputs.Title.getEditInput()));
        bookInputs.add(new Pair<>(bookEanField, getEan()));
        bookInputs.add(new Pair<>(bookSubjectField, BookInputs.Subject.getEditInput()));
        bookInputs.add(new Pair<>(bookTypeField, BookInputs.Type.getEditInput()));
        bookInputs.add(new Pair<>(bookYearField,  BookInputs.Year.getEditInput()));
        bookInputs.add(new Pair<>(bookStreamField, BookInputs.Stream.getEditInput()));
        bookInputs.add(new Pair<>(bookMethodeField, BookInputs.Method.getEditInput()));

        return bookInputs;
    }
}
