package designPatterns.MVC;

import javax.sound.sampled.Clip;
import java.util.ArrayList;
import java.util.List;

public class HeartModel implements HeartModelInterface, Runnable{
    List<BeatObserver> beatObservers = new ArrayList<>();
    List<BPMObserver> bpmObservers = new ArrayList<>();
    int bpm = 68;
    Thread thread;
    boolean stop = false;
    Clip clip;

    public void on() {
        bpm = 90;
        notifyBPMObservers();
        thread = new Thread(this);
        stop = false;
        thread.start();
    }

    public void off() {
        stopBeat();
        stop = true;
    }

    public void run() {
        while (!stop) {
            playBeat();
            notifyBeatObservers();
            try {
                Thread.sleep(60000/getHeartRate());
            } catch (Exception e) {}
        }
    }

    @Override
    public int getHeartRate() {
        return bpm;
    }

    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    public void notifyBeatObservers() {
        for(int i = 0; i < beatObservers.size(); i++) {
            BeatObserver observer = (BeatObserver) beatObservers.get(i);
            observer.updateBeat();
        }
    }

    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    public void notifyBPMObservers() {
        for(int i = 0; i < bpmObservers.size(); i++) {
            BPMObserver observer = (BPMObserver) bpmObservers.get(i);
            observer.updateBPM();
        }
    }

    public void removeObserver(BeatObserver o) {
        int i = beatObservers.indexOf(o);
        if (i >= 0) {
            beatObservers.remove(i);
        }
    }

    public void removeObserver(BPMObserver o) {
        int i = bpmObservers.indexOf(o);
        if (i >= 0) {
            bpmObservers.remove(i);
        }
    }

    public void playBeat() {
        clip.setFramePosition(0);
        clip.start();
    }
    public void stopBeat() {
        clip.setFramePosition(0);
        clip.stop();
    }
}
