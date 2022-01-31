package com.karol.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;


class CurrentWeatherManagerTest {

    @Spy
    private CurrentWeatherManager currentWeatherManagerSpy;

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