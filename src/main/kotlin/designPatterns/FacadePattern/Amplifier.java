package designPatterns.FacadePattern;

public class Amplifier {
    Tuner tuner;
    StreamingPlayer player;

    void on() {
        System.out.println("The amplifier is on");
    }

    void off() {
        System.out.println("The amplifier is off");
    }

    void setStreamingPlayer(StreamingPlayer player) {
        this.player = player;
    }
    void setStereoSound() {}
    void setSurroundSound() {}
    void setTuner(Tuner tuner) {
        this.tuner = tuner;
    }
    void setVolume(int volume) {
        System.out.println("The volume is " + volume);
    }
}
