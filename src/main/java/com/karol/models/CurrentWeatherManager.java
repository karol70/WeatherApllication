package com.karol.models;

import com.karol.Config;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class CurrentWeatherManager {

    private final String city;
    JsonDataManager jsonDataManager = new JsonDataManager();

    public CurrentWeatherManager(String city) {
        this.city = city;
    }

    public List<WeatherParameters> getDataWeather() throws IOException {

        JSONObject jsonObject;
        JSONObject jsonMain;

        jsonObject = jsonDataManager.getDataFromUrl("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + Config.API_KEY + "&lang=eng&units=metric");

        jsonMain = jsonObject.getJSONObject("main");
        String temperature = jsonMain.get("temp").toString() + "°C";
        jsonMain = jsonObject.getJSONObject("main");
        String pressure = jsonMain.get("pressure").toString() + "hPa";
        jsonMain = jsonObject.getJSONObject("wind");
        String windSpeed = jsonMain.get("speed").toString() + "m/s";
        jsonMain = jsonObject.getJSONObject("clouds");
        String cloudiness = jsonMain.get("all").toString() + "%";
        jsonMain = jsonObject.getJSONArray("weather").getJSONObject(0);
        String icon = jsonMain.get("icon").toString();

        List<WeatherParameters> currentWeather = new ArrayList<>();
        WeatherParameters currentWeatherParameters = new WeatherParameters(temperature, cloudiness, windSpeed, pressure, icon);
        currentWeather.add(currentWeatherParameters);
        return currentWeather;
    }
}


