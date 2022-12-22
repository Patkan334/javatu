package com.example.demo468_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override // Override the start method in the Application class
        public void start(Stage primaryStage) {
            FXMLLoader fxmlLoader= new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Label height=new Label("Height");
            Label weight=new Label("Weight");
            Label res=new Label("Result");
            TextField text_fl1=new TextField();
            text_fl1.setStyle("−fx−border−color: rgb(0,0,0)" );
            height.setAlignment(Pos.CENTER);

            TextField text_fl2=new TextField();
            text_fl1.setText("");
            text_fl2.setText("");
            TextField text_fl3=new TextField();
            Button button= new Button(" Calculate Body mass index");


            //text_fl3.setText();

            GridPane drp=new GridPane();
            drp.addRow(0, height, text_fl1);
            drp.addRow(1, weight, text_fl2);
            drp.addRow(2, res, text_fl3);
            drp.addRow(3, button);

            Scene scene=new Scene(drp, 1000, 600);

            ImageView us = new ImageView(new Image("bmi.gif"));
            drp.add(us, 1, 5);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Body mass index calculator\n");

            //Label lb1 = new Label("Body mass index calculator\n", us);
            //lb1.setContentDisplay(ContentDisplay.BOTTOM);
            //lb1.setTextFill(Color.BLACK);

            //HBox pane = new HBox(20);
            //pane.getChildren().addAll(lb1);

            // Create a scene and place it in the stage
           // Scene scene = new Scene(pane, 450, 150);
           // primaryStage.setTitle("Body mass index calculator"); // Set the stage title
           // primaryStage.setScene(scene); // Place the scene in the stage
            button.setOnAction(e->{
                String height1=text_fl1.getText();
                String height2=text_fl2.getText();

                BMI bmi=new BMI("Penka",22,  Integer.parseInt(height2) , Integer.parseInt(height1)  );
                text_fl3.setText(" " + bmi.getBMI());
            });
            primaryStage.show();


        }
    public static void main(String[] args) {
        launch();
    }
}
