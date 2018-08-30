package com.schooltas.dashboard.tests.bookEditorTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.books.enrichments.ImageInPopupPage;
import com.schooltas.dashboard.pages.books.enrichments.MediaPinPage;
import com.schooltas.dashboard.pages.books.enrichments.ShapeAnswerPage;
import com.schooltas.dashboard.pages.books.enrichments.TextInPopupAnswerPage;
import com.schooltas.dashboard.pages.books.enrichments.TextOnPageAnswerPage;
import com.schooltas.dashboard.templates.BookEditorTemplate;
import com.schooltas.dashboard.templates.BooksOverviewTemplate;
import com.schooltas.dashboard.tests.BaseClass;
import com.schooltas.dashboard.utils.enums.EnrichmentTypes;
import com.schooltas.dashboard.utils.utils.ActionUtils;

public class AnswerTests extends BaseClass {

    private static BooksOverviewTemplate overviewTemplate;
    private static BookEditorTemplate bookEditorTemplate;

    @BeforeClass
    public static void initTemplates() {
        overviewTemplate = PageFactory.initElements(driver, BooksOverviewTemplate.class);
        bookEditorTemplate = PageFactory.initElements(driver, BookEditorTemplate.class);
    }

    @Test
    public void addTextOnPageAnswer() throws InterruptedException {

        TextOnPageAnswerPage textOnPageAnswer = PageFactory.initElements(driver, TextOnPageAnswerPage.class);
        textOnPageAnswer.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);
        overviewTemplate.click("| Edit");
        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();

        bookEditorTemplate.clickAddNewEnrichmentButton("Add new answer");
        bookEditorTemplate.clickNewTypeEnrichmentButton("Text");
        bookEditorTemplate.waitForSideMenu();

        bookEditorTemplate.chooseTextAnswerType("On page");

        bookEditorTemplate.clickOnThePage();

        textOnPageAnswer.fillAnswerText("Text");
        textOnPageAnswer.chooseLineHeight("18");

        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.editEnrichment(EnrichmentTypes.AnswerText);
        textOnPageAnswer.fillAnswerText("Edit text");
        textOnPageAnswer.chooseLineHeight("20");
        bookEditorTemplate.saveEnrichment();

        //view enrichment
        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.AnswerText);

        System.out.println("text on page answer deleted!");

    }

    @Test
    public void addTextInPopupAnswer() throws InterruptedException{

        TextInPopupAnswerPage textInPopupAnswer = PageFactory.initElements(driver, TextInPopupAnswerPage.class);
        textInPopupAnswer.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);
        overviewTemplate.click("| Edit");
        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();

        bookEditorTemplate.clickAddNewEnrichmentButton("Add new answer");
        bookEditorTemplate.clickNewTypeEnrichmentButton("Text");
        bookEditorTemplate.waitForSideMenu();

        bookEditorTemplate.chooseTextAnswerType("In popup");
        textInPopupAnswer.fillEnrichmentDetails("Title", "Body", "mouseover");

        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.viewEnrichment(EnrichmentTypes.AnswerText);

        bookEditorTemplate.assertEnrichmentDetails("Title");

        ActionUtils.pressEscKey();

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.AnswerText);

        System.out.println("text in popup answer deleted!");
    }

    @Test
    public void addCircleShapeAnswer() throws InterruptedException{

        ShapeAnswerPage shapeAnswer = PageFactory.initElements(driver, ShapeAnswerPage.class);
        shapeAnswer.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);
        overviewTemplate.click("| Edit");
        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();

        bookEditorTemplate.clickAddNewEnrichmentButton("Add new answer");
        bookEditorTemplate.clickNewTypeEnrichmentButton("Shape");
        bookEditorTemplate.waitForSideMenu();

        shapeAnswer.addNewShapeAnswer("Circle");

        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.CircleShape);

        System.out.println("circle shape answer deleted!");
    }

    @Test
    public void addLineShapeAnswer() throws InterruptedException{

        ShapeAnswerPage shapeAnswer = PageFactory.initElements(driver, ShapeAnswerPage.class);
        shapeAnswer.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);
        overviewTemplate.click("| Edit");
        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();

        bookEditorTemplate.clickAddNewEnrichmentButton("Add new answer");
        bookEditorTemplate.clickNewTypeEnrichmentButton("Shape");
        bookEditorTemplate.waitForSideMenu();

        shapeAnswer.addNewShapeAnswer("Line");

        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.LineShape);

        System.out.println("line shape answer deleted!");
    }

    @Test
    public void addCrossShapeAnswer() throws InterruptedException{

        ShapeAnswerPage shapeAnswer = PageFactory.initElements(driver, ShapeAnswerPage.class);
        shapeAnswer.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);
        overviewTemplate.click("| Edit");
        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();

        bookEditorTemplate.clickAddNewEnrichmentButton("Add new answer");
        bookEditorTemplate.clickNewTypeEnrichmentButton("Shape");
        bookEditorTemplate.waitForSideMenu();

        shapeAnswer.addNewShapeAnswer("Cross");

        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.CrossShape);

        System.out.println("cross shape answer deleted!");
    }

    @Test
    public void addCheckmarkShapeAnswer() throws InterruptedException{

        ShapeAnswerPage shapeAnswer = PageFactory.initElements(driver, ShapeAnswerPage.class);
        shapeAnswer.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);
        overviewTemplate.click("| Edit");
        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();

        bookEditorTemplate.clickAddNewEnrichmentButton("Add new answer");
        bookEditorTemplate.clickNewTypeEnrichmentButton("Shape");
        bookEditorTemplate.waitForSideMenu();

        shapeAnswer.addNewShapeAnswer("Checkmark");

        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.CheckShape);

        System.out.println("check shape answer deleted!");
    }

    @Test
    public void addImageInPopupAnswer() throws InterruptedException{
        ImageInPopupPage imageInPopupPage = PageFactory.initElements(driver, ImageInPopupPage.class);
        imageInPopupPage.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);
        overviewTemplate.click("| Edit");
        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();

        bookEditorTemplate.clickAddNewEnrichmentButton("Add new answer");
        bookEditorTemplate.clickNewTypeEnrichmentButton("Image in popup");
        bookEditorTemplate.waitForSideMenu();

        imageInPopupPage.fillEnrichmentDetails("Test image in popup", "mouseover text", "/Users/dantal/Downloads/PDFs/test2.jpg", false);
        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        //bookEditorTemplate.viewEnrichment(EnrichmentTypes.AnswerImage);

        //bookEditorTemplate.assertEnrichmentDetails("Test image in popup");

        //ActionUtils.pressEscKey();

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.AnswerImage);

        System.out.println("image in popup answer deleted!");
    }

    @Test
    public void addAudioAnswer() throws InterruptedException{

        MediaPinPage mediaPinPage = PageFactory.initElements(driver, MediaPinPage.class);
        mediaPinPage.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);
        overviewTemplate.click("| Edit");
        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();

        bookEditorTemplate.clickAddNewEnrichmentButton("Add new answer");
        bookEditorTemplate.clickNewTypeEnrichmentButton("Audio");
        bookEditorTemplate.waitForSideMenu();

        mediaPinPage.clickSelectFileButton();

        mediaPinPage.searchForAudioFile(BookEditorTemplate.AUDIO_FILE_ID);
        mediaPinPage.chooseFile(BookEditorTemplate.AUDIO_FILE_ID);

        mediaPinPage.fillEnrichmentDetails("Title", "MouseoverText", false);

        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.AnswerAudio);

        System.out.println("audio answer deleted!");
    }
}
