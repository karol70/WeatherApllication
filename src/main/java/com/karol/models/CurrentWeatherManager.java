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
    private String temperature;
    private String cloudiness;
    private String windSpeed;
    private String pressure;
    private String icon;
    private WeatherParameters currentWeatherParameters;
    private final List<WeatherParameters> currentWeather = new ArrayList<>();


    public CurrentWeatherManager(String city) {
        this.city = city;
        currentWeather.clear();
    }

    private JSONObject getDataFromUrl(){
        JSONObject jsonObject = null;
        try {
            jsonObject = readJsonUrl("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + Config.API_KEY + "&lang=eng&units=metric");
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public void getDataWeather() {

        JSONObject jsonObject;
        JSONObject jsonMain;

        jsonObject = getDataFromUrl();

        jsonMain = jsonObject.getJSONObject("main");
        this.temperature = jsonMain.get("temp").toString() + "°C";
        jsonMain = jsonObject.getJSONObject("main");
        this.pressure = jsonMain.get("pressure").toString() + "hPa";
        jsonMain = jsonObject.getJSONObject("wind");
        this.windSpeed = jsonMain.get("speed").toString() + "m/s";
        jsonMain = jsonObject.getJSONObject("clouds");
        this.cloudiness = jsonMain.get("all").toString() + "%";
        jsonMain = jsonObject.getJSONArray("weather").getJSONObject(0);
        this.icon = jsonMain.get("icon").toString();
        
        currentWeatherParameters= new WeatherParameters(temperature,cloudiness,windSpeed,pressure,icon);
        currentWeather.add(currentWeatherParameters);
    }

    private JSONObject readJsonUrl(String url) throws IOException {
        try (InputStream inputStream = new URL(url).openStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String textJson = readAll(bufferedReader);
            return new JSONObject(textJson);
        }
    }

    private String readAll(Reader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int cp;
        while ((cp = reader.read()) != -1) {
            stringBuilder.append((char) cp);
        }
        return stringBuilder.toString();
    }

    public List<WeatherParameters> getCurrentWeather() {
        return currentWeather;
    }
}


