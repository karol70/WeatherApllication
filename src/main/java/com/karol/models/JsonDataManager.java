package com.karol.models;

import com.karol.Config;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JsonDataManager {

    public JSONObject getDataFromUrl(String url) throws IOException {
        JSONObject jsonObject = null;

        jsonObject = readJsonUrl(url);
        if(jsonObject.length() == 0)
        {
            throw new JSONException("Something goes wrong, please try later");
        }

        return jsonObject;
    }

    private JSONObject readJsonUrl(String url) throws IOException {
        try (InputStream inputStream = new URL(url).openStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
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

}
