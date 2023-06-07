package designPatterns.StatePattern;

public class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
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
        System.out.println("A gumball comes rolling");
        if (gumballMachine.getCount() > 0) {
            gumballMachine.count--;
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    };
}
