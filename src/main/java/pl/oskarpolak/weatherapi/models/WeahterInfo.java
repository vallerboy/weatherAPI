package pl.oskarpolak.weatherapi.models;

public class WeahterInfo {
    private double temp;
    private int pressure;
    private String cityname;

    public WeahterInfo(double temp, int pressure, String cityname) {
        this.temp = temp;
        this.pressure = pressure;
        this.cityname = cityname;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }
}
