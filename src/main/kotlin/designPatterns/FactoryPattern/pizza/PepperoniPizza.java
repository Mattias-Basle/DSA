package designPatterns.FactoryPattern.pizza;

import designPatterns.FactoryPattern.ingredient.PizzaIngredientFactory;
import designPatterns.FactoryPattern.pizza.Pizza;

public class PepperoniPizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        pepperoni = ingredientFactory.createPepperoni();
        veggies = ingredientFactory.createVeggies();
    }
}
