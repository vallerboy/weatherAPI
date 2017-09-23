package pl.oskarpolak.weatherapi.models.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {
    private static WeatherService ourInstance = new WeatherService();

    public static WeatherService getService() {
        return ourInstance;
    }

    private WeatherService() {

    }

    public void makeRequest(String city){
    }
}
