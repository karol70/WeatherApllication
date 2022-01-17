package com.karol.models;

import com.karol.Config;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class WeatherManager {

    private String city;
    private String day;
    private String temperature;
    private String cloudiness;
    private String windSpeed;
    private String pressure;
    private String description;
    private String icon;


    public WeatherManager(String city) {
        this.city = city;
    }

    public void getDataWeather() {
        int date = 0;

        JSONObject jsonObject = null;
        JSONObject jsonMain;

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();

        try {
            jsonObject = readJsonUrl("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + Config.API_KEY + "&lang=eng&units=metric");
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

        jsonMain = jsonObject.getJSONObject("main");
        this.temperature = jsonMain.get("temp").toString() + "°C";
        jsonMain = jsonObject.getJSONObject("main");
        this.pressure = jsonMain.get("pressure").toString() + "hPa";
        jsonMain = jsonObject.getJSONObject("wind");
        this.windSpeed = jsonMain.get("speed").toString() + "m/s";
        jsonMain = jsonObject.getJSONObject("clouds");
        this.cloudiness = jsonMain.get("all").toString() + "%";
        jsonMain = jsonObject.getJSONArray("weather").getJSONObject(0);
        this.description = jsonMain.get("description").toString();
        this.icon = jsonMain.get("icon").toString();

        calendar.add(Calendar.DATE, date);
        this.day = dateFormat.format(calendar.getTime());


    }

    private JSONObject readJsonUrl(String url) throws IOException {
        try (InputStream inputStream = new URL(url).openStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
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

    public String getTemperature() {
        return temperature;
    }

    public String getCloudiness() {
        return cloudiness;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getPressure() {
        return pressure;
    }

    public String getIcon() {
        return icon;
    }

}


