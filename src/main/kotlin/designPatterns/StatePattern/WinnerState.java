package designPatterns.StatePattern;

public class WinnerState implements State {
    private static final long serialVersionUID = 2L;
    transient GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    };
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    };
    public void turnCrank() {
        System.out.println("Sorry, you already turned the crank");
    };
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.releaseBall();
            System.out.println("YOU'RE A WINNER! You've received an extra gumball");
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("Oops, out of gumballs");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    };
}