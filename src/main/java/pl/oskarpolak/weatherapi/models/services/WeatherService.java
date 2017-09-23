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
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(
                    "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + "ef2028e98b54649bf1f4c4582631f350")
                    .openConnection();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
