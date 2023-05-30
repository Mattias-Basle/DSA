package designPatterns.StrategyPattern.ducks;

import designPatterns.StrategyPattern.behaviors.quack.Quack;
import designPatterns.StrategyPattern.behaviors.fly.FlyWithWings;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
