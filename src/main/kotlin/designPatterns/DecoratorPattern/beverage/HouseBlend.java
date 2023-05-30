package designPatterns.DecoratorPattern.beverage;

import designPatterns.DecoratorPattern.beverage.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
