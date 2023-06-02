package designPatterns.CommandPattern.stereo;

public class Stereo {
    String room;
    int volume;

    public Stereo(String room) {
        this.room = room;
        volume = 5;
    }
    void on() {
        System.out.println(room + " stereo is on");
    };
    void off() {
        System.out.println(room + " stereo is off");
    };
    void setCd() {
        System.out.println(room + " stereo is set for CD input");
    };
    void setDvd() {
        System.out.println(room + " stereo is set for DVD input");
    };
    void setRadio() {
        System.out.println(room + " stereo is set for Radio input");
    };
    void setVolume(int volume) {
        this.volume = volume;
        System.out.println("The volume is set to: " + volume);
    };
}
