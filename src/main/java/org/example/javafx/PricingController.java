package org.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PricingController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}