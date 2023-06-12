package designPatterns.ProxyPattern.remoteProxy;

import java.rmi.Naming;

public class GumballMonitorTestDrive {
    public static void main(String[] args) {
        String[] location = {
                "rmi://santafe.mightygumball.com/gumballmachine",
                "rmi://boulder.mightygumball.com/gumballmachine",
                "rmi://austin.mightygumball.com/gumballmachine"
        };
        GumballMonitor[] monitors = new GumballMonitor[location.length];

        for (int i = 0; i < location.length; i++) {
            try {
                GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]);
                monitors[i] = new GumballMonitor(machine);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < monitors.length; i++) {
            monitors[i].report();
        }
    }
}
