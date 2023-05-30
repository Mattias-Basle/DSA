package designPatterns.DecoratorPattern.decorator;

import designPatterns.DecoratorPattern.beverage.Beverage;
import designPatterns.DecoratorPattern.decorator.CondimentDecorator;

public class SteamedMilk extends CondimentDecorator {

    public SteamedMilk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Steamed Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + .10;
    }
}
