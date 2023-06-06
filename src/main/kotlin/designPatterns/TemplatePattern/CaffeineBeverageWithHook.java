package designPatterns.TemplatePattern;

public abstract class CaffeineBeverageWithHook {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()){
            addCondiments();
        }
    }

    void boilWater() {
        System.out.println("\nBoiling some water...");
    }

    abstract void brew();

    void pourInCup() {
        System.out.println("Pouring beverage into a cup...");
    }

    abstract void addCondiments();

    boolean customerWantsCondiments() {
        return true;
    }
}
