package com.schooltas.dashboard.tests.bookTests;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

import com.schooltas.dashboard.pages.books.BookDetailsPage;
import com.schooltas.dashboard.pages.books.BookForm;
import com.schooltas.dashboard.pages.books.CreateBookPage;
import com.schooltas.dashboard.pages.books.EditBookPage;
import com.schooltas.dashboard.templates.BooksOverviewTemplate;
import com.schooltas.dashboard.tests.BaseClass;

public class BookTests extends BaseClass {

    public static BooksOverviewTemplate overviewTemplate;
    public static BookDetailsPage bookDetails;

    @BeforeClass
    public static void init() {
        overviewTemplate = PageFactory.initElements(driver, BooksOverviewTemplate.class);
        bookDetails = PageFactory.initElements(driver, BookDetailsPage.class);
    }

    @Test
    public void createBookFromBookOverviewPage() throws InterruptedException {
        BookForm createBook = PageFactory.initElements(driver, CreateBookPage.class);

        dashboardMenu.clickMainMenuOption("Books");
        leftMenu.clickMenuItem("Create book");

        ArrayList<Pair<WebElement, String>> bookInput = createBook.fillBookDetails();

        createBook.save();

        bookDetails.assertBookDetails(bookInput);
    }

    @Test
    public void editBookFromOverviewPage() throws InterruptedException {
        BookForm editBook = PageFactory.initElements(driver, EditBookPage.class);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(editBook.getEan());
        overviewTemplate.click("Details");

        leftMenu.clickMenuItem("Edit book");

        ArrayList<Pair<WebElement, String>> bookInput = editBook.fillBookDetails();

        editBook.save();
        bookDetails.assertBookDetails(bookInput);
    }
}
