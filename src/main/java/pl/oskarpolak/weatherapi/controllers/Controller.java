package pl.oskarpolak.weatherapi.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.oskarpolak.weatherapi.models.IWeatherObserver;
import pl.oskarpolak.weatherapi.models.WeahterInfo;
import pl.oskarpolak.weatherapi.models.WeatherModel;
import pl.oskarpolak.weatherapi.models.dao.WeatherDao;
import pl.oskarpolak.weatherapi.models.dao.impl.WeatherDaoImpl;
import pl.oskarpolak.weatherapi.models.services.WeatherService;

import java.io.IOException;
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

    @FXML
    ProgressIndicator progressIndi;

    @FXML
    Button buttonCharts;

    private WeatherDao weatherDao = new WeatherDaoImpl();

    public void initialize(URL location, ResourceBundle resources) {
        progressIndi.setVisible(false);
        textWeather.setVisible(false);


        weatherService.registerObserver(this);


       buttonSend.setOnMouseClicked(e -> {
           if(!textCity.getText().isEmpty()) {
               progressIndi.setVisible(true);
               textWeather.setVisible(false);

               weatherService.makeRequest(textCity.getText());
               textCity.clear();
           }
       });

       textCity.setOnKeyPressed(e -> {
           if(e.getCode() == KeyCode.ENTER){
               progressIndi.setVisible(true);
               textWeather.setVisible(false);

               weatherService.makeRequest(textCity.getText());
               textCity.clear();
           }
       });


       buttonCharts.setOnMouseClicked(e -> goToCharts());
    }

    private void goToCharts() {
        Stage stage = (Stage) buttonCharts.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("chartView.fxml"));
            stage.setScene(new Scene(root, 600,400));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onWeatherUpdate(WeahterInfo info) {
        textWeather.setText("Temp: " + info.getTemp() + " | Cisnienie: " + info.getPressure());
        progressIndi.setVisible(false);
        textWeather.setVisible(true);

        weatherDao.addWeather(new WeatherModel(info));
    }
}
