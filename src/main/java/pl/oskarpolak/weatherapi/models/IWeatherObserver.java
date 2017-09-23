package pl.oskarpolak.weatherapi.models;

public interface IWeatherObserver {
    void onWeatherUpdate(WeahterInfo info);
}
