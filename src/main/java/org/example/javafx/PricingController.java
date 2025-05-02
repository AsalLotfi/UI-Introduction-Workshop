package org.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PricingController {

    @FXML
    private VBox planOne, planTwo, planThree;

    @FXML
    public void initialize() {
        applyHoverEffect(planOne);
        applyHoverEffect(planTwo);
        applyHoverEffect(planThree);
    }

    private void applyHoverEffect(Node node) {
        if (node == null) {
            System.out.println("Node is null. Check fx:id or FXML loading.");
            return;
        }

        node.setOnMouseEntered(event -> {
            node.setScaleX(1.1);
            node.setScaleY(1.1);
        });

        node.setOnMouseExited(event -> {
            node.setScaleX(1.0);
            node.setScaleY(1.0);
        });
    }

    public void handleShopClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("payment-view.fxml"));
        Parent paymentRoot = loader.load();
        Scene paymentScene = new Scene(paymentRoot);

        // Apply Dark Mode CSS
        paymentScene.getStylesheets().add(getClass().getResource("/org/example/javafx/dark-theme.css").toExternalForm());

        // Get the current stage from the event
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        stage.setScene(paymentScene);
        stage.setTitle("Payment");
    }

    public void handleBackClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pricing-view.fxml"));
        Parent pricingRoot = loader.load();
        Scene pricingScene = new Scene(pricingRoot);

        // Apply Dark Mode CSS
        pricingScene.getStylesheets().add(getClass().getResource("/org/example/javafx/dark-theme.css").toExternalForm());

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(pricingScene);
        stage.setTitle("Pricing Plans");
    }

}