package com.example.semester1assign1.Models;

import com.example.semester1assign1.FunkyList;

public class Material {
    private String materialType;
    private String materialDescription;
    private String materialWeight;
    private String materialQuality;

    public Material (String materialType, String materialDescription, String materialWeight, String materialQuality){
        this.materialType = materialType;
        this.materialDescription = materialDescription;
        this.materialWeight = materialWeight;
        this.materialQuality = materialQuality;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public String getMaterialWeight() {
        return materialWeight;
    }

    public void setMaterialWeight(String materialWeight) {
        this.materialWeight = materialWeight;
    }

    public String getMaterialQuality() {
        return materialQuality;
    }

    public void setMaterialQuality(String materialQuality) {
        this.materialQuality = materialQuality;
    }

    @Override
    public String toString() {
        return "   Material Type : "+ materialType +
                "   Material Description : "+ materialDescription +
                "   Material Weight : "+ materialWeight+"g" +
                "   Material Quality : "+ materialQuality+"ct";
    }
}
