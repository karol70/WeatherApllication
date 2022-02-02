package com.karol.models;


import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class JsonDataManagerTest {


    @Test
    void shouldReturnJsonObject() throws IOException{
        //given
        JSONObject jsonObject = prepareJsonObject();
        JsonDataManager jsonDataManager = mock(JsonDataManager.class);
        given(jsonDataManager.getDataFromUrl("")).willReturn(jsonObject);

        //when
        JSONObject jsonObjectExpected = jsonDataManager.getDataFromUrl("");

        //then
        assertThat(jsonObjectExpected, is(jsonObject));
    }

    private JSONObject prepareJsonObject(){

        JSONObject jsonObject = new JSONObject("{\"coord\":{\"lon\":23,\"lat\":51},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":-1.23,\"feels_like\":-6.11,\"temp_min\":-1.45,\"temp_max\":-1.23,\"pressure\":1010,\"humidity\":83,\"sea_level\":1010,\"grnd_level\":981},\"visibility\":10000,\"wind\":{\"speed\":4.45,\"deg\":265,\"gust\":6.91},\"clouds\":{\"all\":83},\"dt\":1643710322,\"sys\":{\"type\":1,\"id\":1702,\"country\":\"PL\",\"sunrise\":1643695503,\"sunset\":1643728677},\"timezone\":3600,\"id\":858785,\"name\":\"Lublin Voivodeship\",\"cod\":200}");
        return jsonObject;
    }

}
