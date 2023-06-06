package designPatterns.CompositePattern;

public class MenuTestDrive {
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu(
                "PANCAKE HOUSE MENU", "Breakfast"
        );
        MenuComponent dinerMenu = new Menu(
                "DINER MENU", "Lunch"
        );
        MenuComponent cafeMenu = new Menu(
                "CAFE MENU", "Dinner"
        );
        MenuComponent dessertMenu = new Menu(
                "DESSERT MENU", "Dessert of course!"
        );

        MenuComponent allMenus = new Menu(
                "ALL MENUS", "All menus combined"
        );
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        pancakeHouseMenu.add(new MenuItem(
                "K&B's Pancake Breakfast", "Pancake with scrambled eggs and toast",
                true, 2.99
        ));
        pancakeHouseMenu.add(new MenuItem(
                "Regular Pancake Breakfast", "Pancake with fried eggs, sausage",
                false, 2.99
        ));
        pancakeHouseMenu.add(new MenuItem(
                "Waffles", "Waffles with your choice of blueberries or strawberries",
                true, 3.5
        ));

        dinerMenu.add(new MenuItem(
                "Pasta", "Spaghetti with Marinara sauce and a slice of bread",
                true, 3.89
        ));
        dinerMenu.add(new MenuItem(
                "Hotdog", "A hot dog, with sauerkraut, relish onions topped with cheese",
                false, 3.05
        ));
        dinerMenu.add(new MenuItem(
                "Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat",
                true, 2.99
        ));
        dinerMenu.add(dessertMenu);

        cafeMenu.add(new MenuItem(
                "Soup of the day", "A cup of the soup, with a side salad",
                true, 3.69
        ));
        cafeMenu.add(new MenuItem(
                "Burrito", "A large burrito, with whole pinto beans, salsa, guacamole",
                false, 4.29
        ));
        cafeMenu.add(new MenuItem(
                "Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato and fries", true, 3.99
        ));

        dessertMenu.add(new MenuItem(
                "Apple Pie", "Apple pie with flakey crust",
                true, 1.59
        ));
        dessertMenu.add(new MenuItem(
                "Blueberry Pancakes", "Pancake made with fresh blueberries",
                true, 3.49
        ));

        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
    }
}
