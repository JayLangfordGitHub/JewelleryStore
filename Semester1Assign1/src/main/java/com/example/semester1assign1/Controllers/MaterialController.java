package com.example.semester1assign1.Controllers;

import com.example.semester1assign1.FunkyList;
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

public class MaterialController implements Initializable {

    @FXML
    private ChoiceBox<String> mChoiceBoxType;
    @FXML
    private TextField mTextFieldDescription;
    @FXML
    private TextField mTextFieldQuantity;
    @FXML
    private TextField mTextFieldQuality;
    public ChoiceBox<JewelleryItem> mChoiceBoxPickItem;
    @FXML
    public ListView mListView;
    public static MaterialController mcon;
    public JewelleryItem selectedItem;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mChoiceBoxType.getItems().addAll("Platinum","Gold","Diamond","Emerald","Silver");

        mcon=this;
    }

    public void deleteMaterial(MouseEvent mouseEvent) {
        int selectedItem = mListView.getSelectionModel().getSelectedIndex();
        JewelleryItem ji = mChoiceBoxPickItem.getSelectionModel().getSelectedItem();
        ji.materialList.delete(selectedItem);
        updateMListView(ji);
    }

    public void addMaterial(MouseEvent mouseEvent) {
        selectedItem.materialList.add(new Material(mChoiceBoxType.getSelectionModel().getSelectedItem(), mTextFieldDescription.getText(), mTextFieldQuantity.getText(), mTextFieldQuality.getText()));
        updateMListView(selectedItem);
    }

    public void updateMListView(JewelleryItem ji) {
        mListView.getItems().clear();
        FunkyList<Material>.FunkyNode<Material> temp = ji.materialList.head;
        while (temp != null) {
            mListView.getItems().add(temp.getContents());
            temp = temp.next;
        }
    }

    public void switchToJewelleryItem(ActionEvent event) {
        main.primaryStage.setScene(main.scene3);
    }

    public void resetMaterial(ActionEvent event) {
        selectedItem.materialList.reset();
        updateMListView(selectedItem);
    }
}
