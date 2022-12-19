package com.example.bmicalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BMICalculator extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("BMI Calculator");

        // Create the labels
        Label weightLabel = new Label("Weight (kg):");
        Label heightLabel = new Label("Height (cm):");
        Label bmiLabel = new Label("BMI:");
        Label resultLabel = new Label("Result:");

        // Create the text fields
        TextField weightField = new TextField();
        TextField heightField = new TextField();
        TextField bmiField = new TextField();
        bmiField.setEditable(false);
        TextField resultField = new TextField();
        resultField.setEditable(false);

        // Create the calculate button
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(event -> {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText()) / 100; // Convert to meters
            double bmi = weight / (height * height);
            bmiField.setText(String.format("%.1f", bmi));

            String result;
            if (bmi < 18.5) {
                result = "Underweight";
            } else if (bmi < 25) {
                result = "Normal weight";
            } else if (bmi < 30) {
                result = "Overweight";
            } else {
                result = "Obese";
            }
            resultField.setText(result);
        });

        // Create the layout
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10));
        layout.setVgap(8);
        layout.setHgap(10);
        layout.setAlignment(Pos.CENTER);
        layout.add(weightLabel, 0, 0);
        layout.add(weightField, 1, 0);
        layout.add(heightLabel, 0, 1);
        layout.add(heightField, 1, 1);
        layout.add(bmiLabel, 0, 2);
        layout.add(bmiField, 1, 2);
        layout.add(resultLabel, 0, 3);
        layout.add(resultField, 1, 3);
        layout.add(calculateButton, 1, 4);

        // Set the scene and show the stage
        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }
}
