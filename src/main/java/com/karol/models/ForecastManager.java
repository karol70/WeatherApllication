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

    private static String city;
    private String date;
    private static String temperature;
    private static String cloudiness;
    private static String windSpeed;
    private static String pressure;
    private static String icon;
    public List<String> temper = new ArrayList<>();
    public List<String> clouds = new ArrayList<>();
    public List<String> wind = new ArrayList<>();
    public List<String> press = new ArrayList<>();
    public List<String> symbol = new ArrayList<>();
    public List<String> dayOfWeek = new ArrayList<>();



    public ForecastManager(String city) {
        this.city = city;
        temper.clear();
        clouds.clear();
        wind.clear();
        press.clear();
        symbol.clear();
        dayOfWeek.clear();
    }

    public void getForecastData() {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL("http://api.openweathermap.org/data/2.5/forecast?q="+city+"&units=metric&mode=xml&appid="+Config.API_KEY).openStream());
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("time");

            String dateDay = "x";
            String lastloadedDay = "";

                for (int temp = 0; temp < list.getLength(); temp++) {
                    Node node = list.item(temp);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        date = element.getAttribute("from");
                        date = date.replace("-", "");
                        Integer year = Integer.valueOf(date.substring(0,4));
                        Integer month = Integer.valueOf(date.substring(4,6));
                        Integer day = Integer.valueOf(date.substring(6,8));

                        Locale locale = Locale.forLanguageTag("en");

                        Calendar calendar = Calendar.getInstance(locale);
                        calendar.set(year,month -1,day);

                        DateFormatSymbols dfs = new DateFormatSymbols(locale);
                        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
                        String weekDay = dfs.getWeekdays()[weekday];

                       date = date.replace("T", "");
                       dateDay = date.substring(0, 8);

                        if (!dateDay.equals(lastloadedDay) && date.contains("12:00:00")) {
                            lastloadedDay = dateDay;
                            NodeList windSpeedNodeList = element.getElementsByTagName("windSpeed");
                            windSpeed = windSpeedNodeList.item(0).getAttributes().getNamedItem("mps").getTextContent() + " m/s";
                            NodeList temperatureNodeList = element.getElementsByTagName("temperature") ;
                            temperature = temperatureNodeList.item(0).getAttributes().getNamedItem("value").getTextContent() + " °C";
                            NodeList cloudinessNodeList = element.getElementsByTagName("clouds");
                            cloudiness = cloudinessNodeList.item(0).getAttributes().getNamedItem("all").getTextContent() + " %";
                            NodeList pressureNodeList = element.getElementsByTagName("pressure");
                            pressure = pressureNodeList.item(0).getAttributes().getNamedItem("value").getTextContent() + " hPa";
                            NodeList symbolNodeList = element.getElementsByTagName("symbol");
                            icon = symbolNodeList.item(0).getAttributes().getNamedItem("var").getTextContent();

                            temper.add(temperature);
                            clouds.add(cloudiness);
                            press.add(pressure);
                            wind.add(windSpeed);
                            symbol.add(icon);
                            dayOfWeek.add(weekDay);

                    }
                    }
                }

            } catch(ParserConfigurationException | SAXException | IOException e){
                e.printStackTrace();
            }

    }

}
