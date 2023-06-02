package designPatterns.FacadePattern;

public class StreamingPlayer {

    void on() {
        System.out.println("Streaming player is on");
    }

    void off() {
        System.out.println("Streaming player is off");
    }

    void pause() {
        System.out.println("Pausing the streaming");
    }

    void play(String title) {
        System.out.println("Playing " + title);
    }

    void stop() {
        System.out.println("Stopping the streaming");
    }

    void setSurroundAudio() {}
    void setTwoChannelAudio() {}
}
