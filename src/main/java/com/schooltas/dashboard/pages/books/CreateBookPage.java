package com.schooltas.dashboard.pages.books;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.internal.collections.Pair;

import com.schooltas.dashboard.utils.enums.BookInputs;
import com.schooltas.dashboard.utils.utils.ActionUtils;

public class CreateBookPage extends BookForm{

    public CreateBookPage() {
        super(String.valueOf(ActionUtils.generateIsbnRandom()));
    }

    @Override
    public ArrayList<Pair<WebElement, String>> fillBookDetails() throws InterruptedException {

        bookYearField.clear();

        ArrayList<Pair<WebElement, String>> bookDetails = createBookInputs();

        bookDetails.forEach((element) -> {
            element.first().sendKeys(element.second());
        });

        uploadFile(uploadPDfBtn, BookInputs.PDF.getCreateInput());
        uploadFile(UploadCoverBtn, BookInputs.Cover.getCreateInput());

        return bookDetails;
    }

    private ArrayList<Pair<WebElement, String>> createBookInputs() {
        ArrayList<Pair<WebElement, String>> bookInputs = new ArrayList<>();

        bookInputs.add(new Pair<>(bookTitleField, BookInputs.Title.getCreateInput()));
        bookInputs.add(new Pair<>(bookEanField, getEan()));
        bookInputs.add(new Pair<>(bookSubjectField, BookInputs.Subject.getCreateInput()));
        bookInputs.add(new Pair<>(bookTypeField, BookInputs.Type.getCreateInput()));
        bookInputs.add(new Pair<>(bookYearField, BookInputs.Year.getCreateInput()));
        bookInputs.add(new Pair<>(bookStreamField, BookInputs.Stream.getCreateInput()));
        bookInputs.add(new Pair<>(bookMethodeField, BookInputs.Method.getCreateInput()));

        return bookInputs;
    }
}
