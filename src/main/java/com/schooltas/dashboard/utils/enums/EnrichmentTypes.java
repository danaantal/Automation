package com.schooltas.dashboard.utils.enums;

public enum EnrichmentTypes {

	Text("Text", "div.popover-canvas.inside-scroll"),
	Gallery("Gallery", "div.image-popup-viewer.shown"),
	Audio("Audio", "div.media-player-container.show-player-transition.Audio"),
	Video("Video", "div.media-player-container.show-player-transition.Video"),
	Youtube("Video", "div.media-player-container.show-player-transition.YouTube"),
	Link("Link", null),
	Shape("Shape", "div.abs.circle-shape.shape.click-area"),
	InternalLinkMarker("InternalLinkMarker", null),
	HotspotImage("HotspotImage", "div#painting-viewer.open");

	private String type;
	private String selector;

	EnrichmentTypes(String type, String selector){
		this.type = type;
		this.selector = selector;
	}

	public String getSelector(){
		return selector;
	}

	public String getType(){
		return type;
	}
}
