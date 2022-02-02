package com.karol.models;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DateManagerTest {

    @Test
    void shoudlReturnDateInyyyymmdFromat(){
        //given
        DateManager dateManager = new DateManager();

        //when
        String date = dateManager.getDateInyyyymmddFormat("2022-02-02 09:00:00");

        //then
        assertThat(date ,is("20220202"));
    }

    @Test
    void shoudlReturnWeekName(){
        //given
        DateManager dateManager = new DateManager();

        //when
        String weekDayName = dateManager.getWeekDayName("2022-02-02");

        //
        assertThat(weekDayName, is("WEDNESDAY"));
    }
}
