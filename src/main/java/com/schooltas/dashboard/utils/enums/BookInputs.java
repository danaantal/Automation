package com.schooltas.dashboard.utils.enums;

public enum BookInputs {

	Title("book title automate","edit book title automate"),
	EAN(null, "3711413071302"),
	Subject("#Test", "#Test"),
	Type("Coursebook", "Workbook"),
	Year("2", "2"),
	Method("book method", "edit book method"),
	Stream("book stream", "edit book stream"),
	PDF("/Users/dantal/Downloads/PDFs/E-book.pdf", null),
	Cover("/Users/dantal/Downloads/PDFs/test2.jpg", null);

	private String createInput;
	private String editInput;

	BookInputs(String createInput, String editInput){
		this.createInput = createInput;
		this.editInput = editInput;
	}

	public String getCreateInput(){
		return createInput;
	}

	public String getEditInput(){
		return editInput;
	}
}
