package designPatterns.TemplatePattern;

public class CaffeineTest {
    public static void main(String[] args) {
        Tea myTea = new Tea();
        myTea.prepareRecipe();

        Coffee myCoffee = new Coffee();
        myCoffee.prepareRecipe();

        CoffeeWithHook coffeeHook = new CoffeeWithHook();
        coffeeHook.prepareRecipe();

        TeaWithHook teaHook = new TeaWithHook();
        teaHook.prepareRecipe();
    }
}
