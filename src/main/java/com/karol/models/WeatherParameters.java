package com.karol.models;

public class WeatherParameters {
    private String temperature;
    private String cloudiness;
    private String windSpeed;
    private String pressure;
    private String icon;

    public WeatherParameters(String temperature, String cloudiness, String windSpeed, String pressure, String icon) {
        this.temperature = temperature;
        this.cloudiness = cloudiness;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.icon = icon;
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
