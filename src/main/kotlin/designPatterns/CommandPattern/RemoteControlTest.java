package designPatterns.CommandPattern;

import designPatterns.CommandPattern.garageDoor.GarageDoor;
import designPatterns.CommandPattern.garageDoor.GarageDoorOpenCommand;
import designPatterns.CommandPattern.light.Light;
import designPatterns.CommandPattern.light.LigthOnCommand;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light("Test");
        LigthOnCommand lightOn = new LigthOnCommand(light);

        remote.setCommand(lightOn);
        remote.buttonPressed();

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);

        remote.setCommand(garageOpen);
        remote.buttonPressed();
    }
}
