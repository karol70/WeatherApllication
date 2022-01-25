package com.karol.models;

public class WeatherParameters {
    private final String temperature;
    private final String cloudiness;
    private final String windSpeed;
    private final String pressure;
    private final String icon;

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
