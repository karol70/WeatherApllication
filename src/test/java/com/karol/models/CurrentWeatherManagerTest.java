package com.karol.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;


class CurrentWeatherManagerTest {

    @Test
    void shouldReturnListSizeEqualToOneWhenGettingWeatherData() {
        //given
        CurrentWeatherManager currentWeatherManager = new CurrentWeatherManager("Lublin");
        List<WeatherParameters> currentWeather;

        //when
        currentWeatherManager.getDataWeather();
        currentWeather = currentWeatherManager.getCurrentWeather();

        //then
        assertThat(currentWeather, hasSize(1));
    }

    @Test
    void shouldReturnListSizeEqualZeroAfterCreateObject(){
        //given
        CurrentWeatherManager currentWeatherManager = new CurrentWeatherManager("Lublin");
        List<WeatherParameters> currentWeather;

        //when
        currentWeather = currentWeatherManager.getCurrentWeather();

        //then
        assertThat(currentWeather, hasSize(0));
    }

}