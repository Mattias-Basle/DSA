package designPatterns.ObserverPattern;

import designPatterns.ObserverPattern.observer.CurrentConditionsDisplay;
import designPatterns.ObserverPattern.observer.ForecastDisplay;
import designPatterns.ObserverPattern.observer.HeatIndexDisplay;
import designPatterns.ObserverPattern.observer.StatisticDisplay;
import designPatterns.ObserverPattern.subject.WeatherData;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticDisplay statisticDisplay = new StatisticDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
