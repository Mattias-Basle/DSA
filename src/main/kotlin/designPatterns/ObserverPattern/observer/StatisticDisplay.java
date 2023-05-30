package designPatterns.ObserverPattern.observer;

import designPatterns.ObserverPattern.observer.DisplayElement;
import designPatterns.ObserverPattern.observer.Observer;
import designPatterns.ObserverPattern.subject.WeatherData;

import java.util.ArrayList;
import java.util.List;

public class StatisticDisplay implements Observer, DisplayElement {
    private float temperature, humidity, pressure;

    private Float minTemp, maxTemp;

    private List<Float> temperatures;
    private WeatherData weatherData;

    public StatisticDisplay(WeatherData weatherData) {
        this.maxTemp = 0f;
        this.minTemp = null;
        this.temperatures = new ArrayList<>();
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.temperatures.add(temperature);
        if (temperature > maxTemp) {
            this.maxTemp = temperature;
        }
        if (minTemp == null || temperature < minTemp) {
            this.minTemp = temperature;
        }
        display();
    }

    public float average() {
        float sum = temperatures.stream().reduce(0f, (subtotal, temp) ->  subtotal + temp);
        return sum/temperatures.size();
    }



    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + average() + "/"
        + maxTemp + "/" + minTemp);
    }
}
