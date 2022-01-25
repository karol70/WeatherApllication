package com.karol.controllers;


import com.karol.models.ForecastManager;
import com.karol.models.CurrentWeatherManager;
import com.karol.models.WeatherParameters;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class WeatherWindowController {

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
    private TextField yourLocationTextField;

    @FXML
    void destinationButtonAction() {
        String destinationCity = destinationTextField.getText();
        String destinationCityUpper = "";
        if (!destinationCity.equals("")) {
            String firstLetter = destinationCity.substring(0, 1).toUpperCase();
            String rest = destinationCity.substring(1);
            destinationCityUpper = firstLetter + rest;
        }
        ForecastManager forecastManager1 = new ForecastManager(destinationCityUpper);
        CurrentWeatherManager weatherManager1 = new CurrentWeatherManager(destinationCityUpper);

        try {
            forecastManager1.getForecastData();
            weatherManager1.getDataWeather();
            destinationLabel.setText(destinationCityUpper);
            List<WeatherParameters> currentWeather = weatherManager1.getCurrentWeather();
            List<WeatherParameters> forecastWeather = forecastManager1.getForecastWeather();

            firstDayDestTemp.setText(currentWeather.get(0).getTemperature());
            secondDayDestTemp.setText(forecastWeather.get(1).getTemperature());
            thirdDayDestTemp.setText(forecastWeather.get(2).getTemperature());
            fourthDayDestTemp.setText(forecastWeather.get(3).getTemperature());
            fifthDayDestTemp.setText(forecastWeather.get(4).getTemperature());

            firstDayDestWind.setText("Wind: " + currentWeather.get(0).getWindSpeed());
            secondDayDestWind.setText("Wind: " + forecastWeather.get(1).getWindSpeed());
            thirdDayDestWind.setText("Wind: " + forecastWeather.get(2).getWindSpeed());
            fourthDayDestWind.setText("Wind: " + forecastWeather.get(3).getWindSpeed());
            fifthDayDestWind.setText("Wind: " + forecastWeather.get(4).getWindSpeed());

            firstDayDestPress.setText(currentWeather.get(0).getPressure());
            secondDayDestPress.setText(forecastWeather.get(1).getPressure());
            thirdDayDestPress.setText(forecastWeather.get(2).getPressure());
            fourthDayDestPress.setText(forecastWeather.get(3).getPressure());
            fifthDayDestPress.setText(forecastWeather.get(4).getPressure());

            secondDayDest.setText(forecastManager1.weekDayNameList.get(1));
            thirdDayDest.setText(forecastManager1.weekDayNameList.get(2));
            fourthDayDest.setText(forecastManager1.weekDayNameList.get(3));
            fifthDayDest.setText(forecastManager1.weekDayNameList.get(4));

            firstDayDestClouds.setText("Clouds: " + currentWeather.get(0).getCloudiness());
            secondDayDestClouds.setText("Clouds: " + forecastWeather.get(1).getCloudiness());
            thirdDayDestClouds.setText("Clouds: " + forecastWeather.get(2).getCloudiness());
            fourthDayDestClouds.setText("Clouds: " + forecastWeather.get(3).getCloudiness());
            fifthDayDestClouds.setText("Clouds: " + forecastWeather.get(4).getCloudiness());

            firstDayDestImg.setImage(new Image(String.valueOf(getClass().getResource("/img/" + currentWeather.get(0).getIcon() + ".png"))));
            secondDayDestImg.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(1).getIcon() + ".png"))));
            thirdDayDestImg.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(2).getIcon() + ".png"))));
            fourthDayDestImg.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(3).getIcon() + ".png"))));
            fifthDayDestImg.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(4).getIcon() + ".png"))));

            errorLabel.setText("");
        } catch (Exception e) {
            if (destinationCity.equals("")) {
                errorLabel.setText("Enter city name in Text Field");
            } else {
                errorLabel.setText("Wrong city name");
            }
        }
    }

    @FXML
    void yourLocationButtonAction() {
        String yourLocationCity = yourLocationTextField.getText();
        String yourLocationCityUpper = "";

        if (!yourLocationCity.equals("")) {
            String firstLetter = yourLocationCity.substring(0, 1).toUpperCase();
            String rest = yourLocationCity.substring(1);
            yourLocationCityUpper = firstLetter + rest;
        }


        ForecastManager forecastManager = new ForecastManager(yourLocationCityUpper);
        CurrentWeatherManager weatherManager = new CurrentWeatherManager(yourLocationCityUpper);

        try {
            forecastManager.getForecastData();
            weatherManager.getDataWeather();
            yourLocationLabel.setText(yourLocationCityUpper);
            List<WeatherParameters> currentWeather = weatherManager.getCurrentWeather();
            List<WeatherParameters> forecastWeather = forecastManager.getForecastWeather();

            firstDayTemp.setText(currentWeather.get(0).getTemperature());
            secondDayTemp.setText(forecastWeather.get(1).getTemperature());
            thirdDayTemp.setText(forecastWeather.get(2).getTemperature());
            fourthDayTemp.setText(forecastWeather.get(3).getTemperature());
            fifthDayTemp.setText(forecastWeather.get(4).getTemperature());

            firstDayWind.setText("Wind: " + currentWeather.get(0).getWindSpeed());
            secondDayWind.setText("Wind: " + forecastWeather.get(1).getWindSpeed());
            thirdDayWind.setText("Wind: " + forecastWeather.get(2).getWindSpeed());
            fourthDayWind.setText("Wind: " + forecastWeather.get(3).getWindSpeed());
            fifthDayWind.setText("Wind: " + forecastWeather.get(4).getWindSpeed());

            firstDayPress.setText(currentWeather.get(0).getPressure());
            secondDayPress.setText(forecastWeather.get(1).getPressure());
            thirdDayPress.setText(forecastWeather.get(2).getPressure());
            fourthDayPress.setText(forecastWeather.get(3).getPressure());
            fifthDayPress.setText(forecastWeather.get(4).getPressure());

            secondDay.setText(forecastManager.weekDayNameList.get(1));
            thirdDay.setText(forecastManager.weekDayNameList.get(2));
            fourthDay.setText(forecastManager.weekDayNameList.get(3));
            fifthDay.setText(forecastManager.weekDayNameList.get(4));

            firstDayClouds.setText("Clouds: " + currentWeather.get(0).getCloudiness());
            secondDayClouds.setText("Clouds: " + forecastWeather.get(1).getCloudiness());
            thirdDayClouds.setText("Clouds: " + forecastWeather.get(2).getCloudiness());
            fourthDayClouds.setText("Clouds: " + forecastWeather.get(3).getCloudiness());
            fifthDayClouds.setText("Clouds: " + forecastWeather.get(3).getCloudiness());

            firstDayImg.setImage(new Image(String.valueOf(getClass().getResource("/img/" + currentWeather.get(0).getIcon() + ".png"))));
            secondDayImg.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(1).getIcon() + ".png"))));
            thirdDayImg.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(2).getIcon() + ".png"))));
            fourthDayImg.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(3).getIcon() + ".png"))));
            fifthDayImg.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(4).getIcon() + ".png"))));

            errorLabel.setText("");
        } catch (Exception e) {
            if (yourLocationCity.equals("")) {
                errorLabel.setText("Enter city name in Text Field");
            } else {
                errorLabel.setText("Wrong city name");
            }
        }
    }

}
