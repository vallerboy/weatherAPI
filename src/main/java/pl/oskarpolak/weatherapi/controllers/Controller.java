package pl.oskarpolak.weatherapi.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import pl.oskarpolak.weatherapi.models.IWeatherObserver;
import pl.oskarpolak.weatherapi.models.WeahterInfo;
import pl.oskarpolak.weatherapi.models.services.WeatherService;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable, IWeatherObserver{

    private WeatherService weatherService = WeatherService.getService();

    @FXML
    Button buttonSend;

    @FXML
    TextField textCity;

    @FXML
    Label textWeather;


    public void initialize(URL location, ResourceBundle resources) {
        weatherService.registerObserver(this);


       buttonSend.setOnMouseClicked(e -> {
           if(!textCity.getText().isEmpty()) {
               weatherService.makeRequest(textCity.getText());
               textCity.clear();
           }
       });

       textCity.setOnKeyPressed(e -> {
           if(e.getCode() == KeyCode.ENTER){
               weatherService.makeRequest(textCity.getText());
               textCity.clear();
           }
       });
    }

    @Override
    public void onWeatherUpdate(WeahterInfo info) {
        textWeather.setText("Temp: " + info.getTemp() + " | Cisnienie: " + info.getPressure());
    }
}
