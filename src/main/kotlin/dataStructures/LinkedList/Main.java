package dataStructures.LinkedList;

public class Main {
    public static void main(String[] args) {
        singly();
//        doubly();
//        circular();
    }

    static void singly() {
        CustomSingly list = new CustomSingly();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);

        list.insertLast(99);

        list.insert(100, 3);
        list.display();

        System.out.println(list.deleteFirst());
        list.display();

        System.out.println(list.deleteLast());
        list.display();

        System.out.println(list.delete(2));
        list.display();

        list.insertRecursion(88, 2);
        list.display();
    }

    static void doubly() {
        CustomDoubly list = new CustomDoubly();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);

        list.insertLast(99);

        list.insert(100, 3);
        list.display();

        list.insert(65, list.find(100));
        list.display();

//        System.out.println(list.deleteFirst());
//        list.display();
//
//        System.out.println(list.deleteLast());
//        list.display();
//
//        System.out.println(list.delete(2));
//        list.display();
//
//        System.out.println(list.find(2));
//        System.out.println(list.find(12));
    }

    static void circular() {
        CustomCircular list = new CustomCircular();
        list.insertLast(23);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(17);
        list.insertLast(98);
        list.display();

        list.delete(3);
        list.display();
    }
}
