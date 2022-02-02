package com.karol.models;

public class ForecastWeatherParameters {
    private final String day;
    private final WeatherParameters weatherParameters;

    public ForecastWeatherParameters(WeatherParameters weatherParameters, String day) {
        this.weatherParameters = weatherParameters;
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public String getTemperature() {
        return weatherParameters.getTemperature();
    }
    public String getCloudiness() {
        return weatherParameters.getCloudiness();
    }

    public String getWindSpeed() {
        return weatherParameters.getWindSpeed();
    }

    public String getPressure() {
        return weatherParameters.getPressure();
    }

    public String getIcon() {
        return weatherParameters.getIcon();
    }
}
