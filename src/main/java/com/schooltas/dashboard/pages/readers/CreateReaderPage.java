package com.schooltas.dashboard.pages.readers;


import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.internal.collections.Pair;

public class CreateReaderPage {
	
	@FindBy(id="book.title")
	WebElement readerTitle;
	
	@FindBy(id="subjectId")
	WebElement courseName;
	
	@FindBy(id="file")
	WebElement uploadButton;
	
	@FindBy(how = How.CSS, using = "[type='submit']" )
	WebElement saveButton;
	
	public void createReader(){
		ArrayList<Pair<WebElement,String>> readerDetails = createReaderDetailsInputList();
		
		readerDetails.forEach((element) -> {
			element.first().sendKeys(element.second());
		});
		
		uploadButton.sendKeys("E:/DOWNLOADS/geography.pdf");
		saveButton.click();
				
	}
	
	public ArrayList<Pair<WebElement,String>> createReaderDetailsInputList(){
		ArrayList<Pair<WebElement,String>> createReaderFormDetails = new ArrayList<>();
		createReaderFormDetails.add(new Pair<>(readerTitle,"Test Reader"));
		createReaderFormDetails.add(new Pair<>(courseName,"#Test"));
		
		return createReaderFormDetails; 
	}
}
