package com.example.semester1assign1.Controllers;

import com.example.semester1assign1.FunkyList;
import com.example.semester1assign1.Models.DisplayCase;
import com.example.semester1assign1.Models.DisplayTray;
import com.example.semester1assign1.Models.JewelleryItem;
import com.example.semester1assign1.main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.semester1assign1.main.DisplayCaseList;

public class DisplayTrayController implements Initializable {
    @FXML
    public ChoiceBox<DisplayCase> dtChoiceBoxPickCase;
    @FXML
    private ChoiceBox<String> dtChoiceBoxColour;
    @FXML
    public TextField dtTextFieldNumber;
    @FXML
    private TextField dtTextFieldWidth;
    @FXML
    private TextField dtTextFieldHeight;
    @FXML
    public ListView<DisplayTray> dtListView;
    public static DisplayTrayController dtcon;

    public DisplayCase selectedCase;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dtChoiceBoxColour.getItems().addAll("Red","Blue","Green","Purple","Orange");                                 //initialize the choicebox to populate it with options

        dtcon=this;

    }

    public void dtDeleteTray(MouseEvent mouseEvent) {
        int selectedTray = dtListView.getSelectionModel().getSelectedIndex();
        DisplayCase dc = dtChoiceBoxPickCase.getSelectionModel().getSelectedItem();
        dc.displayTrayList.delete(selectedTray);
        updateDTListView(dc);
    }

    public void addTray(MouseEvent mouseEvent) {
        selectedCase.displayTrayList.add(new DisplayTray(dtTextFieldNumber.getText(),dtChoiceBoxColour.getSelectionModel().getSelectedItem(),dtTextFieldHeight.getText(),dtTextFieldWidth.getText()));
        updateDTListView(selectedCase);

    }

    public void updateDTListView(DisplayCase dc) {
        dtListView.getItems().clear();                                                                                   //clears the list first
        FunkyList<DisplayTray>.FunkyNode<DisplayTray> temp = dc.displayTrayList.head;                                    //calls the head of the display tray linked list and calls it temp
        while (temp != null) {                                                                                           //when temp is not null
            dtListView.getItems().add(temp.getContents());                                                               //adds the contents of displaytray list to the list
            temp = temp.next;                                                                                            //makes temp the next element in the list
        }
    }
    public void switchToDisplayCases(ActionEvent event){
        main.primaryStage.setScene(main.scene1);                                                                         //changes the primary scene to scene 1(Display Case)
    }
    public void switchToJewellery(ActionEvent event){
        main.primaryStage.setScene(main.scene3);                                                                         //switches primary stage to scene 3(Jewellery Item)
        if(dtListView.getSelectionModel().getSelectedItem()==null) {                                                     //if a tray is not selected
            JewelleryItemController.jicon.jiListView.getItems().clear();                                                 //it will clear the jewellery list view of anything in it
        }
        else {
            JewelleryItemController.jicon.selectedTray=dtListView.getSelectionModel().getSelectedItem();                 //otherwise if a tray is selected
            JewelleryItemController.jicon.updateJIListView(JewelleryItemController.jicon.selectedTray);                  //the jewellery item list will be updated with the selected tray i.e. you enter the selected tray
        }
    }

    public void resetTray(ActionEvent event) {
        selectedCase.displayTrayList.reset();                                                                            //resets the head of the displaytraylist
        updateDTListView(selectedCase);
    }


}
