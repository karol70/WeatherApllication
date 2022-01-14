module WeatherApllication {

    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires json;
    requires java.xml;
    requires log4j;
    requires json.simple;

    opens com.karol;
    opens com.karol.controllers;
    opens fxml;


}
