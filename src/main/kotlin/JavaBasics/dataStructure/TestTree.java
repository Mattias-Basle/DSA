package JavaBasics.dataStructure;

import org.jetbrains.annotations.NotNull;

import java.util.TreeSet;

public class TestTree {
    public static void main(String[] args) {
        new TestTree().go();
    }

    public void go() {
        Book b1 = new Book("How Cats Work");
        Book b2 = new Book("Remix your Body");
        Book b3 = new Book("Finding Emo");

        TreeSet<Book> treeSet = new TreeSet<>();
        treeSet.add(b1);
        treeSet.add(b2);
        treeSet.add(b3);
        System.out.println(treeSet);
    }

    class Book implements Comparable<Book> {
        String title;
        public Book (String t) {
            title = t;
        }

        public int compareTo(@NotNull Book o) {
            return title.compareTo(o.title);
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
