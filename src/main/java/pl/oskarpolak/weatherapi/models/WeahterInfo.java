package pl.oskarpolak.weatherapi.models;

public class WeahterInfo {
    private double temp;
    private int pressure;


    public WeahterInfo(double temp, int pressure) {
        this.temp = temp;
        this.pressure = pressure;
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
