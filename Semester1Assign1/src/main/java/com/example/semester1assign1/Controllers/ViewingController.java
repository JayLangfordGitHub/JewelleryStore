package com.example.semester1assign1.Controllers;

import com.example.semester1assign1.FunkyList;
import com.example.semester1assign1.Models.DisplayCase;
import com.example.semester1assign1.Models.DisplayTray;
import com.example.semester1assign1.Models.JewelleryItem;
import com.example.semester1assign1.main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.semester1assign1.main.*;

public class ViewingController {

    @FXML
    public TextField searchBar;

    @FXML
    public ListView listViewAll;

    public void switchToDisplayCase(ActionEvent event) {
        main.primaryStage.setScene(main.scene1);
    }

    public void loadAll(){                                                                                                //use loadAll to run the update method for the View All Jewellery Items List
        UpdateViewingListView();
    }

    public void UpdateViewingListView() {                                                                                 //updates the View all items list using a nested loop
        listViewAll.getItems().clear();                                                                                   //clear anything in the list before adding anything
        FunkyList<DisplayCase>.FunkyNode<DisplayCase> tempDC = DisplayCaseList.head;
        while (tempDC != null) {                                                                                          //calls displaycaselist runs through it and when its not null(finds a case) moves onto the next part of the loop
            listViewAll.getItems().add(tempDC.getContents().caseNumber+" = Case Number");
            FunkyList<DisplayTray>.FunkyNode<DisplayTray> tempDT = tempDC.getContents().displayTrayList.head;
            while (tempDT != null) {
                listViewAll.getItems().add("\t" + tempDT.getContents().trayIdentifier+" = Tray Number");
                FunkyList<JewelleryItem>.FunkyNode<JewelleryItem> tempJI = tempDT.getContents().jewelleryItemList.head;
                while (tempJI != null) {
                    listViewAll.getItems().add("\t\t" +tempJI.getContents());
                    tempJI = tempJI.next;
                }
                tempDT = tempDT.next;
            }
            tempDC = tempDC.next;
        }
    }

    public void searchLists(ActionEvent event) {
        listViewAll.getItems().clear();
        searching();
    }

    public void searching() {
        listViewAll.getItems().clear();
        FunkyList<DisplayCase>.FunkyNode<DisplayCase> tempDC = DisplayCaseList.head;
        while (tempDC != null) {
            FunkyList<DisplayTray>.FunkyNode<DisplayTray> tempDT = tempDC.getContents().displayTrayList.head;
            while (tempDT != null) {
                FunkyList<JewelleryItem>.FunkyNode<JewelleryItem> tempJI = tempDT.getContents().jewelleryItemList.head;
                while (tempJI != null) {
                    if(tempJI.getContents().getJewelleryGender().contains(searchBar.getText()))                                    //if the text in the search bar matches a gender of jewellery in the jewellery item linked list
                    {
                        //listViewAll.getItems().clear();
                        listViewAll.getItems().add(tempJI.getContents());                                                               //then it will add it to the listview
                    }
                    else{
                        if(tempJI.getContents().getJewelleryType().contains(searchBar.getText())){
                           // listViewAll.getItems().clear();
                            listViewAll.getItems().add(tempJI.getContents());
                        }
                        else{
                            if (tempJI.getContents().getJewelleryDescription().contains(searchBar.getText())){
                                listViewAll.getItems().add(tempJI.getContents());
                            }
                        }
                    }
                  //  listViewAll.getItems().add("\t\t" +tempJI.getContents());
                    tempJI = tempJI.next;
                }
                tempDT = tempDT.next;
            }
            tempDC = tempDC.next;
        }
    }

    public void getAllPrices(ActionEvent event) {

        listViewAll.getItems().clear();

        int total=0;

        FunkyList<DisplayCase>.FunkyNode<DisplayCase> tempDC = DisplayCaseList.head;
        while (tempDC != null) {
            int dctotal=0;
            listViewAll.getItems().add(tempDC.getContents().caseNumber+" = Case Number");
            FunkyList<DisplayTray>.FunkyNode<DisplayTray> tempDT = tempDC.getContents().displayTrayList.head;

            while (tempDT != null) {
                int dttotal=0;
                listViewAll.getItems().add("\t" + tempDT.getContents().trayIdentifier+" = Tray Number");
                FunkyList<JewelleryItem>.FunkyNode<JewelleryItem> tempJI = tempDT.getContents().jewelleryItemList.head;
                while (tempJI != null) {
                    listViewAll.getItems().add("\t\t" +tempJI.getContents());
                    dctotal+=Integer.parseInt(tempJI.getContents().getJewelleryPrice());
                    dttotal+=Integer.parseInt(tempJI.getContents().getJewelleryPrice());
                    total+=Integer.parseInt(tempJI.getContents().getJewelleryPrice());
                    tempJI = tempJI.next;
                    listViewAll.getItems().add(tempDT.getContents().trayIdentifier+": Current Trays Total = "+dttotal);
                }
                tempDT = tempDT.next;
                listViewAll.getItems().add(tempDC.getContents().caseNumber+": Current Case's Total = "+dctotal);
            }
            tempDC = tempDC.next;

            listViewAll.getItems().add("Total Price of Jewellery = "+total);
        }



    }
}
