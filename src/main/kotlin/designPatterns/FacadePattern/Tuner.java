package designPatterns.FacadePattern;

public class Tuner {
    Amplifier amplifier;
    int frequency;

    void on() {
        System.out.println("The tuner is on");
    }

    void off() {
        System.out.println("The tuner is off");
    }

    void setAm() {}
    void setFm() {}
    void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
