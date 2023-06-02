package designPatterns.CommandPattern.tv;

public class TV {

    void on() {};
    void off() {};
    void setInputChannel(int channel) {
        System.out.println("Channel changed to " + channel);
    }
    void setVolume(int volume) {
        System.out.println("Volume is " + volume);
    }
}
