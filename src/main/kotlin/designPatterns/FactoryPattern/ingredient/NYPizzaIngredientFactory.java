package designPatterns.FactoryPattern.ingredient;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return Dough.THIN_CRUST_DOUGH;
    }

    @Override
    public Sauce createSauce() {
        return Sauce.MARINARA_SAUCE;
    }

    @Override
    public Cheese createCheese() {
        return Cheese.REGGIANO_CHEESE;
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { Veggies.GARLIC, Veggies.ONION, Veggies.MUSHROOM, Veggies.RED_PEPPER };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return Pepperoni.SLICED_PEPPERONI;
    }

    @Override
    public Clams createClam() {
        return Clams.FRESH_CLAMS;
    }
}
