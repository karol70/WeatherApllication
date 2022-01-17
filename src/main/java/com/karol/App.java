package com.karol;


import com.karol.models.CurrentLocation;
import com.karol.models.ForecastManager;
import com.karol.models.WeatherManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException, ParserConfigurationException {

       Parent root = FXMLLoader.load(getClass().getResource("/fxml/weatherWindow.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        CurrentLocation currentLocation = new CurrentLocation("");
        String city = currentLocation.getCity();


/*
        WeatherManager weatherManager = new WeatherManager("Warsaw");
        weatherManager.getDataWeather();


        ForecastManager forecastManager = new ForecastManager("Lublin");
        forecastManager.getForecastData();
        System.out.println(forecastManager.clouds.get(1));
*/








    }
}
