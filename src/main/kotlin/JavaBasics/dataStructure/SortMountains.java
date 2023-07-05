package JavaBasics.dataStructure;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SortMountains {
    LinkedList<Mountain> mtn = new LinkedList<>();

    class NameCompare implements Comparator<Mountain> {
        public int compare(Mountain o1, Mountain o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    class HeigthCompare implements Comparator<Mountain> {
        public int compare(Mountain o1, Mountain o2) {
            return (o2.height - o1.height);
        }
    }

    class Mountain {
        String name;
        int height;

        public Mountain(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return (name + " " + height);
        }
    }

    public void go() {
        mtn.add(new Mountain("Longs", 14255));
        mtn.add(new Mountain("Elbert", 14433));
        mtn.add(new Mountain("Maroon", 14156));
        mtn.add(new Mountain("Castle", 14265));

        System.out.println("as entered: \n" + mtn);

        NameCompare nc = new NameCompare();
        Collections.sort(mtn, nc);
        System.out.println("by name: \n" + mtn);

        HeigthCompare hc = new HeigthCompare();
        Collections.sort(mtn, hc);
        System.out.println("by height: \n" + mtn);
    }

    public static void main(String[] args) {
        new SortMountains().go();
    }
}
