package com.example.semester1assign1;

import com.example.semester1assign1.Models.DisplayCase;
import com.example.semester1assign1.Models.DisplayTray;
import com.example.semester1assign1.Models.JewelleryItem;
import com.example.semester1assign1.Models.Material;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {

    public static FunkyList<DisplayCase> DisplayCaseList = new FunkyList<>();
    public static Scene scene1,scene2,scene3,scene4,scene5;
    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException{
        primaryStage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("main.fxml"));
        scene1 = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Jewellery Store");
        stage.setScene(scene1);
        stage.show();

        fxmlLoader = new FXMLLoader(main.class.getResource("DisplayTray.fxml"));
        scene2 = new Scene(fxmlLoader.load(),600,400);

        fxmlLoader = new FXMLLoader(main.class.getResource("JewelleryItem.fxml"));
        scene3 = new Scene(fxmlLoader.load(),600,400);

        fxmlLoader = new FXMLLoader(main.class.getResource("Material.fxml"));
        scene4 = new Scene(fxmlLoader.load(),600,400);

        fxmlLoader = new FXMLLoader(main.class.getResource("ViewAll.fxml"));
        scene5 = new Scene(fxmlLoader.load(),600,400);


        // main.primaryStage.setScene(main.scene2);

    }
    public static void main(String[] args) {
        launch();
    }
}