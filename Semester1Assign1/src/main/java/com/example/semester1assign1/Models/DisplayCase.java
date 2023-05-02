package com.example.semester1assign1.Models;

import com.example.semester1assign1.FunkyList;

public class DisplayCase {
    public String caseType;
    public String caseLighting;
    public String caseNumber;

    public FunkyList <DisplayTray> displayTrayList = new FunkyList<>();


    public DisplayCase (String caseType, String caseLighting, String caseNumber  ){
        this.caseType = caseType;
        this.caseLighting = caseLighting;
        this.caseNumber = caseNumber;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseLighting() {
        return caseLighting;
    }

    public void setCaseLighting(String caseLighting) {
        this.caseLighting = caseLighting;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    @Override
    public String toString() {
        return "   Case Type : " +caseType +
                "   Case Lighting : " +caseLighting +
                "   Case Number : "+caseNumber;

    }
}

