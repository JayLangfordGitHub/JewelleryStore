package com.example.semester1assign1.Controllers;

import com.example.semester1assign1.FunkyList;
import com.example.semester1assign1.Models.DisplayCase;
import com.example.semester1assign1.Models.DisplayTray;
import com.example.semester1assign1.Models.JewelleryItem;
import com.example.semester1assign1.Models.Material;
import com.example.semester1assign1.main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.semester1assign1.main.DisplayCaseList;

public class mainController implements Initializable {
    @FXML
    private ChoiceBox<String> mainChoiceBoxLighting;
    @FXML
    private ChoiceBox<String> mainChoiceBoxType;
    @FXML
    public ListView<DisplayCase> mainListView;
    @FXML
    private TextField mainTextField;

    public static mainController dccon;

    public DisplayCase selectedMain;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainChoiceBoxLighting.getItems().addAll("Lit","Unlit");

        mainChoiceBoxType.getItems().addAll("Free Standing","Wall-Mounted");
    }

    public void addCase(javafx.scene.input.MouseEvent mouseEvent) {
        DisplayCaseList.add(new DisplayCase(mainChoiceBoxLighting.getSelectionModel().getSelectedItem(),mainChoiceBoxType.getSelectionModel().getSelectedItem(),mainTextField.getText()));
        UpdateDCListView();
    }

    public void UpdateDCListView() {
        mainListView.getItems().clear();
        FunkyList<DisplayCase>.FunkyNode<DisplayCase> temp = main.DisplayCaseList.head;
        while (temp != null) {
            mainListView.getItems().add(temp.getContents());
            temp = temp.next;
        }
    }



    public void switchToDisplayTray(ActionEvent event) throws IOException {
        main.primaryStage.setScene(main.scene2);
        if(mainListView.getSelectionModel().getSelectedItem()==null) {
            DisplayTrayController.dtcon.dtListView.getItems().clear();
        }
        else {
            DisplayTrayController.dtcon.selectedCase=mainListView.getSelectionModel().getSelectedItem();
            DisplayTrayController.dtcon.updateDTListView(DisplayTrayController.dtcon.selectedCase);
        }
    }

    public void saveAll(){
        try {
            save();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loadAll(){
        try {
            load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[] { DisplayCase.class,DisplayTray.class, JewelleryItem.class, Material.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader(fileName()));
        DisplayCaseList = (FunkyList<DisplayCase>) is.readObject();
        is.close();
    }

    public void save() throws Exception {
        Class<?>[] classes = new Class[] { FunkyList.class, FunkyList.FunkyNode.class, DisplayCase.class,DisplayTray.class, JewelleryItem.class, Material.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypes(classes);

       // XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(fileName()));
        out.writeObject(DisplayCaseList);
        out.close();
    }

    public String fileName(){
        return "assignment.xml";
    }

    public void deleteCase(javafx.scene.input.MouseEvent mouseEvent) {
        int selectedMain = mainListView.getSelectionModel().getSelectedIndex();
        DisplayCaseList.delete(selectedMain);
        UpdateDCListView();
    }

    public void resetCase(ActionEvent event) {
        DisplayCaseList.reset();
        UpdateDCListView();
    }

    public void switchToViewing(ActionEvent event) {
        main.primaryStage.setScene(main.scene5);

    }
}
