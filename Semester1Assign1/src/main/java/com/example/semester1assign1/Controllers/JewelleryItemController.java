package com.example.semester1assign1.Controllers;

import com.example.semester1assign1.FunkyList;
import com.example.semester1assign1.Models.DisplayCase;
import com.example.semester1assign1.Models.DisplayTray;
import com.example.semester1assign1.Models.JewelleryItem;
import com.example.semester1assign1.Models.Material;
import com.example.semester1assign1.main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class JewelleryItemController implements Initializable {

    @FXML
    public ChoiceBox<String> jiChoiceBoxType;
    @FXML
    public ChoiceBox<String> jiChoiceBoxGender;
    @FXML
    private TextField jiTextFieldPrice;
    @FXML
    private TextField jiTextFieldImage;
    @FXML
    private TextField jiTextFieldDescription;
    public ChoiceBox<DisplayTray> jiChoiceBoxPickTray;
    @FXML
    public ListView<JewelleryItem> jiListView;
    public static JewelleryItemController jicon;
    public DisplayTray selectedTray;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        jiChoiceBoxType.getItems().addAll("Ring", "Watch", "Bracelet");

        jiChoiceBoxGender.getItems().addAll("Male", "Female", "Unisex");

        jicon = this;
    }

    public void AddItem(MouseEvent mouseEvent) {
       // jiListView.getItems().add(jiTextFieldDescription.getText()+" "+jiTextFieldPrice.getText()+" "+jiTextFieldImage.getText()+" "+jiChoiceBoxType.getSelectionModel().getSelectedItem()+" "+jiChoiceBoxGender.getSelectionModel().getSelectedItem());
        selectedTray.jewelleryItemList.add(new JewelleryItem(jiTextFieldDescription.getText(), jiChoiceBoxType.getSelectionModel().getSelectedItem(),jiChoiceBoxGender.getSelectionModel().getSelectedItem(),jiTextFieldImage.getText(),jiTextFieldPrice.getText()));
        updateJIListView(selectedTray);
    }

    public void updateJIListView(DisplayTray dt) {
        jiListView.getItems().clear();
        FunkyList<JewelleryItem>.FunkyNode<JewelleryItem> temp = dt.jewelleryItemList.head;
        while (temp != null) {
            jiListView.getItems().add(temp.getContents());
            temp = temp.next;
        }

    }

    public void switchToDisplayTrays(ActionEvent event) {
        main.primaryStage.setScene(main.scene2);
    }


    public void switchToMaterials(ActionEvent event) {
        main.primaryStage.setScene(main.scene4);
        if(jiListView.getSelectionModel().getSelectedItem()==null) {
            MaterialController.mcon.mListView.getItems().clear();
        }
        else {
            MaterialController.mcon.selectedItem=jiListView.getSelectionModel().getSelectedItem();
            MaterialController.mcon.updateMListView(MaterialController.mcon.selectedItem);
        }
    }

    public void resetItem(ActionEvent event) {
        selectedTray.jewelleryItemList.reset();
        updateJIListView(selectedTray);
    }

    public void removeItem(ActionEvent event) {
        int selectedItem = jiListView.getSelectionModel().getSelectedIndex();
        DisplayTray dt = jiChoiceBoxPickTray.getSelectionModel().getSelectedItem();
        dt.jewelleryItemList.delete(selectedItem);
        updateJIListView(dt);
    }
}

