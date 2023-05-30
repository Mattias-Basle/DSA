package designPatterns.DecoratorPattern.decorator;

import designPatterns.DecoratorPattern.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    public abstract String getDescription();
}
