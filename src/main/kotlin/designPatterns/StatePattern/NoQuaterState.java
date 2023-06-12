package designPatterns.StatePattern;

public class NoQuaterState implements State {
    private static final long serialVersionUID = 2L;
    transient GumballMachine gumballMachine;

    public NoQuaterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    public void insertQuarter() {
        System.out.println("You've inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    };
    public void ejectQuarter() {
        System.out.println("No quarter inserted");
    };
    public void turnCrank() {
        System.out.println("You turned but there's no quarter");
    };
    public void dispense() {
        System.out.println("You need to pay first");
    };
}
