package pl.oskarpolak.weatherapi.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pl.oskarpolak.weatherapi.models.services.WeatherService;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private WeatherService weatherService = WeatherService.getService();

    @FXML
    Button buttonSend;

    @FXML
    TextField textCity;


    public void initialize(URL location, ResourceBundle resources) {
       buttonSend.setOnMouseClicked(e -> {
           if(!textCity.getText().isEmpty()) {
               weatherService.makeRequest(textCity.getText());
               textCity.clear();
           }
       });
    }
}
