package pl.oskarpolak.weatherapi.models.services;

import pl.oskarpolak.weatherapi.models.Config;
import pl.oskarpolak.weatherapi.models.Utils;

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
        System.out.println(Utils.makeHttpRequest(Config.APP_BASE_URL + city + "&appid=" + Config.APP_ID));
    }
}
