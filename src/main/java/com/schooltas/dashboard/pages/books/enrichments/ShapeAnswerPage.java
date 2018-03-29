package com.schooltas.dashboard.pages.books.enrichments;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShapeAnswerPage extends Enrichment {

    @FindBy(how = How.CSS, using = "div.prikker-container.show-markers")
    private List<WebElement> pageOverlay;

    @FindBy(how = How.CSS, using = "div.abs.circle-shape.shape.click-area")
    private WebElement circle;

    @FindBy(how = How.CSS, using = "div.abs.line-shape.shape.click-area")
    private WebElement line;

    @FindBy(how = How.CSS, using = "div.abs.cross-shape.shape.click-area")
    private WebElement cross;

    @FindBy(how = How.CSS, using = "div.abs.checkmark-shape.shape.click-area")
    private WebElement checkmark;


    public void addNewShapeAnswer(String shapeName){

        if(shapeName.equals("Circle")){
            dragAndDropShape(circle, pageOverlay.get(1));
        }
        else if(shapeName.equals("Cross")){
            dragAndDropShape(cross, pageOverlay.get(1));
        }
        else if(shapeName.equals("Line")){
            dragAndDropShape(line, pageOverlay.get(1));
        }
        else if(shapeName.equals("Checkmark")){
            dragAndDropShape(checkmark, pageOverlay.get(1));
        }

    }

    public void dragAndDropShape(WebElement shape, WebElement page){

        Actions builder = new Actions(bookEditorTemplate.getDriver());

        builder.dragAndDrop(shape, page).build().perform();
    }
}
