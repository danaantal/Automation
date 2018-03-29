package com.schooltas.dashboard.utils.enums;

public enum EnrichmentTypes {

    Text("Text", "div.popover-canvas.inside-scroll"),
    Gallery("Gallery", "div.image-popup-viewer.shown"),
    Audio("Audio", "div.media-player-container.show-player-transition.Audio"),
    Video("Video", "div.media-player-container.show-player-transition.Video"),
    Youtube("Video", "div.media-player-container.show-player-transition.YouTube"),
    Link("Link", null),
    CircleShape("Shape", "div.abs.circle-shape.shape.click-area"),
    LineShape("Shape", "div.abs.line-shape.shape.click-area"),
    CrossShape("Shape", "div.abs.cross-shape.shape.click-area"),
    CheckShape("Shape", "div.abs.checkmark-shape.shape.click-area"),
    InternalLinkMarker("InternalLinkMarker", null),
    HotspotImage("HotspotImage", "div#painting-viewer.open"),
    AnswerText("Text", "div.prikker.has-answers"),
    AnswerAudio("Audio", "div.prikker.has-answers"),
    AnswerImage("Gallery", "div.prikker.has-answers");

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
