package com.karol.models;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;


class ForecastManagerTest {

    @Test
    void forecastShouldBeAbleToChangeDateFormatFromYYYY_MM_DDThh_mm_ssToYYYYMMDD() {
        //given
        ForecastManager forecastManager = new ForecastManager("");
        String date = "2022-01-25T12:50:00";

        //when
        String formattedDate = forecastManager.getDateInyyyymmddFormat(date);

        //then
        assertThat(formattedDate, equalTo("20220125"));
    }

    @Test
    void forecastShouldBeAbleToReturnWeekDayNameWhenGivenDateInYYY_MM_DDFormat() {
        //given
        ForecastManager forecastManager = new ForecastManager("");
        String date = "2022-01-25T12:50:00";

        //when
        String weekDayName = forecastManager.getWeekDayName(date);

        //then
        assertThat(weekDayName, equalTo("Tuesday"));
    }


    @Test
    void shouldReturnListSizeEqualToZeroAfterCreatingObject() {
        //given
        ForecastManager forecastManager = new ForecastManager("Lublin");
        List<WeatherParameters> forecastList;

        //when
        forecastList = forecastManager.getForecastWeather();

        //then
        assertThat(forecastList, hasSize(0));
    }


}


