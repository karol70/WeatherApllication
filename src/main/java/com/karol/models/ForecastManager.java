package com.karol.models;

import com.karol.Config;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ForecastManager {

    private static String city;
    private String date;
    private static String temperature;
    private static String cloudiness;
    private static String windSpeed;
    private static String pressure;
    private String description;
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String TIME_FORMAT = "HH:mm:ss";
    private static final String TIME_WEATHER = "06:00:00";
    public List<String> forecast = new ArrayList<>();


    public ForecastManager(String city) throws ParserConfigurationException {
        this.city = city;
    }

    public void readXML() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL("http://api.openweathermap.org/data/2.5/forecast?q=Warsaw&units=metric&mode=xml&appid=f41de213ca2d15bfae5942d62edebf90").openStream());
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
            System.out.println("--------");

            NodeList list = doc.getElementsByTagName("time");

            String dateDay = "x";
            String lastloadedDay = "";

                for (int temp = 0; temp < list.getLength(); temp++) {
                    Node node = list.item(temp);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        date = element.getAttribute("from");
                        date = date.replace("-", "");
                        date = date.replace("T", "");
                        dateDay = date.substring(0, 8);

                        if (!dateDay.equals(lastloadedDay) && date.contains("12:00:00")) {
                            lastloadedDay = dateDay;
                            NodeList windSpeedNodeList = element.getElementsByTagName("windSpeed");
                            windSpeed = windSpeedNodeList.item(0).getAttributes().getNamedItem("mps").getTextContent() + " m/s";
                            NodeList temperatureNodeList = element.getElementsByTagName("temperature") ;
                            temperature = temperatureNodeList.item(0).getAttributes().getNamedItem("value").getTextContent() + " oC";
                            NodeList cloudinessNodeList = element.getElementsByTagName("clouds");
                            cloudiness = cloudinessNodeList.item(0).getAttributes().getNamedItem("all").getTextContent() + " %";
                            NodeList pressureNodeList = element.getElementsByTagName("pressure");
                            pressure = pressureNodeList.item(0).getAttributes().getNamedItem("value").getTextContent() + " hPa";

                            forecast.add( "Temperature:" + temperature + " Pressure:"+ pressure +" Windspeed:" + windSpeed + " Clouds:" + cloudiness);
                    }
                    }
                }

            } catch(ParserConfigurationException | SAXException | IOException e){
                e.printStackTrace();
            }
        System.out.println(forecast.get(0));
        System.out.println(forecast.get(1));
        System.out.println(forecast.get(2));
        System.out.println(forecast.get(3));
        System.out.println(forecast.get(4));

    }
}
