package org.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class PricingApp extends Application {
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(PricingApp.class.getResource("pricing-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Link CSS
        scene.getStylesheets().add(PricingApp.class.getResource("/org/example/javafx/dark-theme.css").toExternalForm());

        stage.setTitle("Pricing Plans");
        stage.setScene(scene);

        // Add icon to the stage
        Image icon = new Image(PricingApp.class.getResourceAsStream("/org/example/javafx/icon.png"));
        stage.getIcons().add(icon);

        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}