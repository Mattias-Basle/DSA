package designPatterns.DecoratorPattern.decorator;

import designPatterns.DecoratorPattern.beverage.Beverage;
import designPatterns.DecoratorPattern.decorator.CondimentDecorator;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + .15;
    }
}
