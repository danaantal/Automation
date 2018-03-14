package com.schooltas.dashboard.tests.bookEditorTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.books.enrichments.ImageInPopupPage;
import com.schooltas.dashboard.pages.books.enrichments.MediaPinPage;
import com.schooltas.dashboard.pages.books.enrichments.TextInPopupPage;
import com.schooltas.dashboard.pages.books.enrichments.UrlPinPage;
import com.schooltas.dashboard.pages.books.enrichments.YoutubePinPage;
import com.schooltas.dashboard.templates.BookEditorTemplate;
import com.schooltas.dashboard.templates.BooksOverviewTemplate;
import com.schooltas.dashboard.tests.BaseClass;
import com.schooltas.dashboard.utils.enums.EnrichmentTypes;
import com.schooltas.dashboard.utils.utils.ActionUtils;

public class PinTests extends BaseClass {

    private static BooksOverviewTemplate overviewTemplate;
    private static BookEditorTemplate bookEditorTemplate;

    @BeforeClass
    public static void initTemplates() {
        overviewTemplate = PageFactory.initElements(driver, BooksOverviewTemplate.class);
        bookEditorTemplate = PageFactory.initElements(driver, BookEditorTemplate.class);
    }

    @Test
    public void addNewTexInPopupEnrichment() throws InterruptedException {

        TextInPopupPage textInPopupPage = PageFactory.initElements(driver, TextInPopupPage.class);
        textInPopupPage.setBookEditorTemplate(bookEditorTemplate);

        String ean = "3711413071302";

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(ean);
        overviewTemplate.click("| Edit");
        ActionUtils.switchwindow();

        bookEditorTemplate.rightClickOnThePage();
        bookEditorTemplate.clickAddNewEnrichmentButton("Add new pin");
        bookEditorTemplate.clickTextInPopupEnrichmentButton("Text in popup");
        textInPopupPage.fillEnrichmentDetailsFields("Test title", "Body text test");

        bookEditorTemplate.saveEnrichment();
        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());
        bookEditorTemplate.viewEnrichment(EnrichmentTypes.Text);

        textInPopupPage.assertEnrichmentDetails("Test title\nBody text test");
        ActionUtils.pressEscKey();

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.Text);

        System.out.println("text in popup deleted!");
    }

    @Test
    public void addNewImageInPopupEnrichment() throws InterruptedException {

        ImageInPopupPage imageInPopupPage = PageFactory.initElements(driver, ImageInPopupPage.class);
        imageInPopupPage.setBookEditorTemplate(bookEditorTemplate);

        String ean = "3711413071302";

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(ean);
        overviewTemplate.click("| Edit");

        ActionUtils.switchwindow();

        bookEditorTemplate.rightClickOnThePage();
        bookEditorTemplate.clickAddNewEnrichmentButton("Add new pin");
        bookEditorTemplate.clickTextInPopupEnrichmentButton("Image in popup");

        imageInPopupPage.fillEnrichmentDetails("Test image in popup", "/Users/dantal/Downloads/PDFs/test2.jpg");

        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());
        bookEditorTemplate.viewEnrichment(EnrichmentTypes.Gallery);

        imageInPopupPage.assertEnrichmentDetails("Test image in popup");

        ActionUtils.pressEscKey();

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.Gallery);

    }

    @Test
    public void addNewLinkEnrichment() throws InterruptedException {
        UrlPinPage urlPinPage = PageFactory.initElements(driver, UrlPinPage.class);
        urlPinPage.setBookEditorTemplate(bookEditorTemplate);

        String ean = "3711413071302";

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(ean);
        overviewTemplate.click("| Edit");

        ActionUtils.switchwindow();

        bookEditorTemplate.rightClickOnThePage();
        bookEditorTemplate.clickAddNewEnrichmentButton("Add new pin");
        bookEditorTemplate.clickTextInPopupEnrichmentButton("Link (URL)");

        urlPinPage.fillEnrichmentDetails("http://thecodinglove.com/post/79149589869/hey-look-the-bug-is-fixed");

        bookEditorTemplate.saveEnrichment();
        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.Link);
    }

    @Test
    public void addNewAudioEnrichment() throws InterruptedException {
        MediaPinPage mediaPinPage = PageFactory.initElements(driver, MediaPinPage.class);
        mediaPinPage.setBookEditorTemplate(bookEditorTemplate);

        String ean = "3711413071302";
        String fileId = "1177537";

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(ean);
        overviewTemplate.click("| Edit");

        ActionUtils.switchwindow();

        bookEditorTemplate.rightClickOnThePage();
        bookEditorTemplate.clickAddNewEnrichmentButton("Add new pin");
        bookEditorTemplate.clickTextInPopupEnrichmentButton("Audio");

        //audioPinPage.openUploadsList();
        mediaPinPage.waitForSideMenu();
        mediaPinPage.clickSelectFileButton();
        mediaPinPage.searchForAudioFile(fileId);
        mediaPinPage.chooseFile(fileId);
        mediaPinPage.fillEnrichmentDetails("Title", "MouseoverText");

        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.Audio);
    }

    @Test
    public void addNewVideoEnrichment() throws InterruptedException {
        MediaPinPage mediaPinPage = PageFactory.initElements(driver, MediaPinPage.class);
        mediaPinPage.setBookEditorTemplate(bookEditorTemplate);

        String ean = "3711413071302";
        String fileId = "1177536";

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(ean);
        overviewTemplate.click("| Edit");

        ActionUtils.switchwindow();

        bookEditorTemplate.rightClickOnThePage();
        bookEditorTemplate.clickAddNewEnrichmentButton("Add new pin");
        bookEditorTemplate.clickTextInPopupEnrichmentButton("Video");

        //audioPinPage.openUploadsList();
        mediaPinPage.waitForSideMenu();
        mediaPinPage.clickSelectFileButton();
        mediaPinPage.searchForAudioFile(fileId);
        mediaPinPage.chooseFile(fileId);
        mediaPinPage.fillEnrichmentDetails("Title", "MouseoverText");

        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.Video);
    }

    @Test
    public void addNewYoutubeEnrichment() throws InterruptedException {
        YoutubePinPage youtubePinPage = PageFactory.initElements(driver, YoutubePinPage.class);
        youtubePinPage.setBookEditorTemplate(bookEditorTemplate);

        String ean = "3711413071302";

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(ean);
        overviewTemplate.click("| Edit");

        ActionUtils.switchwindow();

        bookEditorTemplate.rightClickOnThePage();
        bookEditorTemplate.clickAddNewEnrichmentButton("Add new pin");
        bookEditorTemplate.clickTextInPopupEnrichmentButton("YouTube");

        youtubePinPage.fillEnrichmentDetails("https://www.youtube.com/watch?v=1SL1bSysul8", "Title", "mouseover text");

        bookEditorTemplate.saveEnrichment();
        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.Youtube);
    }
}
