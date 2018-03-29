package com.schooltas.dashboard.pages.books.enrichments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.dashboard.utils.utils.ActionUtils;

public class TextOnPageAnswerPage extends Enrichment {

    private final WebDriver driver;

    public TextOnPageAnswerPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id = "edit-textLineHeight")
    private WebElement lineHeightDropdown;

    @FindBy(how = How.CSS, using = "div.textarea-container")
    private WebElement answerTextArea;

    public void chooseLineHeight(String lineHeight) {
        ActionUtils.waitForElementToBeClickable(lineHeightDropdown);
        lineHeightDropdown.sendKeys(lineHeight);
    }

    public void fillAnswerText(String text) {

        Actions actions = new Actions(driver);
        actions.moveToElement(answerTextArea);
        actions.sendKeys(text);
        actions.build().perform();
    }


}
