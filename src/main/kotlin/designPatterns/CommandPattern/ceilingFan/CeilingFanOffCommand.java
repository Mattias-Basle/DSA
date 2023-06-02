package designPatterns.CommandPattern.ceilingFan;

import designPatterns.CommandPattern.Command;

public class CeilingFanOffCommand implements Command {
    CeilingFan fan;
    int previousSpeed;

    public CeilingFanOffCommand(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        previousSpeed = fan.getSpeed();
        fan.off();
    }

    @Override
    public void undo() {
        switch (previousSpeed) {
            case CeilingFan.LOW -> fan.low();
            case CeilingFan.MEDIUM -> fan.medium();
            case CeilingFan.HIGH -> fan.high();
        }
    }
}
