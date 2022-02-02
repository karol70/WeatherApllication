package com.karol.models;

import com.karol.Config;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.util.*;

public class ForecastManager {

    private final String city;
    private final List<ForecastWeatherParameters> forecastWeather = new ArrayList<>();
    JsonDataManager jsonDataManager = new JsonDataManager();
    DateManager dateManager = new DateManager();
    private JSONObject jsonObject;

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject object) {
        this.jsonObject = object;
    }



    public ForecastManager(String city) throws IOException {
        this.city = city;
        jsonObject = jsonDataManager.getDataFromUrl("http://api.openweathermap.org/data/2.5/forecast?q="+city+"&units=metric&appid="+Config.API_KEY);
    }

    public List<ForecastWeatherParameters> getForecastData() throws IOException {

        JSONArray getArray;
        JSONObject jsonMain;
        String lastloadedDay = "";


        getArray = jsonObject.getJSONArray("list");

        for (int i = 0; i < getArray.length(); i++) {

            JSONObject objects = getArray.getJSONObject(i);

            String date = objects.get("dt_txt").toString();

            String weekDayName = dateManager.getWeekDayName(date);
            String dateDayFormatyyyymmdd = dateManager.getDateInyyyymmddFormat(date);

            if (!dateDayFormatyyyymmdd.equals(lastloadedDay) && date.contains("12:00:00")) {
                lastloadedDay = dateDayFormatyyyymmdd;
                jsonMain = objects.getJSONObject("main");
                String temperature = jsonMain.get("temp").toString() + "°C";
                String pressure = jsonMain.get("pressure").toString() + "hPa";
                jsonMain = objects.getJSONObject("wind");
                String windSpeed = jsonMain.get("speed").toString() + "m/s";
                jsonMain = objects.getJSONObject("clouds");
                String cloudiness = jsonMain.get("all").toString() + "%";
                jsonMain = objects.getJSONArray("weather").getJSONObject(0);
                String icon = jsonMain.get("icon").toString();

                WeatherParameters weatherParameters = new WeatherParameters(temperature, cloudiness, windSpeed, pressure, icon);
                ForecastWeatherParameters forecastWeatherParameters = new ForecastWeatherParameters(weatherParameters, weekDayName);
                forecastWeather.add(forecastWeatherParameters);
            }
        }
        return forecastWeather;
    }
}
