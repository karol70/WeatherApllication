package com.karol.models;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;

import java.io.InputStream;
import java.net.URL;

public class CurrentLocation {

    private InputStream local;
    private String city;

    public CurrentLocation(String city){
        this.city = city;
    }

    public void fetchLocalApi() {
        try {
            local = new URL("http://ip-api.com/xml").openConnection().getInputStream();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void fetchDataFromApi() {
        fetchLocalApi();
        XMLInputFactory inputFactory =
                XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader =
                    inputFactory.createXMLStreamReader(local);
            reader.next();

            while (reader.hasNext()) {
                int eventType = reader.getEventType();
                if (eventType == XMLStreamReader.START_ELEMENT) {
                    String el = reader.getLocalName();

                    if (el.equals("city")) {
                        city = reader.getElementText();
                    }
                }
                reader.next();
            }
            reader.close();
        } catch (XMLStreamException e) {
            e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public String getCity(){
        fetchDataFromApi();
        return city;
    }
}
