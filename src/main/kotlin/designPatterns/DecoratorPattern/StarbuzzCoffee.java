package designPatterns.DecoratorPattern;

import designPatterns.DecoratorPattern.beverage.Beverage;
import designPatterns.DecoratorPattern.beverage.DarkRoast;
import designPatterns.DecoratorPattern.beverage.Espresso;
import designPatterns.DecoratorPattern.beverage.HouseBlend;
import designPatterns.DecoratorPattern.decorator.Mocha;
import designPatterns.DecoratorPattern.decorator.Soy;
import designPatterns.DecoratorPattern.decorator.Whip;

public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}
