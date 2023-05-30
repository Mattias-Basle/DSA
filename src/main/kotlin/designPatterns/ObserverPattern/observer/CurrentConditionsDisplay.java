package designPatterns.ObserverPattern.observer;

import designPatterns.ObserverPattern.subject.WeatherData;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature, humidity;
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degress and "
        + humidity + "% humidity");
    }
}