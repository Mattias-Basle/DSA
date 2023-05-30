package designPatterns.ObserverPattern.observer;

import designPatterns.ObserverPattern.subject.WeatherData;

public class ForecastDisplay implements Observer, DisplayElement {

    private float pressure;

    private Float lastPressure;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.lastPressure = null;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        this.pressure = weatherData.getPressure();
        display();
        this.lastPressure = pressure;
    }

    @Override
    public void display() {
        if (lastPressure == null || pressure > lastPressure) {
            System.out.println("Forecast: Improving weather on the way!");
        } else if (lastPressure == pressure) {
            System.out.println("Forecast: More of the same");
        } else {
            System.out.println("Forecast: Watch out for cooler, rainy weather");
        }
    }
}
