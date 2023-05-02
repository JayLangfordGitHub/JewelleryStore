package com.example.semester1assign1.Models;

import com.example.semester1assign1.FunkyList;

public class DisplayTray {
    public String trayIdentifier;
    private String trayColour;
    private String trayHeight;
    private String trayWidth;

    public FunkyList<JewelleryItem> jewelleryItemList = new FunkyList<>();

    //CONSTRUCTOR

    public DisplayTray (String trayIdentifier, String trayColour, String trayHeight, String trayWidth){
        this.trayIdentifier = trayIdentifier;
        this.trayColour = trayColour;
        this.trayHeight = trayHeight;
        this.trayWidth = trayWidth;
    }

    //SETTERS AND GETTERS


    public String getTrayIdentifier() {
        return trayIdentifier;
    }

    public void setTrayIdentifier(String trayIdentifier) {
        this.trayIdentifier = trayIdentifier;
    }

    public String getTrayColour() {
        return trayColour;
    }

    public void setTrayColour(String trayColour) {
        this.trayColour = trayColour;
    }

    public String getTrayHeight() {
        return trayHeight;
    }

    public void setTrayHeight(String trayHeight) {
        this.trayHeight = trayHeight;
    }

    public String getTrayWidth() {
        return trayWidth;
    }

    public void setTrayWidth(String trayWidth) {
        this.trayWidth = trayWidth;
    }

    @Override
    public String toString() {
        return "   Tray Identifier : "+ trayIdentifier +
                "   Tray Colour : "+ trayColour+
                "   Tray Width :"+ trayWidth+"cm"+
                "   Tray Size : "+ trayHeight+"cm";
    }
}
