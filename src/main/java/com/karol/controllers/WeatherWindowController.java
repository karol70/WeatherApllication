package com.karol.controllers;

import com.karol.models.CurrentLocation;
import com.karol.models.ForecastManager;
import com.karol.models.WeatherManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class WeatherWindowController {

   private CurrentLocation currentLocation;
   private ForecastManager forecastManager;
   private WeatherManager weatherManager;
    private ForecastManager forecastManager1;
    private WeatherManager weatherManager1;

  // public WeatherWindowController()

    @FXML
    private Label yourLocationLabel;

    @FXML
    private Button destinationButton;

    @FXML
    private Label destinationLabel;

    @FXML
    private TextField destinationTextField;

    @FXML
    private Label errorLabel;

    @FXML
    private Label fifthDay;

    @FXML
    private Label fifthDayDest;

    @FXML
    private Label firstDay;

    @FXML
    private Label firstDayDest;

    @FXML
    private Label fourthDay;

    @FXML
    private Label fourthDayDest;

    @FXML
    private Label secondDay;

    @FXML
    private Label secondDayDest;

    @FXML
    private Label thirdDay;

    @FXML
    private Label thirdDayDest;

    @FXML
    void destinationButtonAction() {
        String destinationCity = destinationTextField.getText();

        forecastManager1 = new ForecastManager(destinationCity);
        weatherManager1 = new WeatherManager(destinationCity);
        try {
            forecastManager1.readXML();
            weatherManager1.getDataWeather();
            destinationLabel.setText(destinationCity);
            firstDayDest.setText(weatherManager1.getCurrentWeather());
            secondDayDest.setText(forecastManager1.getSecondDay());
            thirdDayDest.setText(forecastManager1.getThirdDay());
            fourthDayDest.setText(forecastManager1.getFourthDay());
            fifthDayDest.setText(forecastManager1.getFifthDay());
            errorLabel.setText("");
        } catch (Exception e) {
            if(destinationCity.equals(""))
            {
                errorLabel.setText("Enter city name in Text Field");
            } else {
                errorLabel.setText("Wrong city name");
            }
        }
    }

    @FXML
    void yourLocationButtonAction() {
        currentLocation = new CurrentLocation("");
        String currentCity = currentLocation.getCity();
        forecastManager = new ForecastManager(currentCity);
        forecastManager.readXML();
        weatherManager = new WeatherManager(currentCity);
        weatherManager.getDataWeather();
        yourLocationLabel.setText(currentCity);
        firstDay.setText(weatherManager.getCurrentWeather());
        secondDay.setText(forecastManager.getSecondDay());
        thirdDay.setText(forecastManager.getThirdDay());
        fourthDay.setText(forecastManager.getFourthDay());
        fifthDay.setText(forecastManager.getFifthDay());

    }


}
