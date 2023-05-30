package designPatterns.StrategyPattern.ducks;

import designPatterns.StrategyPattern.behaviors.quack.Quack;
import designPatterns.StrategyPattern.behaviors.fly.FlyNoWay;

public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
