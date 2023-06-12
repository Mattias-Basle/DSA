package designPatterns.StatePattern;

public class SoldOutState implements State {
    private static final long serialVersionUID = 2L;
    transient GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    };
    public void ejectQuarter() {
        System.out.println("You can't eject, no quarter inserted");
    };
    public void turnCrank() {
        System.out.println("You turned but there's no gumballs");
    };
    public void dispense() {
        System.out.println("No gumball dispensed");
    };
}
