package com.schooltas.dashboard.tests.bookEditorTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.schooltas.dashboard.pages.books.enrichments.HotspotImagePage;
import com.schooltas.dashboard.pages.books.enrichments.InternalLinkPage;
import com.schooltas.dashboard.templates.BookEditorTemplate;
import com.schooltas.dashboard.templates.BooksOverviewTemplate;
import com.schooltas.dashboard.tests.BaseClass;
import com.schooltas.dashboard.utils.enums.EnrichmentTypes;
import com.schooltas.dashboard.utils.utils.ActionUtils;

public class CreateOtherEnrichmentsTests extends BaseClass {

    private static BooksOverviewTemplate overviewTemplate;
    private static BookEditorTemplate bookEditorTemplate;

    @BeforeClass
    public static void initTemplates() {
        overviewTemplate = PageFactory.initElements(driver, BooksOverviewTemplate.class);
        bookEditorTemplate = PageFactory.initElements(driver, BookEditorTemplate.class);
    }

    @Test
    public void addInternalLinkEnrichment() throws InterruptedException {

        InternalLinkPage internalLink = PageFactory.initElements(driver, InternalLinkPage.class);
        internalLink.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);

        overviewTemplate.click("| Edit");
        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();
        bookEditorTemplate.clickAddNewEnrichmentButton("Add new [internalLink]");

        bookEditorTemplate.waitForSideMenu();

        internalLink.fillInternalLinkDetails("5", "34", true, "mouseover text");

        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.InternalLinkMarker);

        System.out.println("internal link deleted!");
    }

    @Test
    public void addHotspotImageEnrichment() throws InterruptedException {

        HotspotImagePage hotSpot = PageFactory.initElements(driver, HotspotImagePage.class);
        hotSpot.setBookEditorTemplate(bookEditorTemplate);

        dashboardMenu.clickMainMenuOption("Books");

        overviewTemplate.searchForEntityByEan(BookEditorTemplate.EAN_CREATE);

        overviewTemplate.click("| Edit");
        ActionUtils.switchwindow();

        bookEditorTemplate.navigateTotheNextPage();
        bookEditorTemplate.rightClickOnThePage();
        bookEditorTemplate.clickAddNewEnrichmentButton("Add new image with hotspots");

        bookEditorTemplate.waitForSideMenu();

        hotSpot.completeStepOne();
        bookEditorTemplate.goToNextStep();

        hotSpot.completeStepTwo("SK-A-5");
        bookEditorTemplate.clickSideMenu();
        bookEditorTemplate.goToNextStep();

        hotSpot.completeStepThree("title", "mouseover", "https://www.goodreads.com");
        bookEditorTemplate.saveEnrichment();

        ActionUtils.waitForElementInvisible(bookEditorTemplate.getLoadingIcon());

        bookEditorTemplate.deleteEnrichment(EnrichmentTypes.HotspotImage);

        System.out.println("hotspot image deleted!");

    }
}
