package com.schooltas.dashboard.tests.bookEditorTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.books.enrichments.ImageInPopupPage;
import com.schooltas.dashboard.pages.books.enrichments.TextInPopupPage;
import com.schooltas.dashboard.templates.BookEditorTemplate;
import com.schooltas.dashboard.templates.BooksOverviewTemplate;
import com.schooltas.dashboard.tests.BaseClass;
import com.schooltas.dashboard.utils.enums.EnrichmentTypes;
import com.schooltas.dashboard.utils.utils.ActionUtils;

public class EditPinTests extends BaseClass {

    private static BooksOverviewTemplate overviewTemplate;
    private static BookEditorTemplate bookEditorTemplate;

    @BeforeClass
    public static void initTemplates() {
        overviewTemplate = PageFactory.initElements(driver, BooksOverviewTemplate.class);
        bookEditorTemplate = PageFactory.initElements(driver, BookEditorTemplate.class);
    }

    @Test
    public void editTextInPopupPinThenSave() throws InterruptedException {

        TextInPopupPage textInPopupPage = PageFactory.initElements(driver, TextInPopupPage.class);
        textInPopupPage.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_EDIT);

        overviewTemplate.click("| Edit");
        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.editEnrichment("c549aff8-e302-3814-cd1e-8d140a635408", EnrichmentTypes.Text);

        textInPopupPage.clearEnrichmentDetails();

        textInPopupPage.fillEnrichmentDetailsFields("Edit Test title", "Body text test", "mouseover", false);

        bookEditorTemplate.saveEnrichment();
        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());
        bookEditorTemplate.viewEnrichmentById("c549aff8-e302-3814-cd1e-8d140a635408", EnrichmentTypes.Text);

        textInPopupPage.assertEnrichmentDetails("Edit Test title\nBody text test");
        ActionUtils.pressEscKey();


    }
    @Test
    public void editImageInPopupPinThenSave() throws InterruptedException{
        ImageInPopupPage imageInPopupPage = PageFactory.initElements(driver, ImageInPopupPage.class);
        imageInPopupPage.setBookEditorTemplate(bookEditorTemplate);


        dashboardMenu.clickMainMenuOption("Books");
        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_EDIT);
        overviewTemplate.click("| Edit");

        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.editEnrichment("d460aee0-ef1f-a53d-0689-eaec41464357", EnrichmentTypes.Gallery);

        imageInPopupPage.clearEnrichmentDetails();

        imageInPopupPage.fillEnrichmentDetails("Edit Test image in popup", "mouseover text", "", false);
        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());
        bookEditorTemplate.viewEnrichmentById("d460aee0-ef1f-a53d-0689-eaec41464357", EnrichmentTypes.Gallery);

        bookEditorTemplate.assertEnrichmentDetails("Edit Test image in popup");

    }
}
