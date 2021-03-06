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
    public void addNewTexInPopupEnrichmentThenDelete() throws InterruptedException {

        TextInPopupPage textInPopupPage = PageFactory.initElements(driver, TextInPopupPage.class);
        textInPopupPage.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);

        overviewTemplate.click("| Edit");
        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();
        bookEditorTemplate.clickAddNewEnrichmentButton("Add new pin");
        bookEditorTemplate.clickNewTypeEnrichmentButton("Text in popup");

        bookEditorTemplate.waitForSideMenu();

        textInPopupPage.fillEnrichmentDetailsFields("Test title", "Body text test", "mouseover text", true);

        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());
        bookEditorTemplate.viewEnrichment(EnrichmentTypes.Text);

        textInPopupPage.assertEnrichmentDetails("Test title\nBody text test");
        ActionUtils.pressEscKey();

        bookEditorTemplate.editEnrichment(EnrichmentTypes.Text);
        textInPopupPage.clearEnrichmentDetails();

        textInPopupPage.fillEnrichmentDetailsFields("Edit Test title", "Edit Body text test", "mouseover text", false);
        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());
        bookEditorTemplate.viewEnrichment(EnrichmentTypes.Text);

        textInPopupPage.assertEnrichmentDetails("Edit Test title\nEdit Body text test");
        ActionUtils.pressEscKey();

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.Text);

        System.out.println("text in popup deleted!");
    }

    @Test
    public void addNewImageInPopupEnrichment() throws InterruptedException {

        ImageInPopupPage imageInPopupPage = PageFactory.initElements(driver, ImageInPopupPage.class);
        imageInPopupPage.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");
        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);
        overviewTemplate.click("| Edit");

        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();
        bookEditorTemplate.clickAddNewEnrichmentButton("Add new pin");
        bookEditorTemplate.clickNewTypeEnrichmentButton("Image in popup");

        bookEditorTemplate.waitForSideMenu();

        imageInPopupPage.fillEnrichmentDetails("Test image in popup", "mouseover text",
                "/Users/dantal/Downloads/PDFs/test2.jpg", true);
        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.viewEnrichment(EnrichmentTypes.Gallery);

        bookEditorTemplate.assertEnrichmentDetails("Test image in popup");

        ActionUtils.pressEscKey();

        bookEditorTemplate.editEnrichment(EnrichmentTypes.Gallery);
        imageInPopupPage.clearEnrichmentDetails();

        imageInPopupPage.fillEnrichmentDetails("Edit Test image in popup", "mouseover text",
                "/Users/dantal/Downloads/PDFs/test2.jpg", false);
        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.viewEnrichment(EnrichmentTypes.Gallery);

        bookEditorTemplate.assertEnrichmentDetails("Edit Test image in popup");

        ActionUtils.pressEscKey();

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.Gallery);

        System.out.println("image in popup deleted!");
    }

    @Test
    public void addNewLinkEnrichment() throws InterruptedException {
        UrlPinPage urlPinPage = PageFactory.initElements(driver, UrlPinPage.class);
        urlPinPage.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);
        overviewTemplate.click("| Edit");

        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();
        bookEditorTemplate.clickAddNewEnrichmentButton("Add new pin");
        bookEditorTemplate.clickNewTypeEnrichmentButton("Link (URL)");

        bookEditorTemplate.waitForSideMenu();

        urlPinPage.fillEnrichmentDetails("http://thecodinglove.com/post/79149589869/hey-look-the-bug-is-fixed",
                "mouseover text", true);

        bookEditorTemplate.saveEnrichment();
        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.editEnrichment(EnrichmentTypes.Link);
        urlPinPage.clearEnrichmentDetails();

        urlPinPage.fillEnrichmentDetails(
                "https://www.goodreads.com/book/show/13588561-help-them-grow-or-watch-them-go?ac=1&from_search=true",
                "mouseover text", false);

        bookEditorTemplate.saveEnrichment();

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.Link);

        System.out.println("link deleted!");
    }

    @Test
    public void addNewAudioFromListEnrichment() throws InterruptedException {
        MediaPinPage mediaPinPage = PageFactory.initElements(driver, MediaPinPage.class);
        mediaPinPage.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);
        overviewTemplate.click("| Edit");

        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();
        bookEditorTemplate.clickAddNewEnrichmentButton("Add new pin");
        bookEditorTemplate.clickNewTypeEnrichmentButton("Audio");

        bookEditorTemplate.waitForSideMenu();
        mediaPinPage.clickSelectFileButton();

        mediaPinPage.searchForAudioFile(BookEditorTemplate.AUDIO_FILE_ID);
        mediaPinPage.chooseFile(BookEditorTemplate.AUDIO_FILE_ID);

        mediaPinPage.fillEnrichmentDetails("Title", "MouseoverText", true);

        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.editEnrichment(EnrichmentTypes.Audio);
        mediaPinPage.clearEnrichmentDetails();

        mediaPinPage.fillEnrichmentDetails("Edit Title", "Edit MouseoverText", false);

        bookEditorTemplate.saveEnrichment();

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.Audio);

        System.out.println("audio deleted!");
    }

    @Test
    public void addNewVideoFromListEnrichment() throws InterruptedException {
        MediaPinPage mediaPinPage = PageFactory.initElements(driver, MediaPinPage.class);
        mediaPinPage.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);
        overviewTemplate.click("| Edit");

        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();
        bookEditorTemplate.clickAddNewEnrichmentButton("Add new pin");
        bookEditorTemplate.clickNewTypeEnrichmentButton("Video");

        bookEditorTemplate.waitForSideMenu();
        mediaPinPage.clickSelectFileButton();
        mediaPinPage.searchForAudioFile(BookEditorTemplate.VIDEO_FILE_ID);
        mediaPinPage.chooseFile(BookEditorTemplate.VIDEO_FILE_ID);
        mediaPinPage.fillEnrichmentDetails("Title", "MouseoverText", true);

        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.editEnrichment(EnrichmentTypes.Video);
        mediaPinPage.clearEnrichmentDetails();

        mediaPinPage.fillEnrichmentDetails("Edit Title", "Edit MouseoverText", false);

        bookEditorTemplate.saveEnrichment();

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.Video);

        System.out.println("video deleted!");
    }

    @Test
    public void addNewYoutubeEnrichment() throws InterruptedException {
        YoutubePinPage youtubePinPage = PageFactory.initElements(driver, YoutubePinPage.class);
        youtubePinPage.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);
        overviewTemplate.click("| Edit");

        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();
        bookEditorTemplate.clickAddNewEnrichmentButton("Add new pin");
        bookEditorTemplate.clickNewTypeEnrichmentButton("YouTube");

        bookEditorTemplate.waitForSideMenu();

        youtubePinPage.fillEnrichmentDetails("https://www.youtube.com/watch?v=1SL1bSysul8", "Title", "mouseover text",
                true);

        bookEditorTemplate.saveEnrichment();
        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.editEnrichment(EnrichmentTypes.Youtube);
        youtubePinPage.clearEnrichmentDetails();

        youtubePinPage.fillEnrichmentDetails("https://www.youtube.com/watch?v=1SL1bSysul8", "Edit Title", "mouseover text",
                false);
        bookEditorTemplate.saveEnrichment();

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.Youtube);

        System.out.println("youtube deleted!");
    }
}
