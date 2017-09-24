package pl.oskarpolak.weatherapi.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;

import javax.swing.text.html.ListView;
import java.net.URL;
import java.util.ResourceBundle;

public class ChartController implements Initializable{

    @FXML
    BarChart chartTemp;

    @FXML
    ListView listCities;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
