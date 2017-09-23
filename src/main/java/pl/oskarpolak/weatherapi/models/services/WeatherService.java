package pl.oskarpolak.weatherapi.models.services;

import org.json.JSONObject;
import pl.oskarpolak.weatherapi.models.Config;
import pl.oskarpolak.weatherapi.models.IWeatherObserver;
import pl.oskarpolak.weatherapi.models.Utils;
import pl.oskarpolak.weatherapi.models.WeahterInfo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {
    private static WeatherService ourInstance = new WeatherService();

    public static WeatherService getService() {
        return ourInstance;
    }
    private IWeatherObserver observer;

    private WeatherService() {

    }

    public void makeRequest(String city){
        readJsonData(Utils.makeHttpRequest(Config.APP_BASE_URL + city + "&appid=" + Config.APP_ID));
    }



    private void readJsonData(String json){
        JSONObject root = new JSONObject(json);
        JSONObject main = root.getJSONObject("main");


        int pressure = main.getInt("pressure");
        double temp = main.getDouble("temp");

        observer.onWeatherUpdate(new WeahterInfo(temp, pressure));
    }

    public void registerObserver(IWeatherObserver observer){
        this.observer = observer;
    }
}
