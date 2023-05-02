package com.example.semester1assign1.Models;

import com.example.semester1assign1.FunkyList;
import com.example.semester1assign1.Controllers.JewelleryItemController;

public class JewelleryItem {
    private String jewelleryDescription;
    private String jewelleryType;
    private String jewelleryGender;
    private String jewelleryImage;
    private String jewelleryPrice;

    public FunkyList<Material> materialList = new FunkyList<>();

    public JewelleryItem (String jewelleryDescription, String jewelleryType, String jewelleryGender, String jewelleryImage, String jewelleryPrice){
        this.jewelleryDescription = jewelleryDescription;
        this.jewelleryType = jewelleryType;
        this.jewelleryGender = jewelleryGender;
        this.jewelleryImage = jewelleryImage;
        this.jewelleryPrice = jewelleryPrice;
    }

    public String getJewelleryDescription() {
        return jewelleryDescription;
    }

    public void setJewelleryDescription(String jewelleryDescription) {
        this.jewelleryDescription = jewelleryDescription;
    }

    public String getJewelleryType() {
        return jewelleryType;
    }

    public void setJewelleryType(String jewelleryType) {
        this.jewelleryType = jewelleryType;
    }

    public String getJewelleryGender() {
        return jewelleryGender;
    }

    public void setJewelleryGender(String jewelleryGender) {
        this.jewelleryGender = jewelleryGender;
    }

    public String getJewelleryImage() {
        return jewelleryImage;
    }

    public void setJewelleryImage(String jewelleryImage) {
        this.jewelleryImage = jewelleryImage;
    }

    public String getJewelleryPrice() {
        return jewelleryPrice;
    }

    public void setJewelleryPrice(String jewelleryPrice) {
        this.jewelleryPrice = jewelleryPrice;
    }

    @Override
    public String toString() {
        return "   Gender : "+ jewelleryGender +
                "   Price : "+ jewelleryPrice +
                "   Description : "+ jewelleryDescription +
                "   Type : "+ jewelleryType +
                "   Image : "+ jewelleryImage;
    }
}
