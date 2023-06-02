package designPatterns.CommandPattern.garageDoor;

public class GarageDoor {
    public void up() {
        System.out.println("Garage Door is open");
    };
    public void down() {
        System.out.println("Garage Door is close");
    };
    public void stop() {};
    public void lightOn() {};
    public void lightOff() {};
}
