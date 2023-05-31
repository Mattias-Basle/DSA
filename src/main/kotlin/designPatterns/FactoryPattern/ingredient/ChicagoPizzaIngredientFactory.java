package designPatterns.FactoryPattern.ingredient;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return Dough.THICK_CRUST_DOUGH;
    }

    @Override
    public Sauce createSauce() {
        return Sauce.PLUM_TOMATO_SAUCE;
    }

    @Override
    public Cheese createCheese() {
        return Cheese.MOZZARELLA_CHEESE;
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { Veggies.SPINACH, Veggies.EGGPLANT, Veggies.BLACK_OLIVES };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return Pepperoni.SLICED_PEPPERONI;
    }

    @Override
    public Clams createClam() {
        return Clams.FROZEN_CLAMS;
    }
}
