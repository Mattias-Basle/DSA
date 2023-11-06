package dataStructures.Hashing;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        CustomHashMap1 map1 = new CustomHashMap1();

        map1.put("Mango", "King of Fruit");
        map1.put("Apple", "No doctor needed");
        map1.put("Banana", "High in potassium");

        System.out.println(map1.get("Banana"));

        map1.remove("Mango");

        CustomHashMap2<String, String> map2 = new CustomHashMap2<>();

        map2.put("Mango", "King of Fruit");
        map2.put("Apple", "No doctor needed");
        map2.put("Banana", "High in potassium");

        System.out.println(map2);

        System.out.println(map1.get("Banana"));

        map2.remove("Mango");

        System.out.println(map2);
    }
}
