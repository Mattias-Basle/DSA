package designPatterns.TemplatePattern;

public abstract class CaffeineBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    void boilWater() {
        System.out.println("\nBoiling some water...");
    }

    abstract void brew();

    void pourInCup() {
        System.out.println("Pouring beverage into a cup...");
    }

    abstract void addCondiments();
}
