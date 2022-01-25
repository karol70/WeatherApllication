package com.karol.models;

import com.karol.Config;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.*;

public class ForecastManager {

    private final String city;
    private List<WeatherParameters> forecastWeather = new ArrayList<>();
    public List<String> weekDayNameList = new ArrayList<>();


    public ForecastManager(String city) {
        this.city = city;
        forecastWeather.clear();
    }


    private Document getDocumentFromUrl() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            return db.parse(new URL("http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&units=metric&mode=xml&appid=" + Config.API_KEY).openStream());
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getDateInyyyymmddFormat(String date) {
        String dateInRightFormat = date.replace("-", "");
        dateInRightFormat = dateInRightFormat.substring(0, 8);

        return dateInRightFormat;

    }

    public String getWeekDayName(String date) {
        date = date.replace("-", "");
        Integer year = Integer.valueOf(date.substring(0, 4));
        Integer month = Integer.valueOf(date.substring(4, 6));
        Integer day = Integer.valueOf(date.substring(6, 8));
        Locale locale = Locale.forLanguageTag("en");

        Calendar calendar = Calendar.getInstance(locale);
        calendar.set(year, month - 1, day);

        DateFormatSymbols dfs = new DateFormatSymbols(locale);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        return dfs.getWeekdays()[weekday];

    }

    public List<WeatherParameters> getForecastWeather() {
        return forecastWeather;
    }

    public void getForecastData() {

        NodeList list = getDocumentFromUrl().getElementsByTagName("time");

        String lastloadedDay = "";

        for (int temp = 0; temp < list.getLength(); temp++) {
            Node node = list.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String date = element.getAttribute("from");

                String weekDayName = getWeekDayName(date);
                String dateDayFormatyyyymmdd = getDateInyyyymmddFormat(date);

                if (!dateDayFormatyyyymmdd.equals(lastloadedDay) && date.contains("12:00:00")) {
                    lastloadedDay = dateDayFormatyyyymmdd;
                    NodeList windSpeedNodeList = element.getElementsByTagName("windSpeed");
                    String windSpeed = windSpeedNodeList.item(0).getAttributes().getNamedItem("mps").getTextContent() + " m/s";
                    NodeList temperatureNodeList = element.getElementsByTagName("temperature");
                    String temperature = temperatureNodeList.item(0).getAttributes().getNamedItem("value").getTextContent() + " °C";
                    NodeList cloudinessNodeList = element.getElementsByTagName("clouds");
                    String cloudiness = cloudinessNodeList.item(0).getAttributes().getNamedItem("all").getTextContent() + " %";
                    NodeList pressureNodeList = element.getElementsByTagName("pressure");
                    String pressure = pressureNodeList.item(0).getAttributes().getNamedItem("value").getTextContent() + " hPa";
                    NodeList symbolNodeList = element.getElementsByTagName("symbol");
                    String icon = symbolNodeList.item(0).getAttributes().getNamedItem("var").getTextContent();

                    WeatherParameters weatherParameters = new WeatherParameters(temperature, cloudiness, windSpeed, pressure, icon);
                    forecastWeather.add(weatherParameters);
                    weekDayNameList.add(weekDayName);
                }
            }
        }
    }

}
