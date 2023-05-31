package designPatterns.FactoryPattern;

import designPatterns.FactoryPattern.pizza.Pizza;
import designPatterns.FactoryPattern.pizza.ChicagoStylePizzaStore;
import designPatterns.FactoryPattern.pizza.NYStylePizzaStore;
import designPatterns.FactoryPattern.pizza.PizzaStore;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
