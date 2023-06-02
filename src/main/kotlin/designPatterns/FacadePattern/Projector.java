package designPatterns.FacadePattern;

public class Projector {
    void on () {
        System.out.println("The projector is on");
    }

    void off() {
        System.out.println("The projector is off");
    }

    void tvMode() {
        System.out.println("You're watching tv");
    }

    void wideScreenMode() {
        System.out.println("Ready for wide screen");
    }
}
