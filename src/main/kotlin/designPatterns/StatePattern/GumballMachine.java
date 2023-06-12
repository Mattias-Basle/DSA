package designPatterns.StatePattern;

import designPatterns.ProxyPattern.remoteProxy.GumballMachineRemote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
    private static final long serialVersionUID = 2L;
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state;
    int count = 0;
    String location;

    public GumballMachine(int count, String location) throws RemoteException {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuaterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.location = location;

        this.count = count;
        if (count > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out...");
        if (count > 0) {
            count--;
        }
    }
    void refill(int gumballs) {
        if (gumballs > 0) {
            System.out.println("Refilling the machine");
            count = count + gumballs;
            state = noQuarterState;
            System.out.println("Refilled done");
        }
    }

    public int getCount() {
        return count;
    }

    public String getLocation() {
        return location;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nMighty Gumball, Inc.\n");
        builder.append("Java-enabled Standing Gumball Model #2004\n");
        builder.append("Location area: " + getLocation() + "\n");
        builder.append("Inventory: " + count + " gumballs\n");

        if (noQuarterState.equals(state)) {
            builder.append(
                    "Machine is waiting for quarter\n"
            );
        } else if (soldOutState.equals(state)) {
            builder.append(
                    "Machine is sold out\n"
            );
        } else if (hasQuarterState.equals(state)) {
            builder.append(
                    "Ready to deliver a gumball, waiting for the crank...\n"
            );
        } else if (soldState.equals(state)) {
            builder.append(
                    "Gumball delivery ongoing...\n"
            );
        }
        return builder.toString();
    }
}
