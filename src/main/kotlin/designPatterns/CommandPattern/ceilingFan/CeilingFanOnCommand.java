package designPatterns.CommandPattern.ceilingFan;

import designPatterns.CommandPattern.Command;

public class CeilingFanOnCommand implements Command {
    CeilingFan fan;
    int previousSpeed;

    public CeilingFanOnCommand(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        previousSpeed = fan.getSpeed();
        switch (previousSpeed) {
            case CeilingFan.LOW -> fan.medium();
            case CeilingFan.MEDIUM -> fan.high();
            case CeilingFan.HIGH -> fan.low();
        }
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
