package com.karol.controllers;


import com.karol.models.ForecastManager;
import com.karol.models.CurrentWeatherManager;
import com.karol.models.ForecastWeatherParameters;
import com.karol.models.WeatherParameters;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONException;

import java.io.IOException;
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
            destinationLabel.setText(destinationCityUpper);
            List<WeatherParameters> currentWeather = weatherManager.getDataWeather();
            List<ForecastWeatherParameters> forecastWeather = forecastManager.getForecastData();

            getTemp(currentWeather, forecastWeather, firstDayDestTemp, secondDayDestTemp, thirdDayDestTemp, fourthDayDestTemp, fifthDayDestTemp);
            getWindSpeed(currentWeather, forecastWeather, firstDayDestWind, secondDayDestWind, thirdDayDestWind, fourthDayDestWind, fifthDayDestWind);
            getPressure(currentWeather, forecastWeather, firstDayDestPress, secondDayDestPress, thirdDayDestPress, fourthDayDestPress, fifthDayDestPress);
            getDay(forecastWeather, secondDayDest, thirdDayDest, fourthDayDest, fifthDayDest);
            getCloudiness(currentWeather, forecastWeather, firstDayDestClouds, secondDayDestClouds, thirdDayDestClouds, fourthDayDestClouds, fifthDayDestClouds);
            getImage(firstDayDestImg, currentWeather, secondDayDestImg, forecastWeather, thirdDayDestImg, fourthDayDestImg, fifthDayDestImg);

            errorLabel.setText("");
        } catch (JSONException e){
            if (destinationCity.equals("")) {
                errorLabel.setText("Enter city name in Text Field");
            } else {
                errorLabel.setText("Wrong city name");
            }
        } catch (IOException e){
            errorLabel.setText("Please enter city name in text field");
        } catch (NullPointerException e) {
            errorLabel.setText("Something goes wrong, please try later");
        }


    }

    private void getCloudiness(List<WeatherParameters> currentWeather, List<ForecastWeatherParameters> forecastWeather, Label label1, Label label2, Label label3, Label label4, Label label5){
        label1.setText("Clouds: " + currentWeather.get(0).getCloudiness());
        label2.setText("Clouds: " + forecastWeather.get(1).getCloudiness());
        label3.setText("Clouds: " + forecastWeather.get(2).getCloudiness());
        label4.setText("Clouds: " + forecastWeather.get(3).getCloudiness());
        label5.setText("Clouds: " + forecastWeather.get(4).getCloudiness());
    }

    private void getDay(List<ForecastWeatherParameters> forecastWeather, Label label2, Label label3, Label label4, Label label5){
        label2.setText(forecastWeather.get(1).getDay());
        label3.setText(forecastWeather.get(2).getDay());
        label4.setText(forecastWeather.get(3).getDay());
        label5.setText(forecastWeather.get(4).getDay());
    }

    private void getPressure(List<WeatherParameters> currentWeather, List<ForecastWeatherParameters> forecastWeather, Label label1, Label label2, Label label3, Label label4, Label label5){
        label1.setText(currentWeather.get(0).getPressure());
        label2.setText(forecastWeather.get(1).getPressure());
        label3.setText(forecastWeather.get(2).getPressure());
        label4.setText(forecastWeather.get(3).getPressure());
        label5.setText(forecastWeather.get(4).getPressure());
    }

    private void getWindSpeed(List<WeatherParameters> currentWeather, List<ForecastWeatherParameters> forecastWeather, Label label1, Label label2, Label label3, Label label4, Label label5){
        label1.setText("Wind: " + currentWeather.get(0).getWindSpeed());
        label2.setText("Wind: " + forecastWeather.get(1).getWindSpeed());
        label3.setText("Wind: " + forecastWeather.get(2).getWindSpeed());
        label4.setText("Wind: " + forecastWeather.get(3).getWindSpeed());
        label5.setText("Wind: " + forecastWeather.get(4).getWindSpeed());
    }


    private void getTemp(List<WeatherParameters> currentWeather, List<ForecastWeatherParameters> forecastWeather, Label label1, Label label2, Label label3, Label label4, Label label5){
        label1.setText(currentWeather.get(0).getTemperature());
        label2.setText(forecastWeather.get(1).getTemperature());
        label3.setText(forecastWeather.get(2).getTemperature());
        label4.setText(forecastWeather.get(3).getTemperature());
        label5.setText(forecastWeather.get(4).getTemperature());
    }

    private void getImage(ImageView img1, List<WeatherParameters> currentWeather, ImageView img2, List<ForecastWeatherParameters> forecastWeather, ImageView img3, ImageView img4, ImageView img5) {
        img1.setImage(new Image(String.valueOf(getClass().getResource("/img/" + currentWeather.get(0).getIcon() + ".png"))));
        img2.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(1).getIcon() + ".png"))));
        img3.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(2).getIcon() + ".png"))));
        img4.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(3).getIcon() + ".png"))));
        img5.setImage(new Image(String.valueOf(getClass().getResource("/img/" + forecastWeather.get(4).getIcon() + ".png"))));
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
            yourLocationLabel.setText(yourLocationCityUpper);
            List<WeatherParameters> currentWeather = weatherManager.getDataWeather();
            List<ForecastWeatherParameters> forecastWeather = forecastManager.getForecastData();

            getTemp(currentWeather,forecastWeather,firstDayTemp,secondDayTemp, thirdDayTemp, fourthDayTemp,  fifthDayTemp);
            getWindSpeed(currentWeather,forecastWeather,firstDayWind,secondDayWind, thirdDayWind, fourthDayWind,  fifthDayWind);
            getPressure(currentWeather,forecastWeather,firstDayPress,secondDayPress, thirdDayPress, fourthDayPress,  fifthDayPress);
            getDay(forecastWeather, secondDay,  thirdDay,  fourthDay,  fifthDay);
            getCloudiness(currentWeather,forecastWeather,firstDayClouds,secondDayClouds, thirdDayClouds, fourthDayClouds,  fifthDayClouds);
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
