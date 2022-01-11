package com.karol;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args ) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/weatherWindow.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


    }
}
