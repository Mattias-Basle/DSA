package dataStructures.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InBuilt {
    public static void main(String[] args) {
        queue();
        deque();
    }

    static void queue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(6);
        queue.add(5);

        System.out.println("current top: " + queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }

    static void deque() {
        Deque<Integer> deck = new ArrayDeque<>();
        deck.add(89);
        deck.addLast(78);
        deck.removeFirst();
    }
}
