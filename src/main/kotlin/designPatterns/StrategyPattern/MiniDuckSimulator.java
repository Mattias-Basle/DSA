package designPatterns.StrategyPattern;

import designPatterns.StrategyPattern.behaviors.fly.FlyRocketPowered;
import designPatterns.StrategyPattern.ducks.Duck;
import designPatterns.StrategyPattern.ducks.MallardDuck;
import designPatterns.StrategyPattern.ducks.ModelDuck;

public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
