package designPatterns.CommandPattern;

import designPatterns.CommandPattern.ceilingFan.CeilingFan;
import designPatterns.CommandPattern.ceilingFan.CeilingFanOffCommand;
import designPatterns.CommandPattern.ceilingFan.CeilingFanOnCommand;
import designPatterns.CommandPattern.garageDoor.GarageDoor;
import designPatterns.CommandPattern.garageDoor.GarageDoorCloseCommand;
import designPatterns.CommandPattern.garageDoor.GarageDoorOpenCommand;
import designPatterns.CommandPattern.light.Light;
import designPatterns.CommandPattern.light.LightOffCommand;
import designPatterns.CommandPattern.light.LigthOnCommand;
import designPatterns.CommandPattern.stereo.Stereo;
import designPatterns.CommandPattern.stereo.StereoOffCommand;
import designPatterns.CommandPattern.stereo.StereoOnWithCDCommand;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo("Living Room");

        LigthOnCommand livingRoomLightOn = new LigthOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LigthOnCommand kitchenLightOn = new LigthOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand garageDoorClose = new GarageDoorCloseCommand(garageDoor);

        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        Command[] partyOn = { livingRoomLightOn, kitchenLightOn, stereoOnWithCD, garageDoorOpen };
        Command[] partyOff = { livingRoomLightOff, kitchenLightOff, stereoOff, garageDoorClose };

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        remoteControl.setCommands(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommands(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommands(2, ceilingFanOn, ceilingFanOff);
        remoteControl.setCommands(3, garageDoorOpen, garageDoorClose);
        remoteControl.setCommands(4, stereoOnWithCD, stereoOff);
        remoteControl.setCommands(6, partyOnMacro, partyOffMacro);

        System.out.println(remoteControl);
        remoteControl.onButtonPressed(6);
        remoteControl.offButtonPressed(6);
        System.out.println(remoteControl);
    }
}
