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
        String destinationCityUpper = getCityUpper(destinationCity);

        ForecastManager forecastManager = new ForecastManager(destinationCityUpper);
        CurrentWeatherManager weatherManager = new CurrentWeatherManager(destinationCityUpper);

        try {
            forecastManager.getForecastData();
            weatherManager.getDataWeather();
            destinationLabel.setText(destinationCityUpper);
            List<WeatherParameters> currentWeather = weatherManager.getCurrentWeather();
            List<WeatherParameters> forecastWeather = forecastManager.getForecastWeather();

            getTemp(firstDayDestTemp, currentWeather.get(0).getTemperature(), secondDayDestTemp, forecastWeather.get(1).getTemperature(), thirdDayDestTemp, forecastWeather.get(2).getTemperature(), fourthDayDestTemp, forecastWeather.get(3).getTemperature(), fifthDayDestTemp, forecastWeather.get(4).getTemperature());

            getWindSpeed(firstDayDestWind, "Wind: " + currentWeather.get(0).getWindSpeed(), secondDayDestWind, "Wind: " + forecastWeather.get(1).getWindSpeed(), thirdDayDestWind, "Wind: " + forecastWeather.get(2).getWindSpeed(), fourthDayDestWind, "Wind: " + forecastWeather.get(3).getWindSpeed(), fifthDayDestWind, "Wind: " + forecastWeather.get(4).getWindSpeed());

            getPressure(firstDayDestPress, currentWeather.get(0).getPressure(), secondDayDestPress, forecastWeather.get(1).getPressure(), thirdDayDestPress, forecastWeather.get(2).getPressure(), fourthDayDestPress, forecastWeather.get(3).getPressure(), fifthDayDestPress, forecastWeather.get(4).getPressure());

            getDay(secondDayDest, forecastManager.weekDayNameList.get(1), thirdDayDest, forecastManager.weekDayNameList.get(2), fourthDayDest, forecastManager.weekDayNameList.get(3), fifthDayDest, forecastManager.weekDayNameList.get(4));

            getCloudiness(firstDayDestClouds, "Clouds: " + currentWeather.get(0).getCloudiness(), secondDayDestClouds, "Clouds: " + forecastWeather.get(1).getCloudiness(), thirdDayDestClouds, "Clouds: " + forecastWeather.get(2).getCloudiness(), fourthDayDestClouds, "Clouds: " + forecastWeather.get(3).getCloudiness(), fifthDayDestClouds, "Clouds: " + forecastWeather.get(4).getCloudiness());

            getImage(firstDayDestImg, currentWeather, secondDayDestImg, forecastWeather, thirdDayDestImg, fourthDayDestImg, fifthDayDestImg);

            errorLabel.setText("");
        } catch (Exception e) {
            if (destinationCity.equals("")) {
                errorLabel.setText("Enter city name in Text Field");
            } else {
                errorLabel.setText("Wrong city name");
            }
        }
    }

    private void getCloudiness(Label firstDayDestClouds, String currentWeather, Label secondDayDestClouds, String forecastWeather, Label thirdDayDestClouds, String forecastWeather1, Label fourthDayDestClouds, String forecastWeather2, Label fifthDayDestClouds, String forecastWeather3) {
        firstDayDestClouds.setText(currentWeather);
        secondDayDestClouds.setText(forecastWeather);
        thirdDayDestClouds.setText(forecastWeather1);
        fourthDayDestClouds.setText(forecastWeather2);
        fifthDayDestClouds.setText(forecastWeather3);
    }

    private void getDay(Label secondDayDest, String weekDayNameList, Label thirdDayDest, String weekDayNameList1, Label fourthDayDest, String weekDayNameList2, Label fifthDayDest, String weekDayNameList3) {
        secondDayDest.setText(weekDayNameList);
        thirdDayDest.setText(weekDayNameList1);
        fourthDayDest.setText(weekDayNameList2);
        fifthDayDest.setText(weekDayNameList3);
    }

    private void getPressure(Label firstDayDestPress, String currentWeather, Label secondDayDestPress, String forecastWeather, Label thirdDayDestPress, String forecastWeather1, Label fourthDayDestPress, String forecastWeather2, Label fifthDayDestPress, String forecastWeather3) {
        firstDayDestPress.setText(currentWeather);
        secondDayDestPress.setText(forecastWeather);
        thirdDayDestPress.setText(forecastWeather1);
        fourthDayDestPress.setText(forecastWeather2);
        fifthDayDestPress.setText(forecastWeather3);
    }

    private void getWindSpeed(Label firstDayDestWind, String currentWeather, Label secondDayDestWind, String forecastWeather, Label thirdDayDestWind, String forecastWeather1, Label fourthDayDestWind, String forecastWeather2, Label fifthDayDestWind, String forecastWeather3) {
        firstDayDestWind.setText(currentWeather);
        secondDayDestWind.setText(forecastWeather);
        thirdDayDestWind.setText(forecastWeather1);
        fourthDayDestWind.setText(forecastWeather2);
        fifthDayDestWind.setText(forecastWeather3);
    }

    private void getTemp(Label firstDayDestTemp, String currentWeather, Label secondDayDestTemp, String forecastWeather, Label thirdDayDestTemp, String forecastWeather1, Label fourthDayDestTemp, String forecastWeather2, Label fifthDayDestTemp, String forecastWeather3) {
        firstDayDestTemp.setText(currentWeather);
        secondDayDestTemp.setText(forecastWeather);
        thirdDayDestTemp.setText(forecastWeather1);
        fourthDayDestTemp.setText(forecastWeather2);
        fifthDayDestTemp.setText(forecastWeather3);
    }

    private void getImage(ImageView firstDayDestImg, List<WeatherParameters> currentWeather, ImageView secondDayDestImg, List<WeatherParameters> forecastWeather, ImageView thirdDayDestImg, ImageView fourthDayDestImg, ImageView fifthDayDestImg) {
        firstDayDestImg.setImage(new Image(String.valueOf(getClass().getResource("/img/" + currentWeather.get(0).getIcon() + ".png"))));
        secondDayDestImg.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(1).getIcon() + ".png"))));
        thirdDayDestImg.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(2).getIcon() + ".png"))));
        fourthDayDestImg.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(3).getIcon() + ".png"))));
        fifthDayDestImg.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(4).getIcon() + ".png"))));
    }

    private String getCityUpper(String city) {
        String cityUpper ="";
        if (!city.equals("")) {
            String firstLetter = city.substring(0, 1).toUpperCase();
            String rest = city.substring(1);
            cityUpper = firstLetter + rest;
        }
        return cityUpper;
    }

    @FXML
    void yourLocationButtonAction() {
        String yourLocationCity = yourLocationTextField.getText();
        String yourLocationCityUpper = getCityUpper(yourLocationCity);
        
        ForecastManager forecastManager = new ForecastManager(yourLocationCityUpper);
        CurrentWeatherManager weatherManager = new CurrentWeatherManager(yourLocationCityUpper);

        try {
            forecastManager.getForecastData();
            weatherManager.getDataWeather();
            yourLocationLabel.setText(yourLocationCityUpper);
            List<WeatherParameters> currentWeather = weatherManager.getCurrentWeather();
            List<WeatherParameters> forecastWeather = forecastManager.getForecastWeather();

            getTemp(firstDayTemp, currentWeather.get(0).getTemperature(), secondDayTemp, forecastWeather.get(1).getTemperature(), thirdDayTemp, forecastWeather.get(2).getTemperature(), fourthDayTemp, forecastWeather.get(3).getTemperature(), fifthDayTemp, forecastWeather.get(4).getTemperature());

            getWindSpeed(firstDayWind, "Wind: " + currentWeather.get(0).getWindSpeed(), secondDayWind, "Wind: " + forecastWeather.get(1).getWindSpeed(), thirdDayWind, "Wind: " + forecastWeather.get(2).getWindSpeed(), fourthDayWind, "Wind: " + forecastWeather.get(3).getWindSpeed(), fifthDayWind, "Wind: " + forecastWeather.get(4).getWindSpeed());

            getPressure(firstDayPress, currentWeather.get(0).getPressure(), secondDayPress, forecastWeather.get(1).getPressure(), thirdDayPress, forecastWeather.get(2).getPressure(), fourthDayPress, forecastWeather.get(3).getPressure(), fifthDayPress, forecastWeather.get(4).getPressure());

            getDay(secondDay, forecastManager.weekDayNameList.get(1), thirdDay, forecastManager.weekDayNameList.get(2), fourthDay, forecastManager.weekDayNameList.get(3), fifthDay, forecastManager.weekDayNameList.get(4));

            getCloudiness(firstDayClouds, "Clouds: " + currentWeather.get(0).getCloudiness(), secondDayClouds, "Clouds: " + forecastWeather.get(1).getCloudiness(), thirdDayClouds, "Clouds: " + forecastWeather.get(2).getCloudiness(), fourthDayClouds, "Clouds: " + forecastWeather.get(3).getCloudiness(), fifthDayClouds, "Clouds: " + forecastWeather.get(3).getCloudiness());

            getImage(firstDayImg, currentWeather, secondDayImg, forecastWeather, thirdDayImg, fourthDayImg, fifthDayImg);

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
