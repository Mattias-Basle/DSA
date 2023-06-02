package designPatterns.FacadePattern;

public class TheaterLights {

    void on() {
        System.out.println("Lights are on");
    }

    void off() {
        System.out.println("Lights are off");
    }

    void dim(int percentage) {
        System.out.println("Brightness reduced by " + percentage + "%");
    }
}
