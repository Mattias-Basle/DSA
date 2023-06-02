package designPatterns.CommandPattern.hottub;

public class Hottub {

    void circulate() {};
    void jetsOn() {};
    void jetsOff() {};
    void setTemperature(int temperature) {
        System.out.println("Temperature is " + temperature);
    }
}
