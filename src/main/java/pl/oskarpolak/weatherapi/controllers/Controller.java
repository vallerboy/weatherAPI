package pl.oskarpolak.weatherapi.controllers;

import javafx.fxml.Initializable;
import pl.oskarpolak.weatherapi.models.services.WeatherService;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private WeatherService weatherService = WeatherService.getService();


    public void initialize(URL location, ResourceBundle resources) {
        weatherService.makeRequest("Cracow");
    }
}
