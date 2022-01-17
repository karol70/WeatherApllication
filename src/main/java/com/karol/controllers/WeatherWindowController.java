package com.karol.controllers;

import com.karol.models.CurrentLocation;
import com.karol.models.ForecastManager;
import com.karol.models.WeatherManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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



    @FXML
    private Label destinationLabel;

    @FXML
    private TextField destinationTextField;

    @FXML
    private Label errorLabel;

    @FXML
    private Label fifthDay;

    @FXML
    private Label fifthDayClouds;

    @FXML
    private Label fifthDayDestClouds;

    @FXML
    private ImageView fifthDayDestImg;

    @FXML
    private Label fifthDayDestPress;

    @FXML
    private Label fifthDayDestTemp;

    @FXML
    private Label fifthDayDestWind;

    @FXML
    private ImageView fifthDayImg;

    @FXML
    private Label fifthDayPress;

    @FXML
    private Label fifthDayTemp;

    @FXML
    private Label fifthDayWind;

    @FXML
    private Label firstDayClouds;

    @FXML
    private Label firstDayDestClouds;

    @FXML
    private ImageView firstDayDestImg;

    @FXML
    private Label firstDayDestPress;

    @FXML
    private Label firstDayDestTemp;

    @FXML
    private Label firstDayDestWind;

    @FXML
    private ImageView firstDayImg;

    @FXML
    private Label firstDayPress;

    @FXML
    private Label firstDayTemp;

    @FXML
    private Label firstDayWind;

    @FXML
    private Label fourthDay;

    @FXML
    private Label fourthDayClouds;

    @FXML
    private Label fourthDayDestClouds;

    @FXML
    private ImageView fourthDayDestImg;

    @FXML
    private Label fourthDayDestPress;

    @FXML
    private Label fourthDayDestTemp;

    @FXML
    private Label fourthDayDestWind;

    @FXML
    private ImageView fourthDayImg;

    @FXML
    private Label fourthDayPress;

    @FXML
    private Label fourthDayTemp;

    @FXML
    private Label fourthDayWind;

    @FXML
    private Label secondDay;

    @FXML
    private Label secondDayClouds;

    @FXML
    private Label secondDayDestClouds;

    @FXML
    private ImageView secondDayDestImg;

    @FXML
    private Label secondDayDestPress;

    @FXML
    private Label secondDayDestTemp;

    @FXML
    private Label secondDayDestWind;

    @FXML
    private ImageView secondDayImg;

    @FXML
    private Label secondDayPress;

    @FXML
    private Label secondDayTemp;

    @FXML
    private Label secondDayWind;

    @FXML
    private Label thirdDay;

    @FXML
    private Label secondDayDest;
    @FXML
    private Label thirdDayDest;
    @FXML
    private Label fourthDayDest;
    @FXML
    private Label fifthDayDest;

    @FXML
    private Label thirdDayClouds;

    @FXML
    private Label thirdDayDestClouds;

    @FXML
    private ImageView thirdDayDestImg;

    @FXML
    private Label thirdDayDestPress;

    @FXML
    private Label thirdDayDestTemp;

    @FXML
    private Label thirdDayDestWind;

    @FXML
    private ImageView thirdDayImg;

    @FXML
    private Label thirdDayPress;

    @FXML
    private Label thirdDayTemp;

    @FXML
    private Label thirdDayWind;

    @FXML
    private Label yourLocationLabel;

    @FXML
    void destinationButtonAction() {
        String destinationCity = destinationTextField.getText();

        forecastManager1 = new ForecastManager(destinationCity);
        weatherManager1 = new WeatherManager(destinationCity);
        try {
            forecastManager1.getForecastData();
            weatherManager1.getDataWeather();
            destinationLabel.setText(destinationCity);

            firstDayDestTemp.setText(weatherManager1.getTemperature());
            secondDayDestTemp.setText(forecastManager1.temper.get(1));
            thirdDayDestTemp.setText(forecastManager1.temper.get(2));
            fourthDayDestTemp.setText(forecastManager1.temper.get(3));
            fifthDayDestTemp.setText(forecastManager1.temper.get(4));

            firstDayDestWind.setText("Wind: " +weatherManager1.getWindSpeed());
            secondDayDestWind.setText("Wind: " +forecastManager1.wind.get(1));
            thirdDayDestWind.setText("Wind: " +forecastManager1.wind.get(2));
            fourthDayDestWind.setText("Wind: " +forecastManager1.wind.get(3));
            fifthDayDestWind.setText("Wind: " +forecastManager1.wind.get(4));

            firstDayDestPress.setText(weatherManager1.getPressure());
            secondDayDestPress.setText(forecastManager1.press.get(1));
            thirdDayDestPress.setText(forecastManager1.press.get(2));
            fourthDayDestPress.setText(forecastManager1.press.get(3));
            fifthDayDestPress.setText(forecastManager1.press.get(4));

            secondDayDest.setText(forecastManager1.dayOfWeek.get(1));
            thirdDayDest.setText(forecastManager1.dayOfWeek.get(2));
            fourthDayDest.setText(forecastManager1.dayOfWeek.get(3));
            fifthDayDest.setText(forecastManager1.dayOfWeek.get(4));

            firstDayDestClouds.setText("Clouds: " +weatherManager1.getCloudiness());
            secondDayDestClouds.setText("Clouds: " +forecastManager1.clouds.get(1));
            thirdDayDestClouds.setText("Clouds: " +forecastManager1.clouds.get(2));
            fourthDayDestClouds.setText("Clouds: " +forecastManager1.clouds.get(3));
            fifthDayDestClouds.setText("Clouds: " +forecastManager1.clouds.get(4));

            firstDayDestImg.setImage(new Image(String.valueOf(getClass().getResource("/img/"+weatherManager1.getIcon()+".png"))));
            secondDayDestImg.setImage(new Image(String.valueOf(getClass().getResource("/img/"+forecastManager1.symbol.get(1)+".png"))));
            thirdDayDestImg.setImage(new Image(String.valueOf(getClass().getResource("/img/"+forecastManager1.symbol.get(2)+".png"))));
            fourthDayDestImg.setImage(new Image(String.valueOf(getClass().getResource("/img/"+forecastManager1.symbol.get(3)+".png"))));
            fifthDayDestImg.setImage(new Image(String.valueOf(getClass().getResource("/img/"+forecastManager1.symbol.get(4)+".png"))));


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
        forecastManager.getForecastData();
        weatherManager = new WeatherManager(currentCity);
        weatherManager.getDataWeather();
        yourLocationLabel.setText(currentCity);

        firstDayTemp.setText(weatherManager.getTemperature());
        secondDayTemp.setText(forecastManager.temper.get(1));
        thirdDayTemp.setText(forecastManager.temper.get(2));
        fourthDayTemp.setText(forecastManager.temper.get(3));
        fifthDayTemp.setText(forecastManager.temper.get(4));

        firstDayWind.setText("Wind: " +weatherManager.getWindSpeed());
        secondDayWind.setText("Wind: " +forecastManager.wind.get(1));
        thirdDayWind.setText("Wind: " +forecastManager.wind.get(2));
        fourthDayWind.setText("Wind: " +forecastManager.wind.get(3));
        fifthDayWind.setText("Wind: " +forecastManager.wind.get(4));

        firstDayPress.setText(weatherManager.getPressure());
        secondDayPress.setText(forecastManager.press.get(1));
        thirdDayPress.setText(forecastManager.press.get(2));
        fourthDayPress.setText(forecastManager.press.get(3));
        fifthDayPress.setText(forecastManager.press.get(4));

        secondDay.setText(forecastManager.dayOfWeek.get(1));
        thirdDay.setText(forecastManager.dayOfWeek.get(2));
        fourthDay.setText(forecastManager.dayOfWeek.get(3));
        fifthDay.setText(forecastManager.dayOfWeek.get(4));

        firstDayClouds.setText("Clouds: " +weatherManager.getCloudiness());
        secondDayClouds.setText("Clouds: " +forecastManager.clouds.get(1));
        thirdDayClouds.setText("Clouds: " +forecastManager.clouds.get(2));
        fourthDayClouds.setText("Clouds: " +forecastManager.clouds.get(3));
        fifthDayClouds.setText("Clouds: " +forecastManager.clouds.get(4));

        firstDayImg.setImage(new Image(String.valueOf(getClass().getResource("/img/"+weatherManager.getIcon()+".png"))));
        secondDayImg.setImage(new Image(String.valueOf(getClass().getResource("/img/"+forecastManager.symbol.get(1)+".png"))));
        thirdDayImg.setImage(new Image(String.valueOf(getClass().getResource("/img/"+forecastManager.symbol.get(2)+".png"))));
        fourthDayImg.setImage(new Image(String.valueOf(getClass().getResource("/img/"+forecastManager.symbol.get(3)+".png"))));
        fifthDayImg.setImage(new Image(String.valueOf(getClass().getResource("/img/"+forecastManager.symbol.get(4)+".png"))));

    }

}
