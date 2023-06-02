package designPatterns.CommandPattern.ceilingFan;

public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String room;
    int speed;

    public CeilingFan(String room) {
        this.room = room;
        speed = OFF;
    }

    void high() {
        speed = HIGH;
        System.out.println(room + " ceiling fan is on high");
    };
    void medium() {
        speed = MEDIUM;
        System.out.println(room + " ceiling fan is on medium");
    };
    void low() {
        speed = LOW;
        System.out.println(room + " ceiling fan is on low");
    };
    void off() {
        speed = OFF;
        System.out.println(room + " ceiling fan is off");
    };
    int getSpeed() {
        return speed;
    };
}
