package com.schooltas.dashboard.pages.books.enrichments;

import com.schooltas.dashboard.templates.BookEditorTemplate;

public abstract class Enrichment {

	protected BookEditorTemplate bookEditorTemplate;

	public void setBookEditorTemplate(BookEditorTemplate bookEditorTemplate) {
		this.bookEditorTemplate = bookEditorTemplate;
	}

}

