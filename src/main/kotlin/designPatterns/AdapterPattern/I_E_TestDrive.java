package designPatterns.AdapterPattern;

import java.util.ArrayList;
import java.util.Iterator;

public class I_E_TestDrive {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        initialize(list);

        Iterator iterator = list.iterator();

        IteratorEnumeration adapter = new IteratorEnumeration(iterator);

        for (int i=0; i < list.size(); i++) {
            if (adapter.hasMoreElements()) {
                System.out.println(adapter.nextElement());
            }
        }
    }

    static ArrayList initialize(ArrayList list) {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        return list;
    }
}
